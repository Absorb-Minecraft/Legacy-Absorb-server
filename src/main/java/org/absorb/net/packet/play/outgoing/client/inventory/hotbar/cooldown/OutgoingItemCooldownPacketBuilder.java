package org.absorb.net.packet.play.outgoing.client.inventory.hotbar.cooldown;

import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

public class OutgoingItemCooldownPacketBuilder implements OutgoingPacketBuilder<OutgoingItemCooldownPacket> {

    private int itemId;
    private int cooldownTicks;

    public int getItemId() {
        return this.itemId;
    }

    public OutgoingItemCooldownPacketBuilder setItemId(int itemId) {
        this.itemId = itemId;
        return this;
    }

    public int getCooldownTicks() {
        return this.cooldownTicks;
    }

    public OutgoingItemCooldownPacketBuilder setCooldownTicks(int cooldownTicks) {
        this.cooldownTicks = cooldownTicks;
        return this;
    }

    @Override
    public OutgoingItemCooldownPacketBuilder reset() {
        this.cooldownTicks = 0;
        this.itemId = 0;
        return this;
    }

    @Override
    public OutgoingItemCooldownPacketBuilder copy() {
        return new OutgoingItemCooldownPacketBuilder().setItemId(this.itemId).setCooldownTicks(this.cooldownTicks);
    }

    @Override
    public int getId() {
        return OutgoingItemCooldownPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }

    @Override
    public @NotNull OutgoingItemCooldownPacket build() {
        return new OutgoingItemCooldownPacket(this);
    }

    @Override
    public @NotNull OutgoingItemCooldownPacketBuilder from(OutgoingItemCooldownPacket value) {
        this.cooldownTicks = value.getCooldownTicks();
        this.itemId = value.getItemId();
        return this;
    }
}
