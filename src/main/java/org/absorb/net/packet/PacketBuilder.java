package org.absorb.net.packet;

import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

public interface PacketBuilder<P extends Packet> extends Builder<P> {

    @Override
    PacketBuilder<P> reset();

    @Override
    PacketBuilder<P> copy();

    int getId();

    @NotNull PacketState getState();
}
