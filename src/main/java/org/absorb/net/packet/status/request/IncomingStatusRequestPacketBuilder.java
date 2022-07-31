package org.absorb.net.packet.status.request;

import org.absorb.net.Client;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class IncomingStatusRequestPacketBuilder implements IncomingPacketBuilder<IncomingStatusRequestPacket> {
    @Override
    public PacketBuilder<IncomingStatusRequestPacket> from(Client client, ByteBuffer buffer) {
        return this;
    }

    @Override
    public IncomingStatusRequestPacketBuilder reset() {
        return this;
    }

    @Override
    public IncomingStatusRequestPacketBuilder copy() {
        return new IncomingStatusRequestPacketBuilder();
    }

    @Override
    public IncomingStatusRequestPacket build() {
        return new IncomingStatusRequestPacket();
    }

    @Override
    public @NotNull Builder<IncomingStatusRequestPacket> from(IncomingStatusRequestPacket value) {
        return this;
    }

    @Override
    public int getId() {
        return IncomingStatusRequestPacket.ID;
    }

    @Override
    public PacketState getState() {
        return PacketState.STATUS;
    }
}
