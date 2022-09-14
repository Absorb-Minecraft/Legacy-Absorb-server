package org.absorb.net.packet.play.outgoing.client.inventory.update.slot;

import org.absorb.inventory.action.InventoryAction;
import org.absorb.inventory.slot.Slot;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

public class OutgoingUpdateSlotPacketBuilder implements OutgoingPacketBuilder<OutgoingUpdateSlotPacket> {

    private byte inventoryId;
    private InventoryAction inventoryState;
    private Slot slot;

    public byte getInventoryId() {
        return this.inventoryId;
    }

    public OutgoingUpdateSlotPacketBuilder setInventoryId(byte id) {
        this.inventoryId = id;
        return this;
    }

    public OutgoingUpdateSlotPacketBuilder setInventoryAsCursor() {
        return this.setInventoryId((byte) -1);
    }

    public OutgoingUpdateSlotPacketBuilder setInventoryAsClient() {
        return this.setInventoryId((byte) 0);
    }

    public InventoryAction getInventoryState() {
        return this.inventoryState;
    }

    public OutgoingUpdateSlotPacketBuilder setInventoryState(InventoryAction inventoryState) {
        this.inventoryState = inventoryState;
        return this;
    }

    public Slot getSlot() {
        return this.slot;
    }

    public OutgoingUpdateSlotPacketBuilder setSlot(Slot slot) {
        this.slot = slot;
        return this;
    }

    @Override
    public @NotNull OutgoingUpdateSlotPacket build() {
        return new OutgoingUpdateSlotPacket(this);
    }

    @Override
    public @NotNull Builder<OutgoingUpdateSlotPacket> from(OutgoingUpdateSlotPacket value) {
        this.slot = value.getSlot();
        this.inventoryId = value.getInventoryId();
        this.inventoryState = value.getInventoryState();
        return this;
    }

    @Override
    public PacketBuilder<OutgoingUpdateSlotPacket> reset() {
        this.slot = null;
        this.inventoryId = 0;
        this.inventoryState = null;
        return this;
    }

    @Override
    public PacketBuilder<OutgoingUpdateSlotPacket> copy() {
        return new OutgoingUpdateSlotPacketBuilder()
                .setSlot(this.slot)
                .setInventoryId(this.inventoryId)
                .setInventoryState(this.inventoryState);
    }

    @Override
    public int getId() {
        return OutgoingUpdateSlotPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
