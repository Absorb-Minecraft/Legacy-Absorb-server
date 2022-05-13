package org.absorb.net.packet;

import java.nio.ByteBuffer;

public interface IncomingPacketBuilder<P extends IncomingPacket> extends PacketBuilder<P> {

    PacketBuilder<P> from(ByteBuffer packetBytes);

    @Override
    IncomingPacketBuilder<P> reset();

    @Override
    IncomingPacketBuilder<P> copy();
}
