package org.absorb.net.packet.play.incoming.client.screen.inventory.slot.update;

import org.absorb.inventory.action.InventoryAction;
import org.absorb.inventory.slot.Slot;
import org.absorb.net.Client;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.OptionalInt;

public class OutgoingUpdateSlotPacket implements OutgoingPacket {

    private final byte inventoryId;
    private final InventoryAction inventoryState;
    private final Slot slot;

    public static final int ID = 0x13;

    public OutgoingUpdateSlotPacket(OutgoingUpdateSlotPacketBuilder packet) {
        this.inventoryId = packet.getInventoryId();
        this.inventoryState = packet.getInventoryState();
        this.slot = packet.getSlot();
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }

    @Override
    public @NotNull OutgoingPacketBuilder<? extends Packet> toBuilder() {
        return new OutgoingUpdateSlotPacketBuilder()
                .setSlot(this.slot)
                .setInventoryId(this.inventoryId)
                .setInventoryState(this.inventoryState);
    }

    @Override
    public ByteBuffer toBytes(Client stream) {
        OptionalInt slotIndex = this.slot.getIndex();
        if (slotIndex.isEmpty()) {
            throw new RuntimeException("Slot has no index");
        }

        ByteBuffer windowIdBuffer = NetSerializers.BYTE.write(this.inventoryId);
        ByteBuffer stateIdBuffer = NetSerializers.VAR_INTEGER.write(this.inventoryState.getNetworkId());
        ByteBuffer slotIdBuffer = NetSerializers.SHORT.write((short) slotIndex.getAsInt());
        ByteBuffer slotBuffer = NetSerializers.SLOT.write(this.slot);

        System.out.println("Window Id: " + Arrays.toString(windowIdBuffer.array()));
        System.out.println("State Id: " + Arrays.toString(stateIdBuffer.array()));
        System.out.println("Slot Id: " + Arrays.toString(slotIdBuffer.array()));
        System.out.println("Slot: " + Arrays.toString(slotBuffer.array()));
        return NetUtils.createPacket(ID, windowIdBuffer, stateIdBuffer, slotIdBuffer, slotBuffer);
    }
}
