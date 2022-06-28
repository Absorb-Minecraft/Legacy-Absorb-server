package org.absorb.net.packet.play.outgoing.client.compass;

import org.absorb.net.Client;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3i;

import java.nio.ByteBuffer;

public class OutgoingSpawnPositionPacket implements OutgoingPacket {

    public static final int ID = 0x4A;

    private final Vector3i location;
    private final float angle;

    public OutgoingSpawnPositionPacket(@NotNull OutgoingSpawnPositionPacketBuilder builder) {
        this.location = builder.getLocation();
        this.angle = builder.getAngle();
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
        return new OutgoingSpawnPositionPacketBuilder().setLocation(this.location).setAngle(this.angle);
    }

    @Override
    public ByteBuffer toBytes(@NotNull Client stream) {
        ByteBuffer pos = NetSerializers.POSITION.write(this.location);
        ByteBuffer angle = NetSerializers.FLOAT.write(this.angle);
        return NetUtils.createPacket(ID, pos, angle);
    }
}
