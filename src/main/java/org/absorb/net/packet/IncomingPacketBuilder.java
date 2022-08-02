package org.absorb.net.packet;

import org.absorb.net.Client;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public interface IncomingPacketBuilder<P extends IncomingPacket> extends PacketBuilder<P> {

    @NotNull PacketBuilder<P> from(@NotNull Client connection, @NotNull ByteBuffer packetBytes);

    @Override
    @NotNull IncomingPacketBuilder<P> reset();

    @Override
    @NotNull IncomingPacketBuilder<P> copy();
}
