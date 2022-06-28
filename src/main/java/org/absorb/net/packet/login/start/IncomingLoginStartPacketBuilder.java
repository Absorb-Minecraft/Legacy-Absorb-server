package org.absorb.net.packet.login.start;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class IncomingLoginStartPacketBuilder implements IncomingPacketBuilder<IncomingLoginStartPacket> {

    private String username;
    private Long timestamp;
    private Byte[] publicKey;
    private Byte[] publicSign;

    public IncomingLoginStartPacketBuilder() {
        this.reset();
    }

    public String getUsername() {
        return this.username;
    }

    public IncomingLoginStartPacketBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public IncomingLoginStartPacketBuilder setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public IncomingLoginStartPacketBuilder setPublicKey(Byte... array) {
        this.publicKey = array;
        return this;
    }

    public Byte[] getPublicKey() {
        return this.publicKey;
    }

    public IncomingLoginStartPacketBuilder setPublicSignature(Byte... array) {
        this.publicSign = array;
        return this;
    }

    public Byte[] getPublicSignature() {
        return this.publicSign;
    }

    @Override
    public PacketBuilder<IncomingLoginStartPacket> from(ByteBuffer packetBytes) {
        NetEntryData<String> userName = NetSerializers.STRING.read(0, packetBytes);
        NetEntryData<Boolean> hasSignData = NetSerializers.BOOLEAN.read(userName.endingPosition(), packetBytes);
        if (!hasSignData.value()) {
            this.username = userName.value();
            return this;
        }
        NetEntryData<Long> timestamp = NetSerializers.LONG.read(hasSignData.endingPosition(), packetBytes);
        NetEntryData<Integer> publicKeyLength = NetSerializers.VAR_INTEGER.read(timestamp.endingPosition(), packetBytes);
        NetEntryData<Byte[]> publicKey =
                NetSerializers.byteArray(publicKeyLength.value()).read(publicKeyLength.endingPosition(),
                        packetBytes);
        NetEntryData<Integer> publicSignLength = NetSerializers.VAR_INTEGER.read(publicKey.endingPosition(), packetBytes);
        NetEntryData<Byte[]> publicSign =
                NetSerializers.byteArray(publicSignLength.value()).read(publicSignLength.endingPosition(),
                        packetBytes);

        this.username = userName.value();
        this.timestamp = timestamp.value();
        this.publicKey = publicKey.value();
        this.publicSign = publicSign.value();
        return this;
    }

    @Override
    public @NotNull IncomingLoginStartPacket build() {
        return new IncomingLoginStartPacket(this);
    }

    @Override
    public @NotNull IncomingLoginStartPacketBuilder reset() {
        this.username = null;
        this.publicSign = null;
        this.timestamp = null;
        this.publicKey = null;
        return this;
    }

    @Override
    public @NotNull IncomingLoginStartPacketBuilder copy() {
        return new IncomingLoginStartPacketBuilder()
                .setUsername(this.username)
                .setPublicKey(this.publicKey)
                .setTimestamp(this.timestamp)
                .setPublicSignature(this.publicSign);
    }

    @Override
    public int getId() {
        return IncomingLoginStartPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.LOGIN;
    }
}
