package org.absorb.world.type.flat;

import org.absorb.block.locatable.LocatableBlock;
import org.absorb.block.state.FullBlockState;
import org.absorb.block.type.AbsorbBlockTypes;
import org.absorb.world.AbsorbWorld;
import org.absorb.world.area.GeneratedChunk;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class GeneratedFlatChunk implements GeneratedChunk {

    private final Map<Integer, FullBlockState> generateAt = new HashMap<>();

    public GeneratedFlatChunk() {
        this.generateAt.put(1, AbsorbBlockTypes.BEDROCK.get().getDefaultBlockState().asFull());
    }

    @Override
    public @NotNull LocatableBlock getBlock(int x, int y, int z, @NotNull AbsorbWorld world) {
        FullBlockState state = this.generateAt.get(y);
        if (state==null) {
            state = AbsorbBlockTypes.AIR.get().getDefaultBlockState().asFull();
        }
        return new LocatableBlock(state, world.getLocation(x, y, z));
    }
}
