package org.absorb.world.area;

import org.absorb.block.locatable.LocatableBlock;
import org.absorb.block.type.properties.mass.MassType;
import org.absorb.entity.WorldEntity;
import org.absorb.utils.colllection.ConnectedCollection;
import org.absorb.world.AbsorbWorld;
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

    default byte[] getHeightMap() {
        byte[] heightmaps = new byte[ChunkPart.CHUNK_WIDTH * ChunkPart.CHUNK_LENGTH];
        for (int x = 0; x < ChunkPart.CHUNK_WIDTH; x++) {
            for (int z = 0; z < ChunkPart.CHUNK_LENGTH; z++) {
                int index = z + (x * ChunkPart.CHUNK_WIDTH);
                heightmaps[index] = (byte) this.getHighestPoint(x, z,
                        (loc) -> loc.getState().getState().getType().getMassType()==MassType.SOLID).y();
            }
        }
        return heightmaps;

        //long sendingY = (long) Math.ceil(StrictMath.log(maxY + 1) / StrictMath.log(2));

    }

    @NotNull AbsorbWorld getWorld();

    @NotNull Area getArea();

    default @NotNull ChunkPart getPartWithLevel(int level) {
        return this.getParts().stream().filter(part -> part.getLevel()==level).findAny().orElseGet(() -> this.generatePartWithLevel(level));
    }

    default @NotNull ChunkPart getPartWithBlockHeight(int height) {
        return this.getParts().stream().filter(part -> part.getMinimumBlockHeight() <= height).filter(part -> part.getMaximumBlockHeight() > height).findAny().orElseGet(() -> this.generatePartWithHeight(height));
    }

    default ConnectedCollection<WorldEntity> getEntities() {
        return new ConnectedCollection<>(this.getParts().parallelStream().map(ChunkPart::getEntities).toArray(Collection[]::new));
    }
}
