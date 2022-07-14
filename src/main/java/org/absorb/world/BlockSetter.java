package org.absorb.world;

import org.absorb.block.locatable.LocatableBlock;
import org.absorb.entity.WorldEntity;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3i;

import java.util.Collection;
import java.util.function.Predicate;

public interface BlockSetter {

    @NotNull Vector3i getHighestPoint(int x, int z, Predicate<LocatableBlock> block);

    void setBlock(@NotNull LocatableBlock block);

    World getWorld();

    LocatableBlock getBlockAt(int x, int y, int z);

    Collection<WorldEntity> getEntities();

    Vector3i getMaxBlock();

    Vector3i getMinBlock();
}
