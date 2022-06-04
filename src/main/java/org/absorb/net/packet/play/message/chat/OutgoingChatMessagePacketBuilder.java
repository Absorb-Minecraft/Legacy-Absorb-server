package org.absorb.net.packet.play.message.chat;

import net.kyori.adventure.text.Component;
import org.absorb.message.MessagePosition;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class OutgoingChatMessagePacketBuilder implements OutgoingPacketBuilder<OutgoingChatMessagePacket> {

    private @NotNull Component message;
    private @NotNull MessagePosition position;
    private @Nullable UUID from;

    public Component getMessage() {
        return this.message;
    }

    public OutgoingChatMessagePacketBuilder setMessage(Component message) {
        this.message = message;
        return this;
    }

    public MessagePosition getPosition() {
        return this.position;
    }

    public OutgoingChatMessagePacketBuilder setPosition(MessagePosition position) {
        this.position = position;
        return this;
    }

    public UUID getFrom() {
        return this.from;
    }

    public OutgoingChatMessagePacketBuilder setFrom(UUID from) {
        this.from = from;
        return this;
    }

    @Override
    public @NotNull OutgoingChatMessagePacket build() {
        return new OutgoingChatMessagePacket(this);
    }

    @Override
    public PacketBuilder<OutgoingChatMessagePacket> reset() {
        this.message = null;
        this.position = null;
        this.from = null;
        return this;
    }

    @Override
    public PacketBuilder<OutgoingChatMessagePacket> copy() {
        return new OutgoingChatMessagePacketBuilder().setMessage(this.message).setFrom(this.from).setPosition(this.position);
    }

    @Override
    public int getId() {
        return OutgoingChatMessagePacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
