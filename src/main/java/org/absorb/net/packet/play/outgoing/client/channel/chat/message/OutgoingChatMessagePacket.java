package org.absorb.net.packet.play.outgoing.client.channel.chat.message;

import net.kyori.adventure.text.Component;
import org.absorb.message.MessagePosition;
import org.absorb.net.Client;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

public class OutgoingChatMessagePacket implements OutgoingPacket {

    private final @Nullable Component message;
    private final @NotNull Component originalMessage;
    private final @NotNull MessagePosition position;
    private final @Nullable UUID from;
    private final @NotNull Component fromDisplayName;
    private final @Nullable Component teamName;
    private final long timestamp;
    private final long salt;
    private final byte[] messageSign;
    public static final int ID = 0x33;


    public OutgoingChatMessagePacket(OutgoingChatMessagePacketBuilder builder) {
        this.message = builder.getDisplayMessage();
        this.position = builder.getPosition();
        this.from = builder.getFrom();
        this.originalMessage = builder.getOriginalMessage();
        this.fromDisplayName = builder.getFromDisplayName();
        this.timestamp = builder.getTimestamp();
        this.salt = builder.getSalt();
        this.messageSign = builder.getMessageSign();
        this.teamName = builder.getTeamName();
        if (this.fromDisplayName == null) {
            throw new RuntimeException("From display name cannot be null or blank");
        }
        if (this.position == null) {
            throw new RuntimeException("Message position cannot be null");
        }
        if (this.originalMessage == null) {
            throw new RuntimeException("Original message cannot be null");
        }
    }

    public @NotNull Component getOriginalMessage() {
        return this.originalMessage;
    }

    public @NotNull Optional<Component> getDisplayMessage() {
        return Optional.ofNullable(this.message);
    }

    public @NotNull Component getFromDisplayName() {
        return this.fromDisplayName;
    }

    public Optional<Component> getTeamName() {
        return Optional.ofNullable(this.teamName);
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public long getSalt() {
        return this.salt;
    }

    public byte[] getMessageSignature() {
        return this.messageSign;
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
        return new OutgoingChatMessagePacketBuilder()
                .setDisplayMessage(this.message)
                .setPosition(this.position)
                .setFrom(this.from)
                .setFromDisplayName(this.fromDisplayName)
                .setOriginalMessage(this.originalMessage)
                .setSalt(this.salt)
                .setTimestamp(this.timestamp)
                .setMessageSign(this.messageSign);
    }

    @Override
    public ByteBuffer toBytes(Client stream) {
        ByteBuffer signedChatMessage = NetSerializers.CHAT.write(this.originalMessage);
        System.out.println("SignedChat: " + Arrays.toString(signedChatMessage.array()));

        ByteBuffer hasUnsignedMessage = NetSerializers.BOOLEAN.write(this.message != null);
        System.out.println("HasUnsignedChat: " + Arrays.toString(hasUnsignedMessage.array()));
        ByteBuffer unsignedMessage = ByteBuffer.allocate(0);
        if (this.message != null) {
            unsignedMessage = NetSerializers.CHAT.write(this.message);
        }
        System.out.println("unsigned Chat: " + Arrays.toString(unsignedMessage.array()));
        ByteBuffer messageType = NetSerializers.VAR_INTEGER.write(this.position.getNetworkId());
        System.out.println("Message Type: " + Arrays.toString(messageType.array()));

        ByteBuffer senderId = NetSerializers.UUID.write(this.from == null ? new UUID(0, 0) : this.from);
        System.out.println("Sender Id: " + Arrays.toString(senderId.array()));
        ByteBuffer senderName = NetSerializers.CHAT.write(this.fromDisplayName);
        System.out.println("Sender Name: " + Arrays.toString(senderName.array()));
        ByteBuffer senderTeamNamePresent = NetSerializers.BOOLEAN.write(this.teamName != null);
        System.out.println("TeamName Present: " + Arrays.toString(senderTeamNamePresent.array()));
        ByteBuffer senderTeamName = ByteBuffer.allocate(0);
        if (this.teamName != null) {
            senderTeamName = NetSerializers.CHAT.write(this.teamName);
        }
        System.out.println("Teamname: " + Arrays.toString(senderTeamName.array()));
        ByteBuffer timestamp = NetSerializers.LONG.write(this.timestamp);
        System.out.println("Timestamp: " + Arrays.toString(timestamp.array()));
        ByteBuffer salt = NetSerializers.LONG.write(this.salt);
        System.out.println("Salt: " + Arrays.toString(salt.array()));
        ByteBuffer signLength = NetSerializers.VAR_INTEGER.write(this.messageSign.length);
        System.out.println("SignLength: " + Arrays.toString(signLength.array()));
        ByteBuffer sign = NetSerializers.byteArray(this.messageSign.length).write(this.messageSign);
        System.out.println("Sign: " + Arrays.toString(sign.array()));
        return NetUtils.createPacket(ID,
                                     signedChatMessage,
                                     hasUnsignedMessage,
                                     unsignedMessage,
                                     messageType,
                                     senderId,
                                     senderName,
                                     senderTeamNamePresent,
                                     senderTeamName,
                                     timestamp,
                                     salt,
                                     signLength,
                                     sign);
    }
}
