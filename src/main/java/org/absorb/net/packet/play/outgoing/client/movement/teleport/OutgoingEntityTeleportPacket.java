package org.absorb.net.packet.play.outgoing.client.movement.teleport;

import org.absorb.net.Client;
import org.absorb.net.data.NetUtils;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class OutgoingEntityTeleportPacket implements OutgoingPacket {

    public static final int ID = 0x63;

    private final int entityId;
    private final double x;
    private final double y;
    private final double z;
    private final boolean onGround;
    private final byte yaw;
    private final byte pitch;

    public OutgoingEntityTeleportPacket(OutgoingEntityTeleportPacketBuilder builder) {
        this.entityId = builder.getEntityId();
        this.x = builder.getX();
        this.y = builder.getY();
        this.z = builder.getZ();
        this.onGround = builder.isOnGround();
        this.yaw = builder.getYaw();
        this.pitch = builder.getPitch();
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
        return new OutgoingEntityTeleportPacketBuilder()
                .setZ(this.z)
                .setY(this.y)
                .setX(this.x)
                .setYaw(this.yaw)
                .setPitch(this.pitch)
                .setOnGround(this.onGround);
    }

    @Override
    public ByteBuffer toBytes(Client stream) {
        ByteBuffer entityIdBuffer = NetSerializers.VAR_INTEGER.write(this.entityId);
        ByteBuffer xBuffer = NetSerializers.DOUBLE.write(this.x);
        ByteBuffer yBuffer = NetSerializers.DOUBLE.write(this.y);
        ByteBuffer zBuffer = NetSerializers.DOUBLE.write(this.z);
        ByteBuffer yawBuffer = NetSerializers.BYTE.write(this.yaw);
        ByteBuffer pitchBuffer = NetSerializers.BYTE.write(this.pitch);
        ByteBuffer onGroundBuffer = NetSerializers.BOOLEAN.write(this.onGround);
        return NetUtils.createPacket(ID, entityIdBuffer, xBuffer, yBuffer, zBuffer, yawBuffer, pitchBuffer, onGroundBuffer);
    }
}
