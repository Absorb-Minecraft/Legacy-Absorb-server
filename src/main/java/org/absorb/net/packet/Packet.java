package org.absorb.net.packet;

import org.jetbrains.annotations.NotNull;

public interface Packet {

    int getId();

    @NotNull PacketState getState();

    @NotNull PacketBuilder<? extends Packet> toBuilder();

}
