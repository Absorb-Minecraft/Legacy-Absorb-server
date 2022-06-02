package org.absorb.net.packet.status.pong;

import org.absorb.net.Client;
import org.absorb.net.data.SerializerUtils;
import org.absorb.net.data.Serializers;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class OutgoingPongPacket implements OutgoingPacket {

    public static final int ID = 0x01;
    public static final int PLAY_ID = 0x30;

    private final long payload;
    private final boolean usePlay;

    public OutgoingPongPacket(OutgoingPongPacketBuilder builder) {
        this.payload = builder.getPayload();
        this.usePlay = builder.isUsePlay();
    }

    @Override
    public ByteBuffer toBytes(Client stream) {
        if (this.usePlay) {
            return SerializerUtils.createPacket(PLAY_ID, Serializers.INTEGER.write((int) this.payload));
        }
        return SerializerUtils.createPacket(ID, Serializers.LONG.write(this.payload));
    }

    @Override
    public int getId() {
        if (this.usePlay) {
            return PLAY_ID;
        }
        return ID;
    }

    @Override
    public @NotNull PacketState getState() {
        if (this.usePlay) {
            return PacketState.PLAY;
        }
        return PacketState.STATUS;
    }

    @Override
    public @NotNull OutgoingPongPacketBuilder toBuilder() {
        return new OutgoingPongPacketBuilder().setPayload(this.payload);
    }
}
