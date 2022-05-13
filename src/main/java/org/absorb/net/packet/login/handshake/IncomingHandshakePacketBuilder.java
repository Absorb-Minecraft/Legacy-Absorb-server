package org.absorb.net.packet.login.handshake;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.Serializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;

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

    public IncomingHandshakePacketBuilder setState(HandshakeState state) {
        this.state = state;
        return this;
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
    public PacketState getState() {
        return PacketState.HANDSHAKE;
    }

    @Override
    public IncomingHandshakePacket build() {
        return new IncomingHandshakePacket(this);
    }

    @Override
    public IncomingHandshakePacketBuilder reset() {
        this.joiningFrom = null;
        this.packetVersion = 0;
        this.port = 25565;
        this.state = HandshakeState.STATUS;
        return this;
    }

    @Override
    public IncomingHandshakePacketBuilder copy() {
        return new IncomingHandshakePacketBuilder().setPacketVersion(this.packetVersion).setJoiningFrom(this.joiningFrom).setPort(this.port).setState(this.state);
    }

    @Override
    public int getId() {
        return IncomingHandshakePacket.ID;
    }

    @Override
    public PacketBuilder<IncomingHandshakePacket> from(ByteBuffer packetBytes) {
        NetEntryData<Integer> mcVersion = Serializers.VAR_INTEGER.read(0, packetBytes);
        NetEntryData<String> ip = Serializers.STRING.read(mcVersion.endingPosition(), packetBytes);
        NetEntryData<Short> port;
        try {
            port = Serializers.UNSIGNED_SHORT.read(ip.endingPosition(), packetBytes);
        } catch (ArrayIndexOutOfBoundsException e) {
            port = new NetEntryData<>(ip.endingPosition(), ip.endingPosition(), (short) 25565);
        }
        NetEntryData<Integer> status = Serializers.VAR_INTEGER.read(port.endingPosition(), packetBytes);
        this.setJoiningFrom(ip.value());
        this.setPacketVersion(mcVersion.value());
        this.setState(HandshakeState.getValue(status.value()));
        this.setPort(port.value());

        return this;
    }
}
