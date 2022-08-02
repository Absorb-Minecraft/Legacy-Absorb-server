package org.absorb.net.packet.play.incoming.client.screen.inventory.creative;

import org.absorb.inventory.slot.Slot;
import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.play.entity.player.screen.inventory.click.creative.CreativeClickInventoryProcessor;
import org.jetbrains.annotations.NotNull;

public class IncomingCreativeInventoryClickPacket implements IncomingPacket {

    private final Slot slot;
    private final short inventorySlot;
    public static final int ID = 0x2A;

    public IncomingCreativeInventoryClickPacket(IncomingCreativeInventoryClickPacketBuilder builder) {
        this.slot = builder.getItem();
        this.inventorySlot = builder.getInventorySlot();
    }

    public @NotNull Slot getItem() {
        return this.slot;
    }

    public short getInventorySlot() {
        return this.inventorySlot;
    }

    @Override
    public @NotNull <P extends IncomingPacket> NetProcess<P> getProcess() {
        return (NetProcess<P>) new CreativeClickInventoryProcessor();
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
    public @NotNull PacketBuilder<? extends Packet> toBuilder() {
        return new IncomingCreativeInventoryClickPacketBuilder()
                .setInventorySlot(this.inventorySlot)
                .setItem(this.slot);
    }
}
