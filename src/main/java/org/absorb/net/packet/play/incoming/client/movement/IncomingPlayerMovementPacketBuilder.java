package org.absorb.net.packet.play.incoming.client.movement;

import org.absorb.net.Client;
import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3d;

import java.nio.ByteBuffer;

public class IncomingPlayerMovementPacketBuilder implements IncomingPacketBuilder<IncomingPlayerMovementPacket> {

    private double x;
    private double y;
    private double z;
    private float yaw;
    private float pitch;
    private boolean isOnGround;

    public double getX() {
        return this.x;
    }

    public IncomingPlayerMovementPacketBuilder setX(double x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return this.y;
    }

    public IncomingPlayerMovementPacketBuilder setY(double y) {
        this.y = y;
        return this;
    }

    public double getZ() {
        return this.z;
    }

    public IncomingPlayerMovementPacketBuilder setZ(double z) {
        this.z = z;
        return this;
    }

    public float getYaw() {
        return this.yaw;
    }

    public IncomingPlayerMovementPacketBuilder setYaw(float yaw) {
        this.yaw = yaw;
        return this;
    }

    public float getPitch() {
        return this.pitch;
    }

    public IncomingPlayerMovementPacketBuilder setPitch(float pitch) {
        this.pitch = pitch;
        return this;
    }

    public boolean isOnGround() {
        return this.isOnGround;
    }

    public IncomingPlayerMovementPacketBuilder setOnGround(boolean onGround) {
        this.isOnGround = onGround;
        return this;
    }

    @Override
    public PacketBuilder<IncomingPlayerMovementPacket> from(Client client, ByteBuffer packetBytes) {
        NetEntryData<Double> xBuffer = NetSerializers.DOUBLE.read(0, packetBytes);
        NetEntryData<Double> yBuffer = NetSerializers.DOUBLE.read(xBuffer.endingPosition(), packetBytes);
        NetEntryData<Double> zBuffer = NetSerializers.DOUBLE.read(yBuffer.endingPosition(), packetBytes);
        NetEntryData<Float> yawBuffer = NetSerializers.FLOAT.read(zBuffer.endingPosition(), packetBytes);
        NetEntryData<Float> pitchBuffer = NetSerializers.FLOAT.read(yawBuffer.endingPosition(), packetBytes);
        NetEntryData<Boolean> onGroup = NetSerializers.BOOLEAN.read(pitchBuffer.endingPosition(), packetBytes);

        this.x = xBuffer.value();
        this.y = yBuffer.value();
        this.z = zBuffer.value();
        this.pitch = pitchBuffer.value();
        this.yaw = yawBuffer.value();
        this.isOnGround = onGroup.value();
        return this;
    }

    @Override
    public IncomingPacketBuilder<IncomingPlayerMovementPacket> reset() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.yaw = 0;
        this.pitch = 0;
        this.isOnGround = false;
        return this;
    }

    @Override
    public IncomingPacketBuilder<IncomingPlayerMovementPacket> copy() {
        return new IncomingPlayerMovementPacketBuilder()
                .setOnGround(this.isOnGround)
                .setZ(this.z)
                .setY(this.y)
                .setX(this.x)
                .setYaw(this.yaw)
                .setPitch(this.pitch);
    }

    @Override
    public @NotNull IncomingPlayerMovementPacket build() {
        return new IncomingPlayerMovementPacket(this);
    }

    @Override
    public @NotNull Builder<IncomingPlayerMovementPacket> from(IncomingPlayerMovementPacket value) {
        this.x = value.getX();
        this.y = value.getY();
        this.z = value.getZ();
        this.yaw = value.getYaw();
        this.pitch = value.getPitch();
        this.isOnGround = value.isOnGround();
        return this;
    }

    @Override
    public int getId() {
        return IncomingPlayerMovementPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }

    public IncomingPlayerMovementPacketBuilder setPosition(Vector3d position) {
        this.x = position.x();
        this.y = position.y();
        this.z = position.z();
        return this;
    }
}
