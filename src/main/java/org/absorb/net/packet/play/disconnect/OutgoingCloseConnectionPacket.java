package org.absorb.net.packet.play.disconnect;

import net.kyori.adventure.text.Component;
import org.absorb.net.Client;
import org.absorb.net.data.SerializerUtils;
import org.absorb.net.data.Serializers;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class OutgoingCloseConnectionPacket implements OutgoingPacket {

    public static final int PLAY_ID = 0x1A;
    public static final int LOGIN_ID = 0x00;

    private final @NotNull Component message;
    private final boolean usePlay;

    public OutgoingCloseConnectionPacket(OutgoingCloseConnectionPacketBuilder builder) {
        this.message = builder.getMessage();
        this.usePlay = builder.isUsingPlay();

    }

    public @NotNull Component getMessage() {
        return this.message;
    }

    @Override
    public ByteBuffer toBytes(Client info) {
        ByteBuffer dataBytes = Serializers.CHAT.write(this.message);
        return SerializerUtils.createPacket(this.getId(), dataBytes);
    }

    @Override
    public int getId() {
        if (this.usePlay) {
            return PLAY_ID;
        }
        return LOGIN_ID;
    }

    @Override
    public @NotNull PacketState getState() {
        if (this.usePlay) {
            return PacketState.PLAY;
        }
        return PacketState.LOGIN;
    }

    @Override
    public @NotNull OutgoingCloseConnectionPacketBuilder toBuilder() {
        return new OutgoingCloseConnectionPacketBuilder().setMessage(this.message);
    }
}
