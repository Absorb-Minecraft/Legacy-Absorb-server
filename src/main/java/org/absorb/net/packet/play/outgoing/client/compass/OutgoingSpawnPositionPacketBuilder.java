package org.absorb.net.packet.play.outgoing.client.compass;

import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3i;

public class OutgoingSpawnPositionPacketBuilder implements OutgoingPacketBuilder<OutgoingSpawnPositionPacket> {

    private Vector3i location;
    private float angle;

    public @NotNull Vector3i getLocation() {
        return this.location;
    }

    public OutgoingSpawnPositionPacketBuilder setLocation(@NotNull Vector3i location) {
        this.location = location;
        return this;
    }

    public float getAngle() {
        return this.angle;
    }

    public OutgoingSpawnPositionPacketBuilder setAngle(float angle) {
        this.angle = angle;
        return this;
    }

    @Override
    public @NotNull OutgoingSpawnPositionPacket build() {
        return new OutgoingSpawnPositionPacket(this);
    }

    @Override
    public @NotNull Builder<OutgoingSpawnPositionPacket> from(OutgoingSpawnPositionPacket value) {
        this.angle = value.getAngle();
        this.location = value.getLocation();
        return this;
    }

    @Override
    public @NotNull PacketBuilder<OutgoingSpawnPositionPacket> reset() {
        this.location = null;
        this.angle = 0;
        return this;
    }

    @Override
    public @NotNull PacketBuilder<OutgoingSpawnPositionPacket> copy() {
        return new OutgoingSpawnPositionPacketBuilder().setAngle(this.angle).setLocation(this.location);
    }

    @Override
    public int getId() {
        return OutgoingSpawnPositionPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
