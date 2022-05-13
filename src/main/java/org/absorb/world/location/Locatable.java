package org.absorb.world.location;

import org.absorb.world.AbsorbWorld;
import org.jetbrains.annotations.NotNull;

public interface Locatable {

    @NotNull Location getLocation();

    default @NotNull AbsorbWorld getWorld() {
        return this.getLocation().getWorld();
    }
}
