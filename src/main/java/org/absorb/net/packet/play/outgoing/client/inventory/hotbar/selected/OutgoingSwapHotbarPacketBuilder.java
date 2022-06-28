package org.absorb.net.packet.play.outgoing.client.inventory.hotbar.selected;

import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

public class OutgoingSwapHotbarPacketBuilder implements OutgoingPacketBuilder<OutgoingSwapHotbarPacket> {

    private byte newSlot;

    public byte getNewSlot() {
        return this.newSlot;
    }

    public OutgoingSwapHotbarPacketBuilder setNewSlot(byte newSlot) {
        this.newSlot = newSlot;
        return this;
    }

    @Override
    public @NotNull OutgoingSwapHotbarPacket build() {
        return new OutgoingSwapHotbarPacket(this);
    }

    @Override
    public PacketBuilder<OutgoingSwapHotbarPacket> reset() {
        newSlot = 0;
        return this;
    }

    @Override
    public PacketBuilder<OutgoingSwapHotbarPacket> copy() {
        return new OutgoingSwapHotbarPacketBuilder().setNewSlot(this.newSlot);
    }

    @Override
    public int getId() {
        return OutgoingSwapHotbarPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
