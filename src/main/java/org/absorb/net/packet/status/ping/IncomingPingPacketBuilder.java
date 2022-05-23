package org.absorb.net.packet.status.ping;

import org.absorb.net.data.Serializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class IncomingPingPacketBuilder implements IncomingPacketBuilder<IncomingPingPacket> {

    private long payload;
    private boolean usePlay;

    public boolean isUsePlay() {
        return this.usePlay;
    }

    public IncomingPingPacketBuilder setUsePlay(boolean usePlay) {
        this.usePlay = usePlay;
        return this;
    }

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
    public @NotNull IncomingPingPacket build() {
        return new IncomingPingPacket(this);
    }

    @Override
    public @NotNull IncomingPingPacketBuilder reset() {
        this.payload = 0;
        return this;
    }

    @Override
    public @NotNull IncomingPingPacketBuilder copy() {
        return new IncomingPingPacketBuilder().setPayload(this.getPayload()).setUsePlay(this.usePlay);
    }

    @Override
    public int getId() {
        return IncomingPingPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        if (this.usePlay) {
            return PacketState.PLAY;
        }
        return PacketState.STATUS;
    }
}
