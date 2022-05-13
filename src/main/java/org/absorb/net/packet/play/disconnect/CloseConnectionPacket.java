package org.absorb.net.packet.play.disconnect;

import net.kyori.adventure.text.Component;
import org.absorb.net.Client;
import org.absorb.net.data.SerializerUtils;
import org.absorb.net.data.Serializers;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.ByteBuffer;

public class CloseConnectionPacket implements OutgoingPacket {

    public static final int PLAY_ID = 0x1B;
    public static final int LOGIN_ID = 0x00;

    private final @NotNull Component message;
    private final boolean usePlay;

    public CloseConnectionPacket(OutgoingCloseConnectionPacketBuilder builder) {
        this.message = builder.getMessage();
        this.usePlay = builder.isUsingPlay();

    }

    public @NotNull Component getMessage() {
        return this.message;
    }

    @Override
    public void send(Client info) {
        try {
            ByteBuffer dataBytes = Serializers.CHAT.write(this.message);
            ByteBuffer returnBytes = SerializerUtils.createPacket(this.getId(), dataBytes);
            info.write(returnBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
