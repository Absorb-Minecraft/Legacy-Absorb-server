package org.absorb.block;

import org.absorb.register.AbsorbKey;
import org.spongepowered.math.vector.Vector3d;

public class AbsorbLocation {

    private final Vector3d location;
    private final AbsorbKey world;

    public AbsorbLocation(AbsorbKey world, Vector3d location) {
        this.location = location;
        this.world = world;
    }

    public AbsorbKey getWorldKey() {
        return this.world;
    }

    public Vector3d getPosition() {
        return this.location;
    }
}
