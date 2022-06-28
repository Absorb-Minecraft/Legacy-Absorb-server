package org.absorb.net.packet.play.incoming.client.channel.chat;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class IncomingMessagePacketBuilder implements IncomingPacketBuilder<IncomingMessagePacket> {

    private String message;
    private long timestamp;
    private Byte[] sign;
    private long salt;
    private boolean preview;


    public String getMessage() {
        return this.message;
    }

    public IncomingMessagePacketBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public IncomingMessagePacketBuilder setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Byte[] getSignature() {
        return this.sign;
    }

    public IncomingMessagePacketBuilder setSignature(Byte... sign) {
        this.sign = sign;
        return this;
    }

    public long getSalt() {
        return this.salt;
    }

    public IncomingMessagePacketBuilder setSalt(long salt) {
        this.salt = salt;
        return this;
    }

    public boolean isPreview() {
        return this.preview;
    }

    public IncomingMessagePacketBuilder setPreview(boolean preview) {
        this.preview = preview;
        return this;
    }

    @Override
    public PacketBuilder<IncomingMessagePacket> from(ByteBuffer packetBytes) {
        NetEntryData<String> message = NetSerializers.STRING.read(0, packetBytes);
        NetEntryData<Long> timestamp = NetSerializers.LONG.read(message.endingPosition(), packetBytes);
        NetEntryData<Long> salt = NetSerializers.LONG.read(timestamp.endingPosition(), packetBytes);
        NetEntryData<Integer> signLength = NetSerializers.VAR_INTEGER.read(salt.endingPosition(), packetBytes);
        NetEntryData<Byte[]> sign = NetSerializers.byteArray(signLength.value()).read(signLength.endingPosition(),
                packetBytes);
        NetEntryData<Boolean> preview = NetSerializers.BOOLEAN.read(sign.endingPosition(), packetBytes);

        this.message = message.value();
        this.timestamp = timestamp.value();
        this.salt = salt.value();
        this.sign = sign.value();
        this.preview = preview.value();
        return this;
    }

    @Override
    public @NotNull IncomingMessagePacket build() {
        return new IncomingMessagePacket(this);
    }

    @Override
    public IncomingPacketBuilder<IncomingMessagePacket> reset() {
        this.message = null;
        this.preview = false;
        this.salt = 0;
        this.sign = new Byte[0];
        this.timestamp = 0;
        return this;
    }

    @Override
    public IncomingPacketBuilder<IncomingMessagePacket> copy() {
        return new IncomingMessagePacketBuilder()
                .setMessage(this.message)
                .setPreview(this.preview)
                .setSalt(this.salt)
                .setTimestamp(this.timestamp)
                ;
    }

    @Override
    public int getId() {
        return IncomingMessagePacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
