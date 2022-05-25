package org.absorb.world.area;

import org.absorb.block.pallet.BlockPallet;
import org.absorb.block.pallet.SinglePallet;
import org.absorb.block.state.AbsorbBlockStateBuilder;
import org.absorb.block.state.FullBlockState;
import org.absorb.block.type.AbsorbBlockTypes;
import org.absorb.net.data.SerializerUtils;
import org.absorb.net.data.Serializers;

import java.nio.ByteBuffer;
import java.util.*;
import java.util.stream.Collectors;

public class ChunkSection {

    private final Set<BlockPallet> blockPallets = new HashSet<>();
    private final Set<BlockPallet> biomePallets = new HashSet<>();
    private final int level;

    private static final int BLOCK_STATES_LIMIT = 4096;
    private static final int BIOME_STATES_LIMIT = 64;

    public ChunkSection(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public void addBlockPallet(BlockPallet pallet) {
        blockPallets.add(pallet);
    }

    public void addBiomePallet(BlockPallet pallet) {
        biomePallets.add(pallet);
    }

    public Collection<BlockPallet> getBlockPallet() {
        return Collections.unmodifiableCollection(this.biomePallets);
    }

    public Collection<BlockPallet> getBiomePallet() {
        return Collections.unmodifiableCollection(this.biomePallets);
    }

    public ByteBuffer write() {
        System.out.println("Writing Chunk Section");
        short blockCount =
                (short) this
                        .blockPallets
                        .stream()
                        .flatMap(blockPallet -> blockPallet.getBlocks().parallelStream())
                        .filter(state -> !AbsorbBlockTypes.AIR.isEqual(state.getState().getType()))
                        .filter(state -> !AbsorbBlockTypes.CAVE_AIR.isEqual(state.getState().getType()))
                        .filter(state -> !AbsorbBlockTypes.VOID_AIR.isEqual(state.getState().getType()))
                        .count();
        ByteBuffer blockCountBuffer = Serializers.SHORT.write(blockCount);
        System.out.println("\tBlockCount: " + blockCount + " " + Arrays.toString(blockCountBuffer.array()));


        List<ByteBuffer> blockBuffers =
                this.blockPallets.stream().map(BlockPallet::write).collect(Collectors.toCollection(LinkedList::new));
        if(blockBuffers.size() != BLOCK_STATES_LIMIT){
            int sizeBefore = blockBuffers.size();
            if(sizeBefore > BLOCK_STATES_LIMIT){
                throw new RuntimeException("Blocks exceeded maximum per chunk: Max: " + BLOCK_STATES_LIMIT + " " +
                        "Currently: " + sizeBefore);
            }
            for(int i = 0; i < (BLOCK_STATES_LIMIT - sizeBefore); i++){
                blockBuffers.add(new SinglePallet(AbsorbBlockTypes.AIR.get().getDefaultBlockState().asFull()).write());
            }
        }
        ByteBuffer blockBuffer = SerializerUtils.collect(blockBuffers);
        System.out.println("\tBlockBuffer: (" + blockBuffers.size() + ") " + Arrays.toString(blockBuffer.array()));
        List<ByteBuffer> biomeBuffers =
                this.biomePallets.stream().map(BlockPallet::write).collect(Collectors.toCollection(LinkedList::new));
        if(biomeBuffers.size() != BIOME_STATES_LIMIT){
            int sizeBefore = biomeBuffers.size();
            if(sizeBefore > BIOME_STATES_LIMIT){
                throw new RuntimeException("Biome blocks exceeded maximum per chunk: Max: " + BIOME_STATES_LIMIT + " " +
                        "Currently: " + sizeBefore);
            }
            for(int i = 0; i < (BIOME_STATES_LIMIT - sizeBefore); i++){
                biomeBuffers.add(new SinglePallet(AbsorbBlockTypes.AIR.get().getDefaultBlockState().asFull()).write());
            }
        }

        ByteBuffer biomeBuffer = SerializerUtils.collect(biomeBuffers);
        System.out.println("\tBiomeBuffer: (" + biomeBuffers.size() + ")" + Arrays.toString(biomeBuffer.array()));


        ByteBuffer ret = ByteBuffer.allocate(blockCountBuffer.limit() + blockBuffer.limit() + biomeBuffer.limit());
        ret.put(blockCountBuffer.array());
        ret.put(blockBuffer.array());
        ret.put(biomeBuffer.array());
        return ret;

    }


}
