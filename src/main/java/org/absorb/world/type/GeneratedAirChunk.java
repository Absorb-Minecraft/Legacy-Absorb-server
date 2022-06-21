package org.absorb.world.type;

import org.absorb.block.locatable.LocatableBlock;
import org.absorb.block.type.AbsorbBlockTypes;
import org.absorb.world.AbsorbWorld;
import org.absorb.world.area.GeneratedChunk;
import org.jetbrains.annotations.NotNull;

public class GeneratedAirChunk implements GeneratedChunk {
    @Override
    public @NotNull LocatableBlock getBlock(int x, int y, int z, @NotNull AbsorbWorld world) {
        return new LocatableBlock(AbsorbBlockTypes.AIR.get().getDefaultBlockState().asFull(), world.getLocation(x, y,
                z));
    }
}
