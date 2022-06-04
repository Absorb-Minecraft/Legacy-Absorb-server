package org.absorb.net.packet.play.message.chat;

import net.kyori.adventure.text.Component;
import org.absorb.message.MessagePosition;
import org.absorb.net.Client;
import org.absorb.net.data.SerializerUtils;
import org.absorb.net.data.Serializers;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.ByteBuffer;
import java.util.Optional;
import java.util.UUID;

public class OutgoingChatMessagePacket implements OutgoingPacket {

    public static final int ID = 0x0F;

    private final @NotNull Component message;
    private final @NotNull MessagePosition position;
    private final @Nullable UUID from;

    public OutgoingChatMessagePacket(OutgoingChatMessagePacketBuilder builder) {
        this.message = builder.getMessage();
        this.position = builder.getPosition();
        this.from = builder.getFrom();
    }

    public @NotNull Component getMessage() {
        return this.message;
    }

    public @NotNull MessagePosition getPosition() {
        return this.position;
    }

    public Optional<UUID> getFrom() {
        return Optional.ofNullable(this.from);
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
        return new OutgoingChatMessagePacketBuilder().setMessage(this.message).setPosition(this.position).setFrom(this.from);
    }

    @Override
    public ByteBuffer toBytes(Client stream) {
        ByteBuffer messageBuffer = Serializers.CHAT.write(this.message);
        ByteBuffer positionBuffer = Serializers.BYTE.write((byte) this.position.getNetworkId());
        if (this.from==null) {
            return SerializerUtils.createPacket(ID, messageBuffer, positionBuffer, Serializers.LONG.write(0l),
                    Serializers.LONG.write(0L));
        }

        return SerializerUtils.createPacket(ID, messageBuffer, positionBuffer, Serializers.UUID.write(this.from));
    }
}
