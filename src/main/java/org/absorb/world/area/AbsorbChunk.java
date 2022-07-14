package org.absorb.world.area;

import me.nullicorn.nedit.type.NBTCompound;
import org.absorb.block.locatable.LocatableBlock;
import org.absorb.entity.WorldEntity;
import org.absorb.files.nbt.compound.NBTCompoundBuilder;
import org.absorb.files.nbt.compound.NBTCompoundKeys;
import org.absorb.net.data.NetUtils;
import org.absorb.utils.colllection.ConnectedCollection;
import org.absorb.world.World;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector2i;
import org.spongepowered.math.vector.Vector3i;

import java.util.Collection;
import java.util.SortedSet;
import java.util.function.Predicate;

public interface AbsorbChunk {

    @NotNull Vector2i getPosition();

    @NotNull SortedSet<ChunkPart> getParts();

    ChunkPart generatePartWithLevel(int level);

    ChunkPart generatePartWithHeight(int height);

    default void generateParts() {
        for (int i = 0; i < this.getWorld().getChunkLevelHeight(); i++) {
            this.generatePartWithLevel(i);
        }
    }

    @NotNull Vector3i getHighestPoint(int x, int z, Predicate<LocatableBlock> block);

    default NBTCompound getHeightMap() {
        //TODO -> not hard code

        int worldHeight = this.getWorld().getWorldData().getType().getMaximumHeight();
        int[] motionBlocking = new int[ChunkPart.CHUNK_WIDTH * ChunkPart.CHUNK_LENGTH];
        int[] worldSurface = new int[ChunkPart.CHUNK_WIDTH * ChunkPart.CHUNK_LENGTH];
        for (int x = 0; x < ChunkPart.CHUNK_WIDTH; x++) {
            for (int z = 0; z < ChunkPart.CHUNK_LENGTH; z++) {
                motionBlocking[x + z * 16] = 0;
                worldSurface[x + z * 16] = worldHeight - 1;
            }
        }

        final int bitsForHeight = Integer.SIZE - Integer.numberOfLeadingZeros(worldHeight);

        Long[] encodedMotionBlocking = NetUtils.encodeBlocks(motionBlocking, bitsForHeight);
        Long[] encodedWorldSurface = NetUtils.encodeBlocks(worldSurface, bitsForHeight);

        return new NBTCompoundBuilder()
                .add(NBTCompoundKeys.MOTION_BLOCKING.withValue(encodedMotionBlocking))
                .add(NBTCompoundKeys.WORLD_SURFACE.withValue(encodedWorldSurface))
                .build();
    }

    @NotNull World getWorld();

    @NotNull Area getArea();

    default @NotNull ChunkPart getPartWithLevel(int level) {
        return this
                .getParts()
                .stream()
                .filter(part -> part.getLevel() == level)
                .findAny()
                .orElseGet(() -> this.generatePartWithLevel(level));
    }

    default @NotNull ChunkPart getPartWithBlockHeight(int height) {
        return this
                .getParts()
                .stream()
                .filter(part -> part.getMinimumBlockHeight() <= height)
                .filter(part -> part.getMaximumBlockHeight() > height)
                .findAny()
                .orElseGet(() -> this.generatePartWithHeight(height));
    }

    default ConnectedCollection<WorldEntity> getEntities() {
        return new ConnectedCollection<>(this
                                                 .getParts()
                                                 .parallelStream()
                                                 .map(ChunkPart::getEntities)
                                                 .toArray(Collection[]::new));
    }
}
