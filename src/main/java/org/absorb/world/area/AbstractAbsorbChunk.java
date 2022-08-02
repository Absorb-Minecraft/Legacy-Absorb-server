package org.absorb.world.area;

import org.absorb.block.locatable.LocatableBlock;
import org.absorb.world.World;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector2i;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Predicate;

public class AbstractAbsorbChunk implements AbsorbChunk {

    private final @NotNull Vector2i position;
    private final @NotNull SortedSet<ChunkPart> parts = new TreeSet<>(Comparator.comparing(ChunkPart::getLevel));
    private final @NotNull World world;

    public AbstractAbsorbChunk(@NotNull World world, @NotNull Vector2i position) {
        this.position = position;
        this.world = world;
    }

    @Override
    public @NotNull Vector2i getPosition() {
        return this.position;
    }

    @Override
    public @NotNull SortedSet<ChunkPart> getParts() {
        return this.parts;
    }

    @Override
    public ChunkPart generatePartWithLevel(int level) {
        ChunkPart part = new ChunkPart(this, level);
        this.parts.add(part);
        new Thread(() -> part.setGeneratedChunk(this.world.getWorldData().getType().generateChunk(part))).start();
        return part;
    }

    @Override
    public ChunkPart generatePartWithHeight(int height) {
        int level = (this.world.getMaxBlock().y() - height) / ChunkPart.CHUNK_PART_HEIGHT;
        return this.generatePartWithLevel(level);
    }

    @Override
    public @NotNull Vector3i getHighestPoint(int x, int z, Predicate<LocatableBlock> check) {
        int y = this.parts.stream().mapToInt(part -> part.getHighestPoint(x, z, check).y()).max().orElse(0);
        return new Vector3i(x, y, z);
    }

    @Override
    public @NotNull World getWorld() {
        return this.world;
    }

    @Override
    public @NotNull Area getArea() {
        int minX = this.position.x() << 4;
        int minZ = this.position.y() << 4;
        int minY = this.world.getMinBlock().y();

        int maxX = minX + ChunkPart.CHUNK_WIDTH;
        int maxZ = minZ + ChunkPart.CHUNK_LENGTH;
        int maxY = this.world.getMaxBlock().y();

        return new Area(new Vector3d(minX, minY, minZ), new Vector3d(maxX, maxY, maxZ), this.world);
    }
}
