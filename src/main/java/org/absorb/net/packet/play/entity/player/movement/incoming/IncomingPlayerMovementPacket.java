package org.absorb.net.packet.play.entity.player.movement.incoming;

import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.play.entity.player.movement.PlayerMovementProcessor;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3d;

public class IncomingPlayerMovementPacket implements IncomingPacket {

    public static final int ID = 0x12;

    private final double x;
    private final double y;
    private final double z;
    private final float yaw;
    private final float pitch;
    private final boolean isOnGround;

    public IncomingPlayerMovementPacket(@NotNull IncomingPlayerMovementPacketBuilder packet) {
        this.x = packet.getX();
        this.y = packet.getY();
        this.z = packet.getZ();
        this.yaw = packet.getYaw();
        this.pitch = packet.getPitch();
        this.isOnGround = packet.isOnGround();
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

    public Vector3d getPosition() {
        return new Vector3d(this.getX(), this.getY(), this.getZ());
    }

    public float getYaw() {
        return this.yaw;
    }

    public float getPitch() {
        return this.pitch;
    }

    public boolean isOnGround() {
        return this.isOnGround;
    }

    @Override
    public @NotNull <P extends IncomingPacket> NetProcess<P> getProcess() {
        return (NetProcess<P>) new PlayerMovementProcessor();
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
    public @NotNull PacketBuilder<? extends Packet> toBuilder() {
        return new IncomingPlayerMovementPacketBuilder().setPitch(this.pitch).setYaw(this.yaw).setX(this.x).setY(this.y).setZ(this.z).setOnGround(this.isOnGround);
    }
}
