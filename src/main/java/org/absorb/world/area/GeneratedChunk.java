package org.absorb.world.area;

import org.absorb.block.locatable.LocatableBlock;
import org.absorb.world.World;
import org.jetbrains.annotations.NotNull;

public interface GeneratedChunk {

    @NotNull
    LocatableBlock getBlock(int x, int y, int z, @NotNull World world);
}
