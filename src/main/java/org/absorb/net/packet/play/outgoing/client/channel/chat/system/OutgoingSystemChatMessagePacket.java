package org.absorb.net.packet.play.outgoing.client.channel.chat.system;

import net.kyori.adventure.text.Component;
import org.absorb.message.MessagePosition;
import org.absorb.net.Client;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class OutgoingSystemChatMessagePacket implements OutgoingPacket {

    private final @NotNull Component message;
    private final @NotNull MessagePosition position;

    public static final int ID = 0x5F;

    public OutgoingSystemChatMessagePacket(OutgoingSystemChatMessagePacketBuilder builder) {
        this.message = builder.getMessage();
        this.position = builder.getPosition();
    }

    public @NotNull Component getMessage() {
        return this.message;
    }

    public @NotNull MessagePosition getPosition() {
        return this.position;
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
    public @NotNull OutgoingSystemChatMessagePacketBuilder toBuilder() {
        return new OutgoingSystemChatMessagePacketBuilder().setMessage(this.message).setPosition(this.position);
    }

    @Override
    public ByteBuffer toBytes(Client stream) {
        ByteBuffer messageBuffer = NetSerializers.CHAT.write(this.message);
        ByteBuffer positionBuffer = NetSerializers.VAR_INTEGER.write(this.position.getNetworkId());

        return NetUtils.createPacket(ID, messageBuffer, positionBuffer);
    }
}
