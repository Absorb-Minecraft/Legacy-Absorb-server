package org.absorb.net.packet.play.entity.player.view;

import org.absorb.net.Client;
import org.absorb.net.data.SerializerUtils;
import org.absorb.net.data.Serializers;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class OutgoingUpdateViewPacket implements OutgoingPacket {

    public static final int ID = 0x49;

    private final int chunkX;
    private final int chunkZ;

    public OutgoingUpdateViewPacket(OutgoingUpdateViewPacketBuilder builder){
        this.chunkX = builder.getChunkX();
        this.chunkZ = builder.getChunkZ();
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
        return new OutgoingUpdateViewPacketBuilder().setChunkZ(this.chunkZ).setChunkX(this.chunkX);
    }

    @Override
    public ByteBuffer toBytes(Client stream) {
        return SerializerUtils.createPacket(ID, Serializers.VAR_INTEGER.write(this.chunkX),
                Serializers.VAR_INTEGER.write(this.chunkZ));
    }
}
