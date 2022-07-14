package org.absorb.world.location;

import org.absorb.world.World;
import org.jetbrains.annotations.NotNull;

public interface Locatable {

    @NotNull
    Location getLocation();

    default @NotNull World getWorld() {
        return this.getLocation().getWorld();
    }
}
