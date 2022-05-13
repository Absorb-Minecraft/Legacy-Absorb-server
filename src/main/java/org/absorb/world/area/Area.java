package org.absorb.world.area;

import org.absorb.world.AbsorbWorld;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

public class Area {

    private final @NotNull Vector3d min;
    private final @NotNull Vector3d max;
    private final @NotNull AbsorbWorld world;

    public Area(@NotNull Vector3d min, @NotNull Vector3d max, @NotNull AbsorbWorld world) {
        this.max = max;
        this.min = min;
        this.world = world;
    }

    public @NotNull Vector3d getMin() {
        return this.min;
    }

    public @NotNull Vector3d getMax() {
        return this.max;
    }

    public @NotNull AbsorbWorld getWorld() {
        return this.world;
    }

    public boolean includes(@NotNull Vector3i vector3i) {
        return this.includes(vector3i.toDouble());
    }

    public boolean includes(@NotNull Vector3d vector3d) {
        if (this.min.x() > vector3d.x()) {
            return false;
        }
        if (this.min.y() > vector3d.y()) {
            return false;
        }
        if (this.min.z() > vector3d.z()) {
            return false;
        }
        if (this.max.x() < vector3d.x()) {
            return false;
        }
        if (this.max.y() < vector3d.y()) {
            return false;
        }
        return !(this.max.z() < vector3d.z());
    }
}
