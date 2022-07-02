package org.absorb.net.packet.play.incoming.client.inventory.hotbar.cooldown;

import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.play.entity.player.inventory.hotbar.cooldown.ItemCooldownProcessor;
import org.jetbrains.annotations.NotNull;

public class IncomingItemCooldownPacket implements IncomingPacket {

    private final int itemId;
    private final int cooldownTicks;
    public static final int ID = 0x14;

    public IncomingItemCooldownPacket(IncomingItemCooldownPacketBuilder builder) {
        this.itemId = builder.getItemId();
        this.cooldownTicks = builder.getCooldownTicks();
    }

    public int getItemId() {
        return this.itemId;
    }

    public int getCooldownTicks() {
        return this.cooldownTicks;
    }

    @Override
    public @NotNull <P extends IncomingPacket> NetProcess<P> getProcess() {
        return (NetProcess<P>) new ItemCooldownProcessor();
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
        return new IncomingItemCooldownPacketBuilder().setCooldownTicks(this.cooldownTicks).setItemId(this.itemId);
    }
}
