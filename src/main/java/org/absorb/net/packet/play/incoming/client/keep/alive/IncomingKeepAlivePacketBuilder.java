package org.absorb.net.packet.play.incoming.client.keep.alive;

import org.absorb.net.Client;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class IncomingKeepAlivePacketBuilder implements IncomingPacketBuilder<IncomingKeepAlivePacket> {

    private long keepAliveId;

    public long getKeepAliveId() {
        return this.keepAliveId;
    }

    public IncomingKeepAlivePacketBuilder setKeepAliveId(long keepAliveId) {
        this.keepAliveId = keepAliveId;
        return this;
    }

    @Override
    public @NotNull PacketBuilder<IncomingKeepAlivePacket> from(@NotNull Client connection,
                                                                @NotNull ByteBuffer packetBytes) {
        this.keepAliveId = NetSerializers.LONG.read(0, packetBytes).value();
        return this;
    }

    @Override
    public @NotNull IncomingPacketBuilder<IncomingKeepAlivePacket> reset() {
        this.keepAliveId = 0;
        return this;
    }

    @Override
    public @NotNull IncomingPacketBuilder<IncomingKeepAlivePacket> copy() {
        return new IncomingKeepAlivePacketBuilder();
    }

    @Override
    public @NotNull IncomingKeepAlivePacket build() {
        return new IncomingKeepAlivePacket(this);
    }

    @Override
    public int getId() {
        return IncomingKeepAlivePacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
