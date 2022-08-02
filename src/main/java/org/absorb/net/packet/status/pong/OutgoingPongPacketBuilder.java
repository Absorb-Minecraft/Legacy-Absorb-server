package org.absorb.net.packet.status.pong;

import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

public class OutgoingPongPacketBuilder implements OutgoingPacketBuilder<OutgoingPongPacket> {

    private long payload;
    private boolean usePlay;

    public boolean isUsePlay() {
        return this.usePlay;
    }

    public OutgoingPongPacketBuilder setUsePlay(boolean usePlay) {
        this.usePlay = usePlay;
        return this;
    }

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
    public @NotNull Builder<OutgoingPongPacket> from(OutgoingPongPacket value) {
        this.payload = value.getPayload();
        this.usePlay = value.isUsingPlay();
        return this;
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
