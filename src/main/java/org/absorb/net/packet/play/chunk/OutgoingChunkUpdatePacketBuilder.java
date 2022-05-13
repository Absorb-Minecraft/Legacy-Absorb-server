package org.absorb.net.packet.play.chunk;

import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.world.area.ChunkPart;
import org.absorb.world.area.ChunkSection;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class OutgoingChunkUpdatePacketBuilder implements OutgoingPacketBuilder<OutgoingChunkUpdatePacket> {

    private ChunkPart chunk;
    private boolean trustLightOnEdge;
    private final Set<ChunkSection> blockData = new HashSet<>();

    public ChunkPart getChunkPart() {
        return this.chunk;
    }

    public OutgoingChunkUpdatePacketBuilder setChunkPart(ChunkPart chunk) {
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

    public Set<ChunkSection> getChunkSections() {
        return this.blockData;
    }

    public OutgoingChunkUpdatePacketBuilder addChunkSections(Collection<? extends ChunkSection> sections) {
        this.blockData.addAll(sections);
        return this;
    }

    @Override
    public @NotNull OutgoingChunkUpdatePacket build() {
        return new OutgoingChunkUpdatePacket(this);
    }

    @Override
    public @NotNull OutgoingChunkUpdatePacketBuilder copy() {
        return new OutgoingChunkUpdatePacketBuilder().setChunkPart(this.chunk).setTrustLightOnEdge(this.trustLightOnEdge).addChunkSections(this.getChunkSections());
    }

    @Override
    public @NotNull OutgoingChunkUpdatePacketBuilder reset() {
        this.blockData.clear();
        this.chunk = null;
        this.trustLightOnEdge = false;
        return this;
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
