package org.absorb.net.packet.play.incoming.client.movement.rotation;

import org.absorb.net.Client;
import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class IncomingRotationPacketBuilder implements IncomingPacketBuilder<IncomingRotationPacket> {

    private float yaw;
    private float pitch;
    private boolean isOnGround;

    public float getYaw() {
        return this.yaw;
    }

    public IncomingRotationPacketBuilder setYaw(float yaw) {
        this.yaw = yaw;
        return this;
    }

    public float getPitch() {
        return this.pitch;
    }

    public IncomingRotationPacketBuilder setPitch(float pitch) {
        this.pitch = pitch;
        return this;
    }

    public boolean isOnGround() {
        return this.isOnGround;
    }

    public IncomingRotationPacketBuilder setOnGround(boolean onGround) {
        this.isOnGround = onGround;
        return this;
    }

    @Override
    public PacketBuilder<IncomingRotationPacket> from(Client client, ByteBuffer packetBytes) {
        NetEntryData<Float> yaw = NetSerializers.FLOAT.read(0, packetBytes);
        NetEntryData<Float> pitch = NetSerializers.FLOAT.read(yaw.endingPosition(), packetBytes);
        NetEntryData<Boolean> isOnGround = NetSerializers.BOOLEAN.read(pitch.endingPosition(), packetBytes);

        this.pitch = pitch.value();
        this.yaw = yaw.value();
        this.isOnGround = isOnGround.value();
        return this;
    }

    @Override
    public IncomingPacketBuilder<IncomingRotationPacket> reset() {
        this.isOnGround = false;
        this.pitch = 0;
        this.yaw = 0;
        return this;
    }

    @Override
    public IncomingPacketBuilder<IncomingRotationPacket> copy() {
        return new IncomingRotationPacketBuilder().setOnGround(this.isOnGround).setPitch(this.pitch).setYaw(this.yaw);
    }

    @Override
    public @NotNull IncomingRotationPacket build() {
        return new IncomingRotationPacket(this);
    }

    @Override
    public int getId() {
        return IncomingRotationPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
