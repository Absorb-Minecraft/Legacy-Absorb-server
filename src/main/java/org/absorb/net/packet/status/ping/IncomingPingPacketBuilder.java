package org.absorb.net.packet.status.ping;

import org.absorb.net.data.Serializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketState;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class IncomingPingPacketBuilder implements IncomingPacketBuilder<IncomingPingPacket> {

    private long payload;

    public long getPayload() {
        return this.payload;
    }

    public IncomingPingPacketBuilder setPayload(long payload) {
        this.payload = payload;
        return this;
    }

    @Override
    public IncomingPingPacketBuilder from(ByteBuffer packetBytes) {
        this.payload = Serializers.LONG.read(0, packetBytes).value();
        return this;
    }

    @Override
    public IncomingPingPacket build() {
        return new IncomingPingPacket(this);
    }

    @Override
    public IncomingPingPacketBuilder reset() {
        this.payload = 0;
        return this;
    }

    @Override
    public IncomingPingPacketBuilder copy() {
        return new IncomingPingPacketBuilder().setPayload(this.getPayload());
    }

    @Override
    public int getId() {
        return IncomingPingPacket.ID;
    }

    @Override
    public PacketState getState() {
        return PacketState.STATUS;
    }
}
