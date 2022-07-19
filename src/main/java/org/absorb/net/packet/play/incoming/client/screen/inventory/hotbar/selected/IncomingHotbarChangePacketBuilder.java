package org.absorb.net.packet.play.incoming.client.screen.inventory.hotbar.selected;

import org.absorb.net.Client;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class IncomingHotbarChangePacketBuilder implements IncomingPacketBuilder<IncomingHotbarChangePacket> {

    private short newPosition;

    public short getNewPosition() {
        return this.newPosition;
    }

    public IncomingHotbarChangePacketBuilder setNewPosition(short newPosition) {
        this.newPosition = newPosition;
        return this;
    }

    @Override
    public PacketBuilder<IncomingHotbarChangePacket> from(Client client, ByteBuffer packetBytes) {
        this.newPosition = NetSerializers.SHORT.read(0, packetBytes).value();
        return this;
    }

    @Override
    public IncomingPacketBuilder<IncomingHotbarChangePacket> reset() {
        this.newPosition = 0;
        return this;
    }

    @Override
    public IncomingPacketBuilder<IncomingHotbarChangePacket> copy() {
        return new IncomingHotbarChangePacketBuilder().setNewPosition(this.newPosition);
    }

    @Override
    public @NotNull IncomingHotbarChangePacket build() {
        return new IncomingHotbarChangePacket(this);
    }

    @Override
    public int getId() {
        return IncomingHotbarChangePacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
