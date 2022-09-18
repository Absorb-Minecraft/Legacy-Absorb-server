package org.absorb.net.packet.play.incoming.client.screen.inventory.close;

import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.play.entity.player.screen.inventory.close.InventoryCloseProcessor;
import org.jetbrains.annotations.NotNull;

public class IncomingCloseInventoryPacket implements IncomingPacket {

    private final byte inventoryId;
    public static final int ID = 0x10;

    public IncomingCloseInventoryPacket(@NotNull IncomingCloseInventoryPacketBuilder builder) {
        this.inventoryId = builder.getInventoryId();
    }

    public byte getInventoryId() {
        return this.inventoryId;
    }

    @Override
    public @NotNull <P extends IncomingPacket> NetProcess<P> getProcess() {
        return (NetProcess<P>) new InventoryCloseProcessor();
    }

    @Override
    public int getId() {
        return 9;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }

    @Override
    public @NotNull PacketBuilder<? extends Packet> toBuilder() {
        return new IncomingCloseInventoryPacketBuilder().setInventoryId(this.inventoryId);
    }
}
