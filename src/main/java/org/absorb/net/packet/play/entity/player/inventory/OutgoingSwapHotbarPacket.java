package org.absorb.net.packet.play.entity.player.inventory;

import org.absorb.net.Client;
import org.absorb.net.data.Serializers;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class OutgoingSwapHotbarPacket implements OutgoingPacket {

    private byte newHotbarSlot;

    public static final int ID = 0x48;

    public OutgoingSwapHotbarPacket(OutgoingSwapHotbarPacketBuilder builder){
        this.newHotbarSlot = builder.getNewSlot();
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
    public void send(@NotNull Client stream) {
        try {
            stream.write(Serializers.BYTE.write(this.newHotbarSlot));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
