package org.absorb.world;

import org.absorb.entity.Entity;
import org.absorb.entity.WorldEntity;
import org.absorb.entity.WorldEntityBuilder;
import org.absorb.register.AbsorbKey;
import org.absorb.utils.colllection.ConnectedCollection;
import org.absorb.world.area.AbsorbChunk;
import org.absorb.world.area.AbstractAbsorbChunk;
import org.absorb.world.area.ChunkPart;
import org.absorb.world.location.Location;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector2i;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.LinkedTransferQueue;

public class AbsorbWorld {

    private final AbsorbWorldData worldData;
    private final Vector3i blockMin;
    private final Vector3i blockMax;
    private final LinkedTransferQueue<AbsorbChunk> chunks = new LinkedTransferQueue<>();

    public AbsorbWorld(AbsorbWorldBuilder builder) {
        if (builder.getWorldData() == null) {
            throw new IllegalStateException("No WorldData provided");
        }
        this.worldData = builder.getWorldData();
        this.blockMax = builder.getBlockMax();
        this.blockMin = builder.getBlockMin();
    }

    public Location getLocation(double x, double y, double z) {
        return new Location(this, x, y, z);
    }

    public AbsorbWorldData getWorldData() {
        return this.worldData;
    }

    public WorldEntity spawnEntity(@NotNull Entity entity, @NotNull Vector3d spawnAt) {
        WorldEntity worldEntity = new WorldEntityBuilder()
                .setEntity(entity)
                .setWorld(this)
                .setPosition(spawnAt)
                .setInstanceId(this.getEntities().size() + 1)
                .build();
        AbsorbChunk chunk = this.chunks
                .parallelStream()
                .filter(chunkStream -> chunkStream.getArea().includes(spawnAt))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Chunk has not loaded"));
        ChunkPart part = chunk.getPartWithBlockHeight((int) spawnAt.y());
        part.registerEntity(worldEntity);
        return worldEntity;
    }

    public long getSeed() {
        return this.worldData.getSeed();
    }

    public AbsorbKey getKey() {
        return this.worldData.getKey();
    }

    public Vector3i getMinBlock() {
        return this.blockMin;
    }

    public Vector3i getMaxBlock() {
        return this.blockMax;
    }

    public Collection<AbsorbChunk> getLoadedChunks() {
        return Collections.unmodifiableCollection(this.chunks);
    }

    public Optional<AbsorbChunk> getLoadedChunk(Vector2i position) {
        return this.getLoadedChunk(position.x(), position.y());
    }

    public Optional<AbsorbChunk> getLoadedChunk(int x, int z) {
        return this.chunks
                .stream()
                .filter(chunk -> chunk.getPosition().x() == x)
                .filter(chunk -> chunk.getPosition().y() == z)
                .findAny();
    }

    public Optional<AbsorbChunk> loadGeneratedChunkAtBlock(int x, int z) {
        int chunkX = x >> 4;
        int chunkZ = z >> 4;
        return this.loadGeneratedChunk(chunkX, chunkZ);
    }

    public Optional<AbsorbChunk> loadGeneratedChunk(int x, int z) {
        Optional<AbsorbChunk> opLoaded = this.getLoadedChunk(x, z);
        if (opLoaded.isPresent()) {
            return opLoaded;
        }
        //TODO check loading

        return Optional.empty();
    }

    public AbsorbChunk generateChunkAtBlock(int x, int z) {
        int chunkX = x >> 4;
        int chunkZ = z >> 4;
        return this.generateChunk(chunkX, chunkZ);
    }

    public AbsorbChunk generateChunk(int x, int z) {
        Optional<AbsorbChunk> opChunk = this.loadGeneratedChunk(x, z);
        if (opChunk.isPresent()) {
            return opChunk.get();
        }
        //TODO
        AbsorbChunk chunk = new AbstractAbsorbChunk(this, new Vector2i(x, z));
        this.chunks.add(chunk);
        chunk.generateParts();
        return chunk;
    }

    public int getChunkLevelHeight() {
        int blocks = this.getMaxBlock().y() - this.getMinBlock().y();
        return blocks / ChunkPart.CHUNK_PART_HEIGHT;
    }

    public ConnectedCollection<WorldEntity> getEntities() {
        return new ConnectedCollection<>(this.chunks
                                                 .parallelStream()
                                                 .map(AbsorbChunk::getEntities)
                                                 .toArray(Collection[]::new));
    }

    public AbsorbChunk generateChunk(Vector2i chunkPos) {
        return this.generateChunk(chunkPos.x(), chunkPos.y());
    }
}
