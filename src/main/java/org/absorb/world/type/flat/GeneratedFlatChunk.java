package org.absorb.world.type.flat;

import org.absorb.block.locatable.BlockData;
import org.absorb.block.locatable.LocatableBlock;
import org.absorb.block.type.BlockTypes;
import org.absorb.world.AbsorbWorld;
import org.absorb.world.area.GeneratedChunk;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class GeneratedFlatChunk implements GeneratedChunk {

    private final Map<Integer, BlockData> generateAt = new HashMap<>();

    public GeneratedFlatChunk() {
        this.generateAt.put(1, BlockTypes.BEDROCK.get().getDefaultBlockState().asBlockData());
    }

    @Override
    public @NotNull LocatableBlock getBlock(int x, int y, int z, @NotNull AbsorbWorld world) {
        BlockData state = this.generateAt.get(y);
        if (state==null) {
            state = BlockTypes.AIR.get().getDefaultBlockState().asBlockData();
        }
        return new LocatableBlock(state, world.getLocation(x, y, z));
    }
}
