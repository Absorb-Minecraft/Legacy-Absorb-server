package org.absorb.net.packet.play.outgoing.client.inventory.hotbar.selected;

import org.absorb.net.Client;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class OutgoingSwapHotbarPacket implements OutgoingPacket {

    private final byte newHotbarSlot;

    public static final int ID = 0x47;

    public OutgoingSwapHotbarPacket(OutgoingSwapHotbarPacketBuilder builder) {
        this.newHotbarSlot = builder.getNewSlot();
    }

    public byte getHotbarSlot() {
        return this.newHotbarSlot;
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
        return new OutgoingSwapHotbarPacketBuilder().setNewSlot(this.newHotbarSlot);
    }

    @Override
    public ByteBuffer toBytes(@NotNull Client stream) {
        return NetUtils.createPacket(ID, NetSerializers.BYTE.write(this.newHotbarSlot));
    }
}
