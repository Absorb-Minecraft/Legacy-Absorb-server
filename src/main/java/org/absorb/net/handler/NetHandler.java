package org.absorb.net.handler;

import org.absorb.AbsorbManagers;
import org.absorb.net.Client;
import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.Serializers;
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

    public NetHandler(ServerSocket server) {
        this.server = server;
    }

    public void start() {
        this.currentlyRunning = new ConnectionHandler();
        new Thread(this.currentlyRunning).start();
        //this.currentlyRunning.run();
    }

    public void end() {
        if (this.currentlyRunning!=null) {
            this.currentlyRunning.stop();
        }
    }

    private static final class IncomingPacket implements Runnable {

        private final Client netInfo;
        private byte[] data = new byte[0];

        private IncomingPacket(Client client) {
            this.netInfo = client;
        }

        private void addByte(int b) {
            byte[] newData = new byte[data.length + 1];
            System.arraycopy(data, 0, newData, 0, data.length);
            newData[data.length] = (byte) b;
            data = newData;
        }

        private boolean processPacket() throws IOException {
            ByteBuffer data = ByteBuffer.wrap(this.data);
            NetEntryData<Integer> lengthEntry = Serializers.VAR_INTEGER.read(0, data);
            NetEntryData<Integer> packetId =
                    Serializers.VAR_INTEGER.read(lengthEntry.endingPosition(), data);

            Optional<IncomingPacketBuilder<? extends org.absorb.net.packet.IncomingPacket>> builder =
                    AbsorbManagers.getNetManager().getIncomingPacketBuilder(packetId.value(),
                            netInfo.getState());
            if (builder.isEmpty()) {
                System.err.println("User found to have sent a unknown packet, potentionally cheating. " +
                        "Kicking to be safe(Id: " + packetId.value() + "(" + Integer.toHexString(packetId.value()) +
                        ")" + " State: " + netInfo.getState().name() +
                        ")");
                netInfo.getSocket().close();
                return false;
            }
            byte[] packetData = Arrays.copyOfRange(this.data, packetId.endingPosition(), this.data.length);

            org.absorb.net.packet.IncomingPacket packet = builder.get().from(ByteBuffer.wrap(packetData)).build();
            //if (packet.getId()!=IncomingBasicPlayerMovementPacket.ID) {
            System.out.println("\t>>" + packet.getClass().getSimpleName());
            //}
            packet.getProcess().onProcess(this.netInfo, packet);
            return true;
        }

        @Override
        public void run() {
            InputStream is;
            try {
                is = netInfo.getSocket().getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            int length = 100;
            try {
                while (netInfo.getSocket().isConnected() && !netInfo.getSocket().isClosed() && netInfo.getLastPacketSentTime().plus(30,
                        ChronoUnit.SECONDS
                ).isAfter(LocalDateTime.now())) {
                    if (this.data.length > length) {
                        this.data = new byte[0];
                        System.err.println("Cleared cache");
                    }
                    int b = is.read();
                    if (b==-1) {
                        if (data.length!=0) {
                            addByte(0);
                        }
                        continue;
                    }
                    netInfo.setLastPacketSentTime(LocalDateTime.now());
                    addByte(b);
                    try {
                        length = Serializers.VAR_INTEGER.read(0, ByteBuffer.wrap(data)).value();
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("Problem reading: skipping:");
                        System.err.println("\t" + e.getMessage());
                        System.err.println("\t" + Arrays.toString(data));
                    }

                    if (data.length <= length) {
                        continue;
                    }

                    boolean cont = processPacket();
                    if (!cont) {
                        break;
                    }
                    length = 100;
                    data = new byte[0];
                }
            } catch (SocketException ignored) {
            } catch (Throwable e) {
                e.printStackTrace();
            }
            ByteBuffer buffer = ByteBuffer.wrap(data);
            AbsorbManagers.getNetManager().unregister(this.netInfo);
            try {
                this.netInfo.getSocket().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (data.length==0) {
                return;
            }
            System.err.println("Data was left in cache");
            NetEntryData<Integer> lengthEntry;
            NetEntryData<Integer> idEntry;
            try {
                lengthEntry =
                        Serializers.VAR_INTEGER.read(0, buffer);
            } catch (IndexOutOfBoundsException e) {
                return;
            }
            try {
                idEntry = Serializers.VAR_INTEGER.read(lengthEntry.endingPosition(), buffer);
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Failed to read id");
                System.err.println("Length: " + lengthEntry);
                return;
            }
            System.err.println("Length: " + lengthEntry.value());
            System.err.println("Id: " + idEntry.value());
            System.err.println("Data left: " + (data.length - idEntry.endingPosition()));
        }
    }

    private final class ConnectionHandler implements Runnable {

        private boolean running = true;

        public void stop() {
            this.running = false;
        }

        @Override
        public void run() {
            while (this.running) {
                try {
                    Socket clientSocket = server.accept();
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
}
