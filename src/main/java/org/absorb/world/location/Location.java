package org.absorb.world.location;

import org.absorb.world.AbsorbWorld;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

public class Location implements Comparable<Location>{

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

    @Override
    public int compareTo(@NotNull Location o) {
        if(this.getBlockPosition().y() > o.getBlockPosition().y()){
            return 1;
        }
        if(this.getBlockPosition().y() < o.getBlockPosition().y()){
            return -1;
        }
        if(this.getBlockPosition().z() > o.getBlockPosition().z()){
            return 1;
        }
        if(this.getBlockPosition().z() < o.getBlockPosition().z()){
            return -1;
        }
        if(this.getBlockPosition().x() > o.getBlockPosition().x()){
            return 1;
        }
        if(this.getBlockPosition().x() < o.getBlockPosition().x()){
            return -1;
        }
        return 0;
    }
}
