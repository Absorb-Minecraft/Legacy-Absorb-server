package org.absorb.net.packet.play.outgoing.world.chunk.data;

import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.Builder;
import org.absorb.world.area.AbsorbChunk;
import org.absorb.world.area.ChunkPart;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class OutgoingChunkUpdatePacketBuilder implements OutgoingPacketBuilder<OutgoingChunkUpdatePacket> {

    private final Set<ChunkPart> blockData = new HashSet<>();
    private AbsorbChunk chunk;
    private boolean trustLightOnEdge;

    public AbsorbChunk getChunk() {
        return this.chunk;
    }

    public OutgoingChunkUpdatePacketBuilder setChunk(AbsorbChunk chunk) {
        this.chunk = chunk;
        return this;
    }

    public boolean isTrustLightOnEdge() {
        return this.trustLightOnEdge;
    }

    public OutgoingChunkUpdatePacketBuilder setTrustLightOnEdge(boolean trustLightOnEdge) {
        this.trustLightOnEdge = trustLightOnEdge;
        return this;
    }

    public Set<ChunkPart> getParts() {
        return this.blockData;
    }

    public OutgoingChunkUpdatePacketBuilder addParts(Collection<? extends ChunkPart> sections) {
        this.blockData.addAll(sections);
        return this;
    }

    @Override
    public @NotNull OutgoingChunkUpdatePacket build() {
        return new OutgoingChunkUpdatePacket(this);
    }

    @Override
    public @NotNull Builder<OutgoingChunkUpdatePacket> from(OutgoingChunkUpdatePacket value) {
        this.blockData.addAll(value.getParts());
        this.chunk = value.getChunk();
        this.trustLightOnEdge = value.isTrustLightOnEdge();
        return this;
    }

    @Override
    public @NotNull OutgoingChunkUpdatePacketBuilder reset() {
        this.blockData.clear();
        this.chunk = null;
        this.trustLightOnEdge = false;
        return this;
    }

    @Override
    public @NotNull OutgoingChunkUpdatePacketBuilder copy() {
        return new OutgoingChunkUpdatePacketBuilder()
                .setChunk(this.chunk)
                .setTrustLightOnEdge(this.trustLightOnEdge)
                .addParts(this.getParts());
    }

    @Override
    public int getId() {
        return OutgoingChunkUpdatePacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
