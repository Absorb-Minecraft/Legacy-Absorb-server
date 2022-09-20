package org.absorb.net.packet.play.incoming.client.movement.rotation;

import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.play.entity.player.movement.PlayerMovementProcessorRotationWrapper;
import org.jetbrains.annotations.NotNull;

public class IncomingRotationPacket implements IncomingPacket {

    private final float yaw;
    private final float pitch;
    private final boolean isOnGround;
    public static final int ID = 0x16;

    public IncomingRotationPacket(IncomingRotationPacketBuilder builder) {
        this.isOnGround = builder.isOnGround();
        this.pitch = builder.getPitch();
        this.yaw = builder.getYaw();
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
        return (NetProcess<P>) new PlayerMovementProcessorRotationWrapper();
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
        return new IncomingRotationPacketBuilder().setYaw(this.yaw).setPitch(this.pitch).setOnGround(this.isOnGround);
    }
}
