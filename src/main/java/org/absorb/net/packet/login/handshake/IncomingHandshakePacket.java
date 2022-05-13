package org.absorb.net.packet.login.handshake;

import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.NetProcessors;

public class IncomingHandshakePacket implements IncomingPacket {

    public static final int ID = 0;

    private final String joiningFrom;
    private final short port;
    private final int mcNetworkId;
    private final HandshakeState status;

    public IncomingHandshakePacket(IncomingHandshakePacketBuilder builder) {
        this.joiningFrom = builder.getJoiningFrom();
        this.port = builder.getPort();
        this.mcNetworkId = builder.getPacketVersion();
        this.status = builder.getHandshakeState();
    }

    public short getPort() {
        return this.port;
    }

    public int getMcNetworkId() {
        return this.mcNetworkId;
    }

    public HandshakeState getHandshakeState() {
        return this.status;
    }

    public String getJoiningFrom() {
        return this.joiningFrom;
    }

    public int getProtocolVersionId() {
        return this.mcNetworkId;
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public PacketState getState() {
        return PacketState.HANDSHAKE;
    }

    @Override
    public IncomingHandshakePacketBuilder toBuilder() {
        return new IncomingHandshakePacketBuilder().setJoiningFrom(this.joiningFrom).setPort(this.port).setState(this.status).setPacketVersion(this.mcNetworkId);
    }

    @Override
    public <P extends IncomingPacket> NetProcess<P> getProcess() {
        return (NetProcess<P>) NetProcessors.HANDSHAKE;
    }
}
