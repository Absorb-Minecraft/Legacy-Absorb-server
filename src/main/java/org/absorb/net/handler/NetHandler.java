package org.absorb.net.handler;

import net.kyori.adventure.text.Component;
import org.absorb.AbsorbManagers;
import org.absorb.Main;
import org.absorb.net.Client;
import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.IncomingPacketBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Optional;

public class NetHandler {

    private final ServerSocket server;
    private ConnectionHandler currentlyRunning;

    private static final class IncomingPacket implements Runnable {

        private final Client netInfo;
        private byte[] data = new byte[0];

        private IncomingPacket(Client client) {
            this.netInfo = client;
        }

        @Override
        public void run() {
            InputStream is;
            try {
                is = this.netInfo.getSocket().getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            int length = 100;
            try {
                while (this.netInfo.getSocket().isConnected() && !this.netInfo.getSocket().isClosed() && this.netInfo
                        .getLastPacketSentTime()
                        .plus(30, ChronoUnit.SECONDS)
                        .isAfter(LocalDateTime.now())) {

                    if (this.data.length > length) {
                        this.data = new byte[0];
                        System.err.println("Cleared cache");
                    }
                    int b = is.read();
                    if (b == -1) {
                        if (this.data.length != 0) {
                            this.addByte(0);
                        }
                        continue;
                    }
                    this.netInfo.setLastPacketSentTime(LocalDateTime.now());
                    this.addByte(b);
                    try {
                        length = NetSerializers.VAR_INTEGER.read(0, ByteBuffer.wrap(this.data)).value();
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("Problem reading: skipping:");
                        System.err.println("\t" + e.getMessage());
                        System.err.println("\t" + Arrays.toString(this.data));
                    }

                    if (this.data.length <= length) {
                        continue;
                    }
                    try {
                        boolean cont = this.processPacket();
                    /*if (!cont) {
                        break;
                    }*/
                    } catch (Throwable e) {
                        e.printStackTrace();
                        this.netInfo.disconnect(Component.text("Server side error occurred: " + e.getMessage()));
                    }
                    length = 100;
                    this.data = new byte[0];
                }
            } catch (SocketException ignored) {
            } catch (Throwable e) {
                e.printStackTrace();
            }
            ByteBuffer buffer = ByteBuffer.wrap(this.data);
            AbsorbManagers.getNetManager().unregister(this.netInfo);
            try {
                this.netInfo.getSocket().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (this.data.length == 0) {
                return;
            }
            System.err.println("Data was left in cache");
            NetEntryData<Integer> lengthEntry;
            NetEntryData<Integer> idEntry;
            try {
                lengthEntry = NetSerializers.VAR_INTEGER.read(0, buffer);
            } catch (IndexOutOfBoundsException e) {
                return;
            }
            try {
                idEntry = NetSerializers.VAR_INTEGER.read(lengthEntry.endingPosition(), buffer);
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Failed to read id");
                System.err.println("Length: " + lengthEntry);
                return;
            }
            System.err.println("Length: " + lengthEntry.value());
            System.err.println("Id: " + idEntry.value());
            System.err.println("Data left: " + (this.data.length - idEntry.endingPosition()));
        }

        private void addByte(int b) {
            byte[] newData = new byte[this.data.length + 1];
            System.arraycopy(this.data, 0, newData, 0, this.data.length);
            newData[this.data.length] = (byte) b;
            this.data = newData;
        }

        private boolean processPacket() throws IOException {
            ByteBuffer data = ByteBuffer.wrap(this.data);
            NetEntryData<Integer> lengthEntry = NetSerializers.VAR_INTEGER.read(0, data);
            NetEntryData<Integer> packetId = NetSerializers.VAR_INTEGER.read(lengthEntry.endingPosition(), data);

            Optional<IncomingPacketBuilder<? extends org.absorb.net.packet.IncomingPacket>> builder = AbsorbManagers
                    .getNetManager()
                    .getIncomingPacketBuilder(packetId.value(), this.netInfo.getState());
            if (builder.isEmpty()) {
                System.err.println(
                        "User found to have sent a unknown packet, potentially cheating. Kicking to be safe(Id: "
                                + packetId.value() + "(" + Integer.toHexString(packetId.value()) + ") State: "
                                + this.netInfo.getState().name() + ")");
                //this.netInfo.getSocket().close();
                return false;
            }
            byte[] packetData = Arrays.copyOfRange(this.data, packetId.endingPosition(), this.data.length);

            org.absorb.net.packet.IncomingPacket packet = builder
                    .get()
                    .from(this.netInfo, ByteBuffer.wrap(packetData))
                    .build();
            packet.getProcess().onProcess(this.netInfo, packet);
            return true;
        }
    }

    private final class ConnectionHandler implements Runnable {

        private boolean running = true;

        public void stop() {
            this.running = false;
        }

        @Override
        public void run() {
            while (this.running || Main.IS_RUNNING) {
                try {
                    Socket clientSocket = NetHandler.this.server.accept();
                    //clientSocket.setReuseAddress(true);
                    clientSocket.setTcpNoDelay(true);
                    Client info = new Client(clientSocket);
                    AbsorbManagers.getNetManager().register(info);
                    new NetHandler.IncomingPacket(info).run();
                    //new Thread(new IncomingPacket(info)).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public NetHandler(ServerSocket server) {
        this.server = server;
    }

    public void start() {
        this.currentlyRunning = new ConnectionHandler();
        new Thread(this.currentlyRunning).start();
        //this.currentlyRunning.run();
    }

    public void end() {
        if (this.currentlyRunning != null) {
            this.currentlyRunning.stop();
        }
    }
}
