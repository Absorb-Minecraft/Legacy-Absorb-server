package org.absorb.net.packet.play.outgoing.client.keep.alive;

import org.absorb.net.Client;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class OutgoingKeepAlivePacket implements OutgoingPacket {

    public final long generatedLong;
    public static final int ID = 0x1E;

    public OutgoingKeepAlivePacket(OutgoingKeepAlivePacketBuilder packet) {
        this.generatedLong = packet.getGeneratedId();
    }

    public long getGeneratedId() {
        return this.generatedLong;
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
    public @NotNull OutgoingPacketBuilder<? extends Packet> toBuilder() {
        return new OutgoingKeepAlivePacketBuilder().setGeneratedId(this.generatedLong);
    }

    @Override
    public ByteBuffer toBytes(Client stream) {
        return NetUtils.createPacket(ID, NetSerializers.LONG.write(this.generatedLong));
    }
}
