package org.absorb.net.packet.play.outgoing.client.inventory.hotbar.cooldown;

import org.absorb.net.Client;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class OutgoingItemCooldownPacket implements OutgoingPacket {

    private final int itemId;
    private final int cooldownTicks;
    public static final int ID = 0x14;

    public OutgoingItemCooldownPacket(OutgoingItemCooldownPacketBuilder builder) {
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
    public int getId() {
        return ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }

    @Override
    public @NotNull OutgoingItemCooldownPacketBuilder toBuilder() {
        return new OutgoingItemCooldownPacketBuilder().setCooldownTicks(this.cooldownTicks).setItemId(this.itemId);
    }

    @Override
    public ByteBuffer toBytes(Client stream) {
        return NetUtils.createPacket(ID,
                                     NetSerializers.VAR_INTEGER.write(this.itemId),
                                     NetSerializers.VAR_INTEGER.write(this.cooldownTicks));
    }
}
