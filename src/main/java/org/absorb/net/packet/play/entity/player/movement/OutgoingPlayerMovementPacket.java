package org.absorb.net.packet.play.entity.player.movement;

import org.absorb.net.Client;
import org.absorb.net.data.SerializerUtils;
import org.absorb.net.data.Serializers;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.ByteBuffer;

public class OutgoingPlayerMovementPacket implements OutgoingPacket {

    public static final int ID = 0x38;

    private final double x;
    private final double y;
    private final double z;
    private final float yaw;
    private final float pitch;
    private final byte flag = 0;
    private final int teleportId;
    private final boolean dismount;

    public OutgoingPlayerMovementPacket(@NotNull OutgoingPlayerMovementPacketBuilder builder) {
        this.x = builder.getX();
        this.y = builder.getY();
        this.z = builder.getZ();
        this.teleportId = builder.getTeleportId();
        this.dismount = builder.isDismounting();
        this.pitch = builder.getPitch();
        this.yaw = builder.getYaw();
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public float getYaw() {
        return this.yaw;
    }

    public float getPitch() {
        return this.pitch;
    }

    public byte getFlag() {
        return this.flag;
    }

    public int getTeleportId() {
        return this.teleportId;
    }

    public boolean isDismounting() {
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
        return new OutgoingPlayerMovementPacketBuilder().setZ(this.z).setY(this.y).setX(this.x).setTeleportId(this.teleportId).setPitch(this.pitch).setYaw(this.yaw);
    }

    @Override
    public void send(@NotNull Client stream) {
        ByteBuffer x = Serializers.DOUBLE.write(this.x);
        ByteBuffer y = Serializers.DOUBLE.write(this.y);
        ByteBuffer z = Serializers.DOUBLE.write(this.z);
        ByteBuffer yaw = Serializers.FLOAT.write(this.yaw);
        ByteBuffer pitch = Serializers.FLOAT.write(this.pitch);
        ByteBuffer flags = Serializers.BYTE.write(this.flag);
        ByteBuffer teleportId = Serializers.VAR_INTEGER.write(this.teleportId);
        ByteBuffer dismount = Serializers.BOOLEAN.write(this.dismount);
        try {
            stream.write(SerializerUtils.createPacket(ID, x, y, z, yaw, pitch, flags, teleportId, dismount));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
