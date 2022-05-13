package org.absorb.net.packet.play.entity.player.compass;

import org.absorb.net.Client;
import org.absorb.net.data.SerializerUtils;
import org.absorb.net.data.Serializers;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3i;

import java.io.IOException;
import java.nio.ByteBuffer;

public class OutgoingSpawnPositionPacket implements OutgoingPacket {

    public static final int ID = 0x4B;

    private final Vector3i location;
    private final float angle;

    public OutgoingSpawnPositionPacket(@NotNull OutgoingSpawnPositionPacketBuilder builder) {
        this.location = builder.getLocation();
        this.angle = builder.getAngle();
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
    public @NotNull OutgoingPacketBuilder<? extends Packet> toBuilder() {
        return new OutgoingSpawnPositionPacketBuilder().setLocation(this.location).setAngle(this.angle);
    }

    @Override
    public void send(@NotNull Client stream) {
        ByteBuffer pos = Serializers.POSITION.write(this.location);
        ByteBuffer angle = Serializers.FLOAT.write(this.angle);
        ByteBuffer ret = SerializerUtils.createPacket(ID, pos, angle);
        try {
            stream.write(ret);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
