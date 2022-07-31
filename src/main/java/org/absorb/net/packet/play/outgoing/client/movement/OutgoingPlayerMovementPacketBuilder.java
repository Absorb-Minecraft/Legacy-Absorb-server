package org.absorb.net.packet.play.outgoing.client.movement;

import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3d;

public class OutgoingPlayerMovementPacketBuilder implements OutgoingPacketBuilder<OutgoingPlayerMovementPacket> {

    private double x;
    private double y;
    private double z;
    private float yaw;
    private float pitch;
    private int teleportId;
    private boolean dismount;


    public double getX() {
        return this.x;
    }

    public OutgoingPlayerMovementPacketBuilder setX(double x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return this.y;
    }

    public OutgoingPlayerMovementPacketBuilder setY(double y) {
        this.y = y;
        return this;
    }

    public double getZ() {
        return this.z;
    }

    public OutgoingPlayerMovementPacketBuilder setZ(double z) {
        this.z = z;
        return this;
    }

    public OutgoingPlayerMovementPacketBuilder setPosition(Vector3d vector3d) {
        this.setX(vector3d.x());
        this.setY(vector3d.y());
        this.setZ(vector3d.z());
        return this;
    }

    public float getYaw() {
        return this.yaw;
    }

    public OutgoingPlayerMovementPacketBuilder setYaw(float yaw) {
        this.yaw = yaw;
        return this;
    }

    public float getPitch() {
        return this.pitch;
    }

    public OutgoingPlayerMovementPacketBuilder setPitch(float pitch) {
        this.pitch = pitch;
        return this;
    }

    public int getTeleportId() {
        return this.teleportId;
    }

    public OutgoingPlayerMovementPacketBuilder setTeleportId(int teleportId) {
        this.teleportId = teleportId;
        return this;
    }

    public boolean isDismounting() {
        return this.dismount;
    }

    public OutgoingPlayerMovementPacketBuilder setDismounting(boolean dismount) {
        this.dismount = dismount;
        return this;
    }

    @Override
    public @NotNull OutgoingPlayerMovementPacket build() {
        return new OutgoingPlayerMovementPacket(this);
    }

    @Override
    public @NotNull Builder<OutgoingPlayerMovementPacket> from(OutgoingPlayerMovementPacket value) {
        this.dismount = value.isDismount();
        this.x = value.getX();
        this.y = value.getY();
        this.z = value.getZ();
        this.yaw = value.getYaw();
        this.pitch = value.getPitch();
        this.teleportId = value.getTeleportId();

        return this;
    }

    @Override
    public @NotNull PacketBuilder<OutgoingPlayerMovementPacket> reset() {
        this.dismount = false;
        this.pitch = 0;
        this.yaw = 0;
        this.teleportId = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        return this;
    }

    @Override
    public @NotNull PacketBuilder<OutgoingPlayerMovementPacket> copy() {
        return new OutgoingPlayerMovementPacketBuilder()
                .setDismounting(this.dismount)
                .setPitch(this.pitch)
                .setYaw(this.yaw)
                .setTeleportId(this.teleportId)
                .setX(this.x)
                .setY(this.y)
                .setZ(this.z);
    }

    @Override
    public int getId() {
        return OutgoingPlayerMovementPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
