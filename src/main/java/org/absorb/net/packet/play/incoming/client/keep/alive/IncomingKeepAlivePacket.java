package org.absorb.net.packet.play.incoming.client.keep.alive;

import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.play.entity.KeepAliveProcessor;
import org.jetbrains.annotations.NotNull;

public class IncomingKeepAlivePacket implements IncomingPacket {

    private final long keepAliveId;
    public static final int ID = 0X11;

    public IncomingKeepAlivePacket(IncomingKeepAlivePacketBuilder builder) {
        this.keepAliveId = builder.getKeepAliveId();
    }

    public long getKeepAliveId() {
        return this.keepAliveId;
    }

    @Override
    public @NotNull <P extends IncomingPacket> NetProcess<P> getProcess() {
        return (NetProcess<P>) new KeepAliveProcessor();
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
    public @NotNull PacketBuilder<? extends Packet> toBuilder() {
        return new IncomingKeepAlivePacketBuilder().setKeepAliveId(this.keepAliveId);
    }
}
