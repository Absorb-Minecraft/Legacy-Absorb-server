package org.absorb.net.packet.play.incoming.client.inventory.creative;

import org.absorb.inventory.slot.Slot;
import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class IncomingCreativeInventoryClickPacketBuilder implements IncomingPacketBuilder<IncomingCreativeInventoryClickPacket> {

    private short slot;
    private Slot item;

    public short getInventorySlot() {
        return this.slot;
    }

    public IncomingCreativeInventoryClickPacketBuilder setInventorySlot(short slot) {
        this.slot = slot;
        return this;
    }

    public Slot getItem() {
        return this.item;
    }

    public IncomingCreativeInventoryClickPacketBuilder setItem(Slot item) {
        this.item = item;
        return this;
    }

    @Override
    public PacketBuilder<IncomingCreativeInventoryClickPacket> from(ByteBuffer packetBytes) {
        NetEntryData<Short> slotEntry = NetSerializers.SHORT.read(0, packetBytes);
        NetEntryData<Slot> itemEntry = NetSerializers.SLOT.read(slotEntry.endingPosition(), packetBytes);

        this.item = itemEntry.value();
        this.slot = slotEntry.value();
        return this;
    }

    @Override
    public @NotNull IncomingCreativeInventoryClickPacket build() {
        return new IncomingCreativeInventoryClickPacket(this);
    }

    @Override
    public IncomingPacketBuilder<IncomingCreativeInventoryClickPacket> reset() {
        this.slot = 0;
        this.item = null;
        return this;
    }

    @Override
    public IncomingPacketBuilder<IncomingCreativeInventoryClickPacket> copy() {
        return new IncomingCreativeInventoryClickPacketBuilder().setInventorySlot(this.getInventorySlot()).setItem(this.getItem());
    }

    @Override
    public int getId() {
        return IncomingCreativeInventoryClickPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
