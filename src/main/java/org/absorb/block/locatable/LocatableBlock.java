package org.absorb.block.locatable;

import org.absorb.world.location.Locatable;
import org.absorb.world.location.Location;
import org.jetbrains.annotations.NotNull;

public class LocatableBlock implements Locatable, Comparable<LocatableBlock> {

    private final @NotNull BlockData state;
    private final @NotNull Location location;

    public LocatableBlock(@NotNull BlockData state, @NotNull Location location) {
        this.location = location;
        this.state = state;
    }

    public @NotNull BlockData getState() {
        return this.state;
    }

    @Override
    public @NotNull Location getLocation() {
        return this.location;
    }

    @Override
    public int compareTo(@NotNull LocatableBlock o) {
        return this.location.compareTo(o.location);
    }
}
