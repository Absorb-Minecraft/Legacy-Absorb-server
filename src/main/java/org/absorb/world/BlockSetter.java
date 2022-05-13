package org.absorb.world;

import org.absorb.block.locatable.LocatableBlock;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3i;

public interface BlockSetter {

    @NotNull Vector3i getHighestPoint(int x, int z);
    void setBlock(@NotNull LocatableBlock block);
    AbsorbWorld getWorld();
    LocatableBlock getBlockAt(int x, int y, int z);
}
