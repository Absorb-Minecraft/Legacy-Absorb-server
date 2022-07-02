package org.absorb.net.packet.play.outgoing.client.channel.chat;

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
    public static final int ID = 0x30;


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
        ByteBuffer messageBuffer = NetSerializers.CHAT.write(this.message);
        ByteBuffer positionBuffer = NetSerializers.BYTE.write((byte) this.position.getNetworkId());
        ByteBuffer fromBuffer = NetSerializers.LONG.write(0L);
        if (this.from != null) {
            fromBuffer = NetSerializers.UUID.write(this.from);
        }
        ByteBuffer fromName = NetSerializers.CHAT.write(this.fromDisplayName);
        ByteBuffer hasTeamName = NetSerializers.BOOLEAN.write(this.teamName != null);
        ByteBuffer teamName = ByteBuffer.allocate(0);
        if (this.teamName != null) {
            teamName = NetSerializers.CHAT.write(this.teamName);
        }
        ByteBuffer timestamp = NetSerializers.LONG.write(this.timestamp);
        ByteBuffer salt = NetSerializers.LONG.write(this.salt);
        ByteBuffer sign = ByteBuffer.wrap(this.messageSign);

        return NetUtils.createPacket(ID,
                                     messageBuffer,
                                     positionBuffer,
                                     fromBuffer,
                                     fromName,
                                     hasTeamName,
                                     teamName,
                                     timestamp,
                                     salt,
                                     sign);
    }
}
