package org.absorb.net.packet.play.incoming.client.screen.inventory.hotbar.cooldown;

import org.absorb.net.Client;
import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class IncomingItemCooldownPacketBuilder implements IncomingPacketBuilder<IncomingItemCooldownPacket> {

    private int itemId;
    private int cooldownTicks;

    public int getItemId() {
        return this.itemId;
    }

    public IncomingItemCooldownPacketBuilder setItemId(int itemId) {
        this.itemId = itemId;
        return this;
    }

    public int getCooldownTicks() {
        return this.cooldownTicks;
    }

    public IncomingItemCooldownPacketBuilder setCooldownTicks(int cooldownTicks) {
        this.cooldownTicks = cooldownTicks;
        return this;
    }

    @Override
    public PacketBuilder<IncomingItemCooldownPacket> from(Client client, ByteBuffer packetBytes) {
        NetEntryData<Integer> itemIdEntry = NetSerializers.VAR_INTEGER.read(0, packetBytes);
        NetEntryData<Integer> cooldownTicksEntry = NetSerializers.VAR_INTEGER.read(itemIdEntry.endingPosition(),
                                                                                   packetBytes);
        this.itemId = itemIdEntry.value();
        this.cooldownTicks = cooldownTicksEntry.value();
        return this;
    }

    @Override
    public IncomingPacketBuilder<IncomingItemCooldownPacket> reset() {
        this.cooldownTicks = 0;
        this.itemId = 0;
        return this;
    }

    @Override
    public IncomingPacketBuilder<IncomingItemCooldownPacket> copy() {
        return new IncomingItemCooldownPacketBuilder().setItemId(this.itemId).setCooldownTicks(this.cooldownTicks);
    }

    @Override
    public @NotNull IncomingItemCooldownPacket build() {
        return new IncomingItemCooldownPacket(this);
    }

    @Override
    public @NotNull Builder<IncomingItemCooldownPacket> from(IncomingItemCooldownPacket value) {
        this.cooldownTicks = value.getCooldownTicks();
        this.itemId = value.getItemId();
        return this;
    }

    @Override
    public int getId() {
        return IncomingItemCooldownPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
