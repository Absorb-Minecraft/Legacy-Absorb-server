package org.absorb.net.packet.status.ping;

import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.NetProcessors;
import org.jetbrains.annotations.NotNull;

public class IncomingPingPacket implements IncomingPacket {

    public static final int ID = 0x01;
    public static final int PLAY_ID = 0x1D;

    private final long payload;
    private final boolean usePlay;

    public IncomingPingPacket(IncomingPingPacketBuilder builder) {
        this.payload = builder.getPayload();
        this.usePlay = builder.isUsePlay();
    }

    public boolean isUsePlay() {
        return this.usePlay;
    }

    public long getPayload() {
        return this.payload;
    }

    @Override
    public <P extends IncomingPacket> @NotNull NetProcess<P> getProcess() {
        return (NetProcess<P>) NetProcessors.PING;
    }

    @Override
    public int getId() {
        if (this.usePlay) {
            return PLAY_ID;
        }
        return ID;
    }

    @Override
    public @NotNull PacketState getState() {
        if (this.usePlay) {
            return PacketState.PLAY;
        }
        return PacketState.STATUS;
    }

    @Override
    public @NotNull IncomingPingPacketBuilder toBuilder() {
        return new IncomingPingPacketBuilder().setPayload(this.payload);
    }
}
