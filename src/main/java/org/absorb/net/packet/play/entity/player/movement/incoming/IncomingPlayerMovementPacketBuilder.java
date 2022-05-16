package org.absorb.net.packet.play.entity.player.movement.incoming;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.Serializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

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
    public PacketBuilder<IncomingPlayerMovementPacket> from(ByteBuffer packetBytes) {
        NetEntryData<Double> xBuffer = Serializers.DOUBLE.read(0, packetBytes);
        NetEntryData<Double> yBuffer = Serializers.DOUBLE.read(xBuffer.endingPosition(), packetBytes);
        NetEntryData<Double> zBuffer = Serializers.DOUBLE.read(yBuffer.endingPosition(), packetBytes);
        NetEntryData<Float> yawBuffer = Serializers.FLOAT.read(zBuffer.endingPosition(), packetBytes);
        NetEntryData<Float> pitchBuffer = Serializers.FLOAT.read(yawBuffer.endingPosition(), packetBytes);
        NetEntryData<Boolean> onGroup = Serializers.BOOLEAN.read(pitchBuffer.endingPosition(), packetBytes);

        this.x = xBuffer.value();
        this.y = yBuffer.value();
        this.z = zBuffer.value();
        this.pitch = pitchBuffer.value();
        this.yaw = yawBuffer.value();
        this.isOnGround = onGroup.value();
        return this;
    }

    @Override
    public @NotNull IncomingPlayerMovementPacket build() {
        return new IncomingPlayerMovementPacket(this);
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
        return new IncomingPlayerMovementPacketBuilder().setOnGround(this.isOnGround).setZ(this.z).setY(this.y).setX(this.x).setYaw(this.yaw).setPitch(this.pitch);
    }

    @Override
    public int getId() {
        return IncomingPlayerMovementPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
