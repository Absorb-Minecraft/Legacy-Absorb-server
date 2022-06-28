package org.absorb.net.packet.play.outgoing.world.chunk.position;

import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.world.area.AbsorbChunk;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector2i;

public class OutgoingUpdateViewPacketBuilder implements OutgoingPacketBuilder<OutgoingUpdateViewPacket> {

    private int chunkX;
    private int chunkZ;

    public OutgoingUpdateViewPacketBuilder setChunk(AbsorbChunk chunk) {
        return this.setChunk(chunk.getPosition());
    }

    public OutgoingUpdateViewPacketBuilder setChunk(Vector2i position) {
        this.chunkZ = position.y();
        this.chunkX = position.x();
        return this;
    }

    public int getChunkX() {
        return this.chunkX;
    }

    public OutgoingUpdateViewPacketBuilder setChunkX(int chunkX) {
        this.chunkX = chunkX;
        return this;
    }

    public int getChunkZ() {
        return this.chunkZ;
    }

    public OutgoingUpdateViewPacketBuilder setChunkZ(int chunkZ) {
        this.chunkZ = chunkZ;
        return this;
    }

    @Override
    public @NotNull OutgoingUpdateViewPacket build() {
        return new OutgoingUpdateViewPacket(this);
    }

    @Override
    public PacketBuilder<OutgoingUpdateViewPacket> reset() {
        this.chunkX = 0;
        this.chunkZ = 0;
        return this;
    }

    @Override
    public PacketBuilder<OutgoingUpdateViewPacket> copy() {
        return new OutgoingUpdateViewPacketBuilder().setChunkX(this.chunkX).setChunkZ(this.chunkZ);
    }

    @Override
    public int getId() {
        return OutgoingUpdateViewPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
