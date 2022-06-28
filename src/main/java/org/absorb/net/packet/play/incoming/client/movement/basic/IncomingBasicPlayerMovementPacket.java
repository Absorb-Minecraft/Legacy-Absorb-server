package org.absorb.net.packet.play.incoming.client.movement.basic;

import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.play.entity.player.movement.PlayerMovementProcessorBasicWrapper;
import org.jetbrains.annotations.NotNull;

public class IncomingBasicPlayerMovementPacket implements IncomingPacket {

    public static final int ID = 0x13;

    private final double x;
    private final double y;
    private final double z;
    private final boolean isOnGround;


    public IncomingBasicPlayerMovementPacket(@NotNull IncomingBasicPlayerMovementPacketBuilder builder) {
        this.x = builder.getX();
        this.y = builder.getY();
        this.z = builder.getZ();
        this.isOnGround = builder.isOnGround();
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

    public boolean isOnGround() {
        return this.isOnGround;
    }

    @Override
    public @NotNull <P extends IncomingPacket> NetProcess<P> getProcess() {
        return (NetProcess<P>) new PlayerMovementProcessorBasicWrapper();
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
        return new IncomingBasicPlayerMovementPacketBuilder().setZ(z).setY(y).setX(x).setOnGround(isOnGround);
    }
}
