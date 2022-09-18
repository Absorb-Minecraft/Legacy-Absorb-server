package org.absorb.net.packet.play.outgoing.client.disconnect;

import net.kyori.adventure.text.Component;
import org.absorb.net.Client;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class OutgoingCloseConnectionPacket implements OutgoingPacket {

    private final @NotNull Component message;
    private final boolean usePlay;
    public static final int PLAY_ID = 0x19;
    public static final int LOGIN_ID = 0x00;

    public OutgoingCloseConnectionPacket(OutgoingCloseConnectionPacketBuilder builder) {
        this.message = builder.getMessage();
        this.usePlay = builder.isUsingPlay();

    }

    public boolean isUsingPlayId() {
        return this.usePlay;
    }

    public @NotNull Component getMessage() {
        return this.message;
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

    @Override
    public ByteBuffer toBytes(Client info) {
        ByteBuffer dataBytes = NetSerializers.CHAT.write(this.message);
        return NetUtils.createPacket(this.getId(), dataBytes);
    }
}
