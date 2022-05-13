package org.absorb.net.packet;

import org.absorb.net.Client;
import org.jetbrains.annotations.NotNull;

public interface OutgoingPacket extends Packet {

    @Override
    @NotNull OutgoingPacketBuilder<? extends Packet> toBuilder();

    void send(@NotNull Client stream);

    default @NotNull Thread sendAsync(@NotNull Client stream) {
        Thread thread = new Thread(() -> this.send(stream));
        thread.start();
        return thread;
    }
}
