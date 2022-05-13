package org.absorb.net.packet.status.request;

import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.packet.login.handshake.IncomingHandshakePacketBuilder;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.NetProcessors;

public class IncomingStatusRequestPacket implements IncomingPacket {

    public static final int ID = 0;

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public PacketState getState() {
        return PacketState.STATUS;
    }

    @Override
    public PacketBuilder<? extends Packet> toBuilder() {
        return new IncomingStatusRequestPacketBuilder();
    }

    @Override
    public <P extends IncomingPacket> NetProcess<P> getProcess() {
        return (NetProcess<P>) NetProcessors.STATUS;
    }
}
