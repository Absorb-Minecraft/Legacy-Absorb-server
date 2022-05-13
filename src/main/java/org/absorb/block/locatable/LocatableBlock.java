package org.absorb.block.locatable;

import org.absorb.block.state.FullBlockState;
import org.absorb.world.location.Locatable;
import org.absorb.world.location.Location;
import org.jetbrains.annotations.NotNull;

public class LocatableBlock implements Locatable {

    private final @NotNull FullBlockState state;
    private final @NotNull Location location;

    public LocatableBlock(@NotNull FullBlockState state, @NotNull Location location) {
        this.location = location;
        this.state = state;
    }

    public @NotNull FullBlockState getState() {
        return this.state;
    }

    @Override
    public @NotNull Location getLocation() {
        return this.location;
    }
}
