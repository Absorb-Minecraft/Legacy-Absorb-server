package org.absorb.entity;

import org.absorb.world.AbsorbWorld;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.math.vector.Vector3d;

import java.util.Optional;

public class WorldEntity {

    private @NotNull Entity entity;
    private @Nullable Vector3d fellFrom;
    private @Nullable Vector3d landedOn;
    private @NotNull Vector3d position;
    private @NotNull AbsorbWorld world;
    private int instanceId;

    public WorldEntity(WorldEntityBuilder builder) {
        this.entity = builder.getEntity();
        this.fellFrom = builder.getFellFrom();
        this.landedOn = builder.getLandedOn();
        this.position = builder.getPosition();
        this.world = builder.getWorld();
        this.instanceId = builder.getInstanceId();
    }

    public int getInstanceId() {
        return this.instanceId;
    }

    public @NotNull Entity getEntity() {
        return this.entity;
    }

    public @NotNull Optional<Vector3d> getFellFrom() {
        return Optional.ofNullable(this.fellFrom);
    }

    public Optional<Vector3d> getLandedOn() {
        return Optional.ofNullable(this.landedOn);
    }

    public @NotNull Vector3d getPosition() {
        return this.position;
    }

    public void setPosition(@NotNull Vector3d position) {
        this.position = position;
    }

    public @NotNull AbsorbWorld getWorld() {
        return this.world;
    }
}
