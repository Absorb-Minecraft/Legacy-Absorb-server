package org.absorb.net.packet.play.outgoing.client.movement.teleport;

import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

public class OutgoingEntityTeleportPacketBuilder implements OutgoingPacketBuilder<OutgoingEntityTeleportPacket> {

    private int entityId;
    private double x;
    private double y;
    private double z;
    private boolean onGround;
    private byte yaw;
    private byte pitch;

    public int getEntityId() {
        return this.entityId;
    }

    public OutgoingEntityTeleportPacketBuilder setEntityId(int entityId) {
        this.entityId = entityId;
        return this;
    }

    public double getX() {
        return this.x;
    }

    public OutgoingEntityTeleportPacketBuilder setX(double x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return this.y;
    }

    public OutgoingEntityTeleportPacketBuilder setY(double y) {
        this.y = y;
        return this;
    }

    public double getZ() {
        return this.z;
    }

    public OutgoingEntityTeleportPacketBuilder setZ(double z) {
        this.z = z;
        return this;
    }

    public boolean isOnGround() {
        return this.onGround;
    }

    public OutgoingEntityTeleportPacketBuilder setOnGround(boolean onGround) {
        this.onGround = onGround;
        return this;
    }

    public byte getYaw() {
        return this.yaw;
    }

    public OutgoingEntityTeleportPacketBuilder setYaw(byte yaw) {
        this.yaw = yaw;
        return this;
    }

    public byte getPitch() {
        return this.pitch;
    }

    public OutgoingEntityTeleportPacketBuilder setPitch(byte pitch) {
        this.pitch = pitch;
        return this;
    }

    @Override
    public @NotNull OutgoingEntityTeleportPacket build() {
        return new OutgoingEntityTeleportPacket(this);
    }

    @Override
    public PacketBuilder<OutgoingEntityTeleportPacket> reset() {
        this.entityId = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.onGround = false;
        this.yaw = 0;
        this.pitch = 0;
        return this;
    }

    @Override
    public PacketBuilder<OutgoingEntityTeleportPacket> copy() {
        return new OutgoingEntityTeleportPacketBuilder().setEntityId(this.entityId).setOnGround(this.onGround).setPitch(this.pitch).setX(this.x).setY(this.y).setYaw(this.yaw).setZ(this.z);
    }

    @Override
    public int getId() {
        return OutgoingEntityTeleportPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
