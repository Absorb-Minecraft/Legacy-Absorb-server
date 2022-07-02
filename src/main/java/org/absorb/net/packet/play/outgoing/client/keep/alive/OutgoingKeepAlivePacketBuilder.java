package org.absorb.net.packet.play.outgoing.client.keep.alive;

import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

public class OutgoingKeepAlivePacketBuilder implements OutgoingPacketBuilder<OutgoingKeepAlivePacket> {

    private long generatedId;

    public long getGeneratedId() {
        return this.generatedId;
    }

    public OutgoingKeepAlivePacketBuilder setGeneratedId(long generatedId) {
        this.generatedId = generatedId;
        return this;
    }

    @Override
    public @NotNull OutgoingKeepAlivePacket build() {
        return new OutgoingKeepAlivePacket(this);
    }

    @Override
    public PacketBuilder<OutgoingKeepAlivePacket> reset() {
        this.generatedId = 0;
        return this;
    }

    @Override
    public PacketBuilder<OutgoingKeepAlivePacket> copy() {
        return new OutgoingKeepAlivePacketBuilder().setGeneratedId(this.generatedId);
    }

    @Override
    public int getId() {
        return OutgoingKeepAlivePacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
