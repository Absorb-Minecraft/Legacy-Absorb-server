package org.absorb.net.packet.status.ping;

import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.NetProcessors;

public class IncomingPingPacket implements IncomingPacket {

    public static final int ID = 0x01;

    private final long payload;

    public IncomingPingPacket(IncomingPingPacketBuilder builder) {
        this.payload = builder.getPayload();
    }

    public long getPayload() {
        return this.payload;
    }

    @Override
    public <P extends IncomingPacket> NetProcess<P> getProcess() {
        return (NetProcess<P>) NetProcessors.PING;
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public PacketState getState() {
        return PacketState.STATUS;
    }

    @Override
    public IncomingPingPacketBuilder toBuilder() {
        return new IncomingPingPacketBuilder().setPayload(this.payload);
    }
}
