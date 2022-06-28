package org.absorb.net.packet.play.incoming.client.movement.basic;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class IncomingBasicPlayerMovementPacketBuilder implements IncomingPacketBuilder<IncomingBasicPlayerMovementPacket> {

    private double x;
    private double y;
    private double z;
    private boolean isOnGround;

    public double getX() {
        return this.x;
    }

    public IncomingBasicPlayerMovementPacketBuilder setX(double x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return this.y;
    }

    public IncomingBasicPlayerMovementPacketBuilder setY(double y) {
        this.y = y;
        return this;
    }

    public double getZ() {
        return this.z;
    }

    public IncomingBasicPlayerMovementPacketBuilder setZ(double z) {
        this.z = z;
        return this;
    }

    public boolean isOnGround() {
        return this.isOnGround;
    }

    public IncomingBasicPlayerMovementPacketBuilder setOnGround(boolean onGround) {
        this.isOnGround = onGround;
        return this;
    }

    @Override
    public @NotNull IncomingBasicPlayerMovementPacket build() {
        return new IncomingBasicPlayerMovementPacket(this);
    }

    @Override
    public PacketBuilder<IncomingBasicPlayerMovementPacket> from(ByteBuffer packetBytes) {
        NetEntryData<Double> x = NetSerializers.DOUBLE.read(0, packetBytes);
        NetEntryData<Double> y = NetSerializers.DOUBLE.read(x.endingPosition(), packetBytes);
        NetEntryData<Double> z = NetSerializers.DOUBLE.read(y.endingPosition(), packetBytes);
        NetEntryData<Boolean> onGround = NetSerializers.BOOLEAN.read(z.endingPosition(), packetBytes);

        this.x = x.value();
        this.y = y.value();
        this.z = z.value();
        this.isOnGround = onGround.value();
        return this;
    }

    @Override
    public @NotNull IncomingBasicPlayerMovementPacketBuilder reset() {
        this.isOnGround = true;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        return this;
    }

    @Override
    public @NotNull IncomingBasicPlayerMovementPacketBuilder copy() {
        return new IncomingBasicPlayerMovementPacketBuilder().setOnGround(this.isOnGround).setX(this.x).setY(this.y).setZ(this.z);
    }

    @Override
    public int getId() {
        return IncomingBasicPlayerMovementPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }

}
