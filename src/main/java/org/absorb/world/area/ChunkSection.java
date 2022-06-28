package org.absorb.world.area;

import org.absorb.block.locatable.BlockData;
import org.absorb.block.pallet.BlockPallet;
import org.absorb.block.pallet.SinglePallet;
import org.absorb.block.type.BlockTypes;
import org.absorb.net.data.NetUtils;
import org.absorb.net.data.NetSerializers;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3i;

import java.nio.ByteBuffer;
import java.util.*;
import java.util.concurrent.LinkedTransferQueue;
import java.util.stream.Collectors;

public class ChunkSection {

    private final Collection<BlockPallet> blockPallets = new LinkedTransferQueue<>();
    private final Collection<BlockPallet> biomePallets = new LinkedTransferQueue<>();
    private final int level;

    private static final int BLOCK_STATES_LIMIT = 4096;
    private static final int BIOME_STATES_LIMIT = 64;

    public ChunkSection(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public void addBlockPallet(@NotNull BlockPallet pallet) {
        try {
            this.blockPallets.add(pallet);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void addBiomePallet(@NotNull BlockPallet pallet) {
        this.biomePallets.add(pallet);
    }

    public Collection<BlockPallet> getBlockPallet() {
        return Collections.unmodifiableCollection(this.biomePallets);
    }

    public Collection<BlockPallet> getBiomePallet() {
        return Collections.unmodifiableCollection(this.biomePallets);
    }

    public ByteBuffer write() {
        Collection<BlockData> blocks = this
                .blockPallets
                .stream()
                .flatMap(blockPallet -> blockPallet.getBlocks().values().parallelStream())
                .filter(entry -> !BlockTypes.AIR.isEqual(entry.getState().getType()))
                .filter(entry -> !BlockTypes.CAVE_AIR.isEqual(entry.getState().getType()))
                .filter(entry -> !BlockTypes.VOID_AIR.isEqual(entry.getState().getType()))
                .collect(Collectors.toList());

        System.out.println("Writing Chunk Section");
        short blockCount =
                (short) blocks.size();
        ByteBuffer blockCountBuffer = NetSerializers.SHORT.write(blockCount);
        System.out.println("\tBlockCount: " + blockCount + " " + Arrays.toString(blockCountBuffer.array()));
        List<ByteBuffer> blockBuffers =
                this
                        .blockPallets
                        .stream()
                        .sorted((o1, o2) -> o1.compareOnBlockLocation().compare(o1, o2))
                        .map(BlockPallet::write)
                        .collect(Collectors.toCollection(LinkedList::new));
        if (blockBuffers.size()!=BLOCK_STATES_LIMIT) {
            int sizeBefore = blockBuffers.size();
            if (sizeBefore > BLOCK_STATES_LIMIT) {
                throw new RuntimeException("Blocks exceeded maximum per chunk: Max: " + BLOCK_STATES_LIMIT + " " +
                        "Currently: " + sizeBefore);
            }
            for (int i = 0; i < (BLOCK_STATES_LIMIT - sizeBefore); i++) {
                blockBuffers.add(
                        new SinglePallet(
                                BlockTypes.AIR.get().getDefaultBlockState().asBlockData(),
                                new Vector3i(i, i, i)
                        ).write());
            }
        }
        ByteBuffer blockBuffer = NetUtils.collect(blockBuffers);
        System.out.println("\tOriginalBuffer: " + blockBuffers.stream().map(byteBuffer -> Arrays.toString(byteBuffer.array())).collect(Collectors.joining("")));
        System.out.println("\tBlockBuffer: (" + blockBuffers.size() + ") " + Arrays.toString(blockBuffer.array()));
        List<ByteBuffer> biomeBuffers =
                this.biomePallets.stream().map(BlockPallet::write).collect(Collectors.toCollection(LinkedList::new));
        if (biomeBuffers.size()!=BIOME_STATES_LIMIT) {
            int sizeBefore = biomeBuffers.size();
            if (sizeBefore > BIOME_STATES_LIMIT) {
                throw new RuntimeException("Biome blocks exceeded maximum per chunk: Max: " + BIOME_STATES_LIMIT + " " +
                        "Currently: " + sizeBefore);
            }
            for (int i = 0; i < (BIOME_STATES_LIMIT - sizeBefore); i++) {
                biomeBuffers.add(
                        new SinglePallet(
                                BlockTypes.AIR.get().getDefaultBlockState().asBlockData(),
                                new Vector3i(i, i, i)).write());
            }
        }

        ByteBuffer biomeBuffer = NetUtils.collect(biomeBuffers);
        System.out.println("\tBiomeBuffer: (" + biomeBuffers.size() + ")" + Arrays.toString(biomeBuffer.array()));


        ByteBuffer ret = ByteBuffer.allocate(blockCountBuffer.limit() + blockBuffer.limit() + biomeBuffer.limit());
        ret.put(blockCountBuffer.array());
        ret.put(blockBuffer.array());
        ret.put(biomeBuffer.array());
        return ret;

    }


}
