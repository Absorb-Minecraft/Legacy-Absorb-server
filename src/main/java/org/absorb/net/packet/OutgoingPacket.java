package org.absorb.net.packet;

import org.absorb.net.Client;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.ByteBuffer;

public interface OutgoingPacket extends Packet {

    @Override
    @NotNull OutgoingPacketBuilder<? extends Packet> toBuilder();

    ByteBuffer toBytes(Client stream);

    default void writeTo(@NotNull Client stream) throws IOException {
        ByteBuffer bytes = this.toBytes(stream);
        System.out.println("Writing: ");
        System.out.println("\t>>" + this.getClass().getSimpleName());
        stream.write(bytes);
    }

    default @NotNull Thread writeToAsync(@NotNull Client stream) {
        Thread thread = new Thread(() -> {
            try {
                this.writeTo(stream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        return thread;
    }
}
