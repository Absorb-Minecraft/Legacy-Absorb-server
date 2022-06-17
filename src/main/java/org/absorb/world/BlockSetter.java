package org.absorb.world;

import org.absorb.block.locatable.LocatableBlock;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3i;

import java.util.function.Predicate;

public interface BlockSetter {

    @NotNull Vector3i getHighestPoint(int x, int z, Predicate<LocatableBlock> block);

    void setBlock(@NotNull LocatableBlock block);

    AbsorbWorld getWorld();

    LocatableBlock getBlockAt(int x, int y, int z);
}
