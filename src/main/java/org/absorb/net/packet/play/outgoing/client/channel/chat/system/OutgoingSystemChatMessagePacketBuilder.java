package org.absorb.net.packet.play.outgoing.client.channel.chat.system;

import net.kyori.adventure.text.Component;
import org.absorb.message.MessagePosition;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

public class OutgoingSystemChatMessagePacketBuilder implements OutgoingPacketBuilder<OutgoingSystemChatMessagePacket> {

    private Component message;
    private MessagePosition position;

    public Component getMessage() {
        return this.message;
    }

    public OutgoingSystemChatMessagePacketBuilder setMessage(Component message) {
        this.message = message;
        return this;
    }

    public MessagePosition getPosition() {
        return this.position;
    }

    public OutgoingSystemChatMessagePacketBuilder setPosition(MessagePosition position) {
        this.position = position;
        return this;
    }

    @Override
    public @NotNull OutgoingSystemChatMessagePacket build() {
        return new OutgoingSystemChatMessagePacket(this);
    }

    @Override
    public PacketBuilder<OutgoingSystemChatMessagePacket> reset() {
        this.message = null;
        this.position = null;
        return this;
    }

    @Override
    public PacketBuilder<OutgoingSystemChatMessagePacket> copy() {
        return new OutgoingSystemChatMessagePacketBuilder().setMessage(this.message).setPosition(this.position);
    }

    @Override
    public int getId() {
        return OutgoingSystemChatMessagePacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
