package org.absorb.net.packet.play.outgoing.client.channel.chat.message;

import net.kyori.adventure.text.Component;
import org.absorb.message.MessagePosition;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class OutgoingChatMessagePacketBuilder implements OutgoingPacketBuilder<OutgoingChatMessagePacket> {

    private Component message;
    private Component originalMessage;
    private MessagePosition position;
    private UUID from;
    private Component fromDisplayName;
    private Component teamName;
    private long timestamp;
    private long salt;
    private byte[] messageSign = new byte[0];


    public Component getOriginalMessage() {
        return this.originalMessage;
    }

    public OutgoingChatMessagePacketBuilder setOriginalMessage(Component originalMessage) {
        this.originalMessage = originalMessage;
        return this;
    }

    public Component getFromDisplayName() {
        return this.fromDisplayName;
    }

    public OutgoingChatMessagePacketBuilder setFromDisplayName(Component fromDisplayName) {
        this.fromDisplayName = fromDisplayName;
        return this;
    }

    public Component getTeamName() {
        return this.teamName;
    }

    public OutgoingChatMessagePacketBuilder setTeamName(Component teamName) {
        this.teamName = teamName;
        return this;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public OutgoingChatMessagePacketBuilder setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public long getSalt() {
        return this.salt;
    }

    public OutgoingChatMessagePacketBuilder setSalt(long salt) {
        this.salt = salt;
        return this;
    }

    public byte[] getMessageSign() {
        return this.messageSign;
    }

    public OutgoingChatMessagePacketBuilder setMessageSign(byte[] messageSign) {
        this.messageSign = messageSign;
        return this;
    }

    public Component getDisplayMessage() {
        return this.message;
    }

    public OutgoingChatMessagePacketBuilder setDisplayMessage(Component message) {
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
    public @NotNull Builder<OutgoingChatMessagePacket> from(OutgoingChatMessagePacket value) {
        this.from = value.getFrom().orElse(null);
        this.fromDisplayName = value.getFromDisplayName();
        this.messageSign = value.getMessageSignature();
        this.message = value.getDisplayMessage().orElse(null);
        this.originalMessage = value.getOriginalMessage();
        this.position = value.getPosition();
        this.salt = value.getSalt();
        this.teamName = value.getTeamName().orElse(null);
        this.timestamp = value.getTimestamp();
        return this;
    }

    @Override
    public PacketBuilder<OutgoingChatMessagePacket> reset() {
        this.message = null;
        this.position = null;
        this.fromDisplayName = null;
        this.messageSign = new byte[0];
        this.salt = 0;
        this.timestamp = 0;
        this.from = null;
        return this;
    }

    @Override
    public PacketBuilder<OutgoingChatMessagePacket> copy() {
        return new OutgoingChatMessagePacketBuilder()
                .setDisplayMessage(this.message)
                .setFromDisplayName(this.fromDisplayName)
                .setFrom(this.from)
                .setTeamName(this.teamName)
                .setTimestamp(this.timestamp)
                .setSalt(this.salt)
                .setOriginalMessage(this.originalMessage)
                .setPosition(this.position);
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
