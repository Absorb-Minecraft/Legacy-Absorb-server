package org.absorb.world.location;

import org.absorb.world.AbsorbWorld;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

public class Location {

    private final @NotNull AbsorbWorld world;
    private final @NotNull Vector3d position;

    public Location(@NotNull AbsorbWorld world, @NotNull Vector3d position) {
        this.world = world;
        this.position = position;
    }

    public Location(@NotNull AbsorbWorld world, @NotNull Vector3i position) {
        this(world, position.toDouble());
    }

    public Location(@NotNull AbsorbWorld world, double x, double y, double z) {
        this(world, new Vector3d(x, y, z));
    }

    public Location(@NotNull AbsorbWorld world, int x, int y, int z) {
        this(world, new Vector3d(x, y, z));
    }

    public @NotNull Vector3d getPosition() {
        return this.position;
    }

    public @NotNull Vector3i getBlockPosition() {
        return this.position.toInt();
    }

    public @NotNull AbsorbWorld getWorld() {
        return this.world;
    }

}
