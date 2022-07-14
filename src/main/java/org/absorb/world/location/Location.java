package org.absorb.world.location;

import org.absorb.world.World;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector2i;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

public class Location implements Comparable<Location> {

    private final @NotNull World world;
    private final @NotNull Vector3d position;

    public Location(@NotNull World world, @NotNull Vector3d position) {
        this.world = world;
        this.position = position;
    }

    public Location(@NotNull World world, @NotNull Vector3i position) {
        this(world, position.toDouble());
    }

    public Location(@NotNull World world, double x, double y, double z) {
        this(world, new Vector3d(x, y, z));
    }

    public Location(@NotNull World world, int x, int y, int z) {
        this(world, new Vector3d(x, y, z));
    }

    public @NotNull Vector3d getPosition() {
        return this.position;
    }

    public @NotNull Vector3i getBlockPosition() {
        return this.position.toInt();
    }

    public @NotNull World getWorld() {
        return this.world;
    }

    public @NotNull Vector2i getChunkPosition() {
        return new Vector2i(this.position.floorX() >> 4, this.position.floorZ() >> 4);
    }

    @Override
    public int compareTo(@NotNull Location o) {
        if (this.getBlockPosition().y() > o.getBlockPosition().y()) {
            return 1;
        }
        if (this.getBlockPosition().y() < o.getBlockPosition().y()) {
            return -1;
        }
        if (this.getBlockPosition().z() > o.getBlockPosition().z()) {
            return 1;
        }
        if (this.getBlockPosition().z() < o.getBlockPosition().z()) {
            return -1;
        }
        return Integer.compare(this.getBlockPosition().x(), o.getBlockPosition().x());
    }
}
