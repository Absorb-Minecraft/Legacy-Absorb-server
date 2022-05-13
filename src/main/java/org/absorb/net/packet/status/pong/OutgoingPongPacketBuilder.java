package org.absorb.net.packet.status.pong;

import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;

public class OutgoingPongPacketBuilder implements OutgoingPacketBuilder<OutgoingPongPacket> {

    private long payload;

    public long getPayload() {
        return this.payload;
    }

    public OutgoingPongPacketBuilder setPayload(long payload) {
        this.payload = payload;
        return this;
    }

    @Override
    public OutgoingPongPacket build() {
        return new OutgoingPongPacket(this);
    }

    @Override
    public PacketBuilder<OutgoingPongPacket> reset() {
        this.payload = 0;
        return this;
    }

    @Override
    public PacketBuilder<OutgoingPongPacket> copy() {
        return new OutgoingPongPacketBuilder().setPayload(this.getPayload());
    }

    @Override
    public int getId() {
        return OutgoingPongPacket.ID;
    }

    @Override
    public PacketState getState() {
        return PacketState.STATUS;
    }
}
