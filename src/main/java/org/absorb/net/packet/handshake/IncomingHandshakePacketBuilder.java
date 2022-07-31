package org.absorb.net.packet.handshake;

import org.absorb.net.Client;
import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class IncomingHandshakePacketBuilder implements IncomingPacketBuilder<IncomingHandshakePacket> {

    private String joiningFrom;
    private short port;
    private int packetVersion;
    private HandshakeState state;

    public IncomingHandshakePacketBuilder() {
        this.reset();
    }

    public short getPort() {
        return this.port;
    }

    public IncomingHandshakePacketBuilder setPort(short port) {
        this.port = port;
        return this;
    }

    public HandshakeState getHandshakeState() {
        return this.state;
    }

    public int getPacketVersion() {
        return this.packetVersion;
    }

    public IncomingHandshakePacketBuilder setPacketVersion(int packetVersion) {
        this.packetVersion = packetVersion;
        return this;
    }

    public String getJoiningFrom() {
        return this.joiningFrom;
    }

    public IncomingHandshakePacketBuilder setJoiningFrom(String joiningFrom) {
        this.joiningFrom = joiningFrom;
        return this;
    }

    @Override
    public @NotNull IncomingHandshakePacket build() {
        return new IncomingHandshakePacket(this);
    }

    @Override
    public @NotNull Builder<IncomingHandshakePacket> from(IncomingHandshakePacket value) {
        this.joiningFrom = value.getJoiningFrom();
        this.packetVersion = value.getProtocolVersionId();
        this.port = value.getPort();
        this.state = value.getHandshakeState();
        return this;
    }

    @Override
    public int getId() {
        return IncomingHandshakePacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.HANDSHAKE;
    }

    public IncomingHandshakePacketBuilder setState(HandshakeState state) {
        this.state = state;
        return this;
    }

    @Override
    public @NotNull PacketBuilder<IncomingHandshakePacket> from(@NotNull Client client,
                                                                @NotNull ByteBuffer packetBytes) {
        NetEntryData<Integer> mcVersion = NetSerializers.VAR_INTEGER.read(0, packetBytes);
        NetEntryData<String> ip = NetSerializers.STRING.read(mcVersion.endingPosition(), packetBytes);
        NetEntryData<Short> port;
        try {
            port = NetSerializers.UNSIGNED_SHORT.read(ip.endingPosition(), packetBytes);
        } catch (ArrayIndexOutOfBoundsException e) {
            port = new NetEntryData<>(ip.endingPosition(), ip.endingPosition(), (short) 25565);
        }
        NetEntryData<Integer> status = NetSerializers.VAR_INTEGER.read(port.endingPosition(), packetBytes);
        this.setJoiningFrom(ip.value());
        this.setPacketVersion(mcVersion.value());
        this.setState(HandshakeState.getValue(status.value()));
        this.setPort(port.value());

        return this;
    }

    @Override
    public @NotNull IncomingHandshakePacketBuilder reset() {
        this.joiningFrom = null;
        this.packetVersion = 0;
        this.port = 25565;
        this.state = HandshakeState.STATUS;
        return this;
    }

    @Override
    public @NotNull IncomingHandshakePacketBuilder copy() {
        return new IncomingHandshakePacketBuilder()
                .setPacketVersion(this.packetVersion)
                .setJoiningFrom(this.joiningFrom)
                .setPort(this.port)
                .setState(this.state);
    }
}
