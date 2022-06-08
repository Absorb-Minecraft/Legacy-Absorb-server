package org.absorb.world.area;

import org.absorb.block.BlockTags;
import org.absorb.block.locatable.LocatableBlock;
import org.absorb.block.pallet.SinglePallet;
import org.absorb.entity.WorldEntity;
import org.absorb.world.AbsorbWorld;
import org.absorb.world.BlockSetter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.math.vector.Vector3i;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

public class ChunkPart implements BlockSetter {

    public static final int CHUNK_PART_HEIGHT = 16;
    public static final int CHUNK_WIDTH = 16;
    public static final int CHUNK_LENGTH = 16;

    private final int level;
    private final AbsorbChunk chunk;
    private @Nullable GeneratedChunk generated;
    private final Queue<LocatableBlock> changedBlock = new LinkedTransferQueue<>();
    private final Queue<WorldEntity> entities = new LinkedTransferQueue<>();

    public ChunkPart(@NotNull AbsorbChunk chunk, int level) {
        this.chunk = chunk;
        this.level = level;
    }

    public boolean isEmpty(){
        return this.generated == null;
    }

    public void registerEntity(WorldEntity entity) {
        this.entities.offer(entity);
    }

    public Collection<WorldEntity> getEntities() {
        return Collections.unmodifiableCollection(this.entities);
    }

    private Optional<LocatableBlock> getChangedAt(int x, int y, int z) {
        return this.changedBlock.stream().filter(b -> b.getLocation().getBlockPosition().x()==x).filter(b -> b.getLocation().getBlockPosition().y()==y).filter(b -> b.getLocation().getBlockPosition().z()==z).findAny();
    }

    @Override
    public LocatableBlock getBlockAt(int x, int y, int z) {
        Optional<LocatableBlock> opBlock = this.getChangedAt(x, y, z);
        if (opBlock.isPresent()) {
            return opBlock.get();
        }
        if (this.generated==null) {
            System.err.println("Chunk has not generated part yet was being requested for BlockAt(" + x + ", " + y +
                    ", " + z + "). Please check the timing of your code");
            this.chunk.generatePartWithLevel(this.level);
        }
        while (this.generated==null) {

        }
        return this.generated.getBlock(x, y, z, this.chunk.getWorld());
    }

    public AbsorbChunk getChunk() {
        return this.chunk;
    }

    void setGeneratedChunk(@NotNull GeneratedChunk chunk) {
        this.generated = chunk;
    }

    public Long[] getHeightMap() {
        ArrayBlockingQueue<Long> queue = new ArrayBlockingQueue<>(256);
        LinkedBlockingQueue<Thread> threads = new LinkedBlockingQueue<>();

        for (int x = 0; x < CHUNK_WIDTH; x++) {
            for (int z = 0; z < CHUNK_LENGTH; z++) {
                final int finalX = x;
                final int finalZ = z;
                Thread thread = new Thread(() -> {
                    queue.add((long) 1);
                    //queue.add((long) this.getHighestPoint(finalX, finalZ).y());
                });
                threads.add(thread);
                thread.start();
            }
        }
        boolean await = true;
        while (await) {
            await = threads.parallelStream().anyMatch(Thread::isAlive);
        }
        return queue.toArray(Long[]::new);
    }

    @Override
    public @NotNull Vector3i getHighestPoint(int x, int z) {
        int height = 0;
        int min = this.getMinimumBlockHeight();
        for (int i = 0; i < CHUNK_PART_HEIGHT; i++) {
            LocatableBlock block = this.getBlockAt(x, i + min, z);
            if (BlockTags.AIR.contains(block.getState().getState().getType())) {
                continue;
            }
            height = i + min;
        }
        return new Vector3i(x, height, z);
    }

    @Override
    public void setBlock(@NotNull LocatableBlock block) {
        this.changedBlock.offer(block);
    }

    @Override
    public AbsorbWorld getWorld() {
        return this.chunk.getWorld();
    }

    public Collection<LocatableBlock> getAppliedChanges() {
        return Collections.unmodifiableCollection(this.changedBlock);
    }

    public Optional<GeneratedChunk> getGeneratedChunk() {
        return Optional.ofNullable(this.generated);
    }

    public int getMinimumBlockHeight() {
        return this.level * CHUNK_PART_HEIGHT;
    }

    public int getMaximumBlockHeight() {
        return this.getMinimumBlockHeight() + (CHUNK_PART_HEIGHT - 1);
    }

    public int getLevel() {
        return this.level;
    }

    public ChunkSection asSection() {
        ChunkSection section = new ChunkSection(this.level);
        for (int x = 0; x < CHUNK_WIDTH; x++) {
            for (int y = 0; y < CHUNK_PART_HEIGHT; y++) {
                for (int z = 0; z < CHUNK_LENGTH; z++) {
                    final int finalX = x;
                    final int finalY = y;
                    final int finalZ = z;
                    new Thread(() -> section.addBlockPallet(new SinglePallet(this.getBlockAt(finalX, finalY, finalZ).getState()))).start();
                }
            }
        }
        return section;
    }
}
