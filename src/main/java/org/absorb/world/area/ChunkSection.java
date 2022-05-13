package org.absorb.world.area;

import org.absorb.block.pallet.BlockPallet;
import org.absorb.block.type.AbsorbBlockTypes;
import org.absorb.net.data.SerializerUtils;
import org.absorb.net.data.Serializers;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ChunkSection {

    private final Set<BlockPallet> blockPallets = new HashSet<>();
    private final Set<BlockPallet> biomePallets = new HashSet<>();
    private final int level;

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


        Set<ByteBuffer> blockBuffers =
                this.blockPallets.stream().map(BlockPallet::write).collect(Collectors.toUnmodifiableSet());
        ByteBuffer blockBuffer = SerializerUtils.collect(blockBuffers);
        Set<ByteBuffer> biomeBuffers =
                this.biomePallets.stream().map(BlockPallet::write).collect(Collectors.toUnmodifiableSet());
        ByteBuffer biomeBuffer = SerializerUtils.collect(biomeBuffers);

        ByteBuffer ret = ByteBuffer.allocate(blockCountBuffer.limit() + blockBuffer.limit() + biomeBuffer.limit());
        ret.put(blockCountBuffer);
        ret.put(blockBuffer);
        ret.put(biomeBuffer);
        return ret;

    }


}
