package org.absorb.net.packet.play.incoming.client.inventory.close;

import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class IncomingCloseInventoryPacketBuilder implements IncomingPacketBuilder<IncomingCloseInventoryPacket> {

    private byte inventoryId;

    public byte getInventoryId() {
        return this.inventoryId;
    }

    public IncomingCloseInventoryPacketBuilder setInventoryId(byte inventoryId) {
        this.inventoryId = inventoryId;
        return this;
    }

    @Override
    public PacketBuilder<IncomingCloseInventoryPacket> from(ByteBuffer packetBytes) {
        this.inventoryId = NetSerializers.BYTE.read(0, packetBytes).value();
        return this;
    }

    @Override
    public @NotNull IncomingCloseInventoryPacket build() {
        return new IncomingCloseInventoryPacket(this);
    }

    @Override
    public @NotNull IncomingCloseInventoryPacketBuilder reset() {
        this.inventoryId = 0;
        return this;
    }

    @Override
    public @NotNull IncomingCloseInventoryPacketBuilder copy() {
        return new IncomingCloseInventoryPacketBuilder().setInventoryId(this.inventoryId);
    }

    @Override
    public int getId() {
        return IncomingCloseInventoryPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
