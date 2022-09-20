package org.absorb.net.packet.play.outgoing.client.movement;

import org.absorb.net.Client;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class OutgoingPlayerMovementPacket implements OutgoingPacket {

    private final double deltaX;
    private final double deltaY;
    private final double deltaZ;
    private final float yaw;
    private final float pitch;
    private final int teleportId;
    private final boolean dismount;
    public static final int ID = 0x39;

    public OutgoingPlayerMovementPacket(@NotNull OutgoingPlayerMovementPacketBuilder builder) {
        this.deltaX = builder.getX();
        this.deltaY = builder.getY();
        this.deltaZ = builder.getZ();
        this.teleportId = builder.getTeleportId();
        this.dismount = builder.isDismounting();
        this.pitch = builder.getPitch();
        this.yaw = builder.getYaw();
    }

    public double getX() {
        return this.deltaX;
    }

    public double getY() {
        return this.deltaY;
    }

    public double getZ() {
        return this.deltaZ;
    }

    public float getYaw() {
        return this.yaw;
    }

    public float getPitch() {
        return this.pitch;
    }

    public int getTeleportId() {
        return this.teleportId;
    }

    public boolean isDismount() {
        return this.dismount;
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
        return new OutgoingPlayerMovementPacketBuilder()
                .setZ(this.deltaZ)
                .setY(this.deltaY)
                .setX(this.deltaX)
                .setTeleportId(this.teleportId)
                .setPitch(this.pitch)
                .setYaw(this.yaw)
                .setDismounting(this.dismount)
                .setTeleportId(this.teleportId);
    }

    @Override
    public ByteBuffer toBytes(@NotNull Client stream) {
        ByteBuffer x = NetSerializers.DOUBLE.write(this.deltaX);
        ByteBuffer y = NetSerializers.DOUBLE.write(this.deltaY);
        ByteBuffer z = NetSerializers.DOUBLE.write(this.deltaZ);
        ByteBuffer yaw = NetSerializers.FLOAT.write(this.yaw);
        ByteBuffer pitch = NetSerializers.FLOAT.write(this.pitch);
        ByteBuffer flags = NetSerializers.BYTE.write((byte) 0);
        ByteBuffer teleportId = NetSerializers.VAR_INTEGER.write(this.teleportId);
        ByteBuffer dismount = NetSerializers.BOOLEAN.write(this.dismount);
        return NetUtils.createPacket(ID, x, y, z, yaw, pitch, flags, teleportId, dismount);
    }
}
