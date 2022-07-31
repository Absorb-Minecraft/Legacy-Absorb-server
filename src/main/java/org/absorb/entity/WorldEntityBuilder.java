package org.absorb.entity;

import org.absorb.AbsorbManagers;
import org.absorb.utils.Builder;
import org.absorb.utils.colllection.ConnectedCollection;
import org.absorb.world.World;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3d;

public class WorldEntityBuilder implements Builder<WorldEntity> {

    private Entity entity;
    private Vector3d fellFrom;
    private Vector3d landedOn;
    private Vector3d position;
    private World world;
    private Integer instanceId;

    public int getInstanceId() {
        if (this.instanceId == null) {
            return new ConnectedCollection<>(AbsorbManagers
                                                     .getWorldManager()
                                                     .worlds()
                                                     .parallelStream()
                                                     .flatMap(w -> w.getEntities().parallelStream())
                                                     .toList()).size();
        }
        return this.instanceId;
    }

    public WorldEntityBuilder setInstanceId(int instanceId) {
        this.instanceId = instanceId;
        return this;
    }

    public Entity getEntity() {
        return this.entity;
    }

    public WorldEntityBuilder setEntity(Entity entity) {
        this.entity = entity;
        return this;
    }

    public Vector3d getFellFrom() {
        return this.fellFrom;
    }

    public WorldEntityBuilder setFellFrom(Vector3d fellFrom) {
        this.fellFrom = fellFrom;
        return this;
    }

    public Vector3d getLandedOn() {
        return this.landedOn;
    }

    public WorldEntityBuilder setLandedOn(Vector3d landedOn) {
        this.landedOn = landedOn;
        return this;
    }

    public Vector3d getPosition() {
        return this.position;
    }

    public WorldEntityBuilder setPosition(Vector3d position) {
        this.position = position;
        return this;
    }

    public World getWorld() {
        return this.world;
    }

    public WorldEntityBuilder setWorld(World world) {
        this.world = world;
        return this;
    }

    @Override
    public @NotNull WorldEntity build() {
        return new WorldEntity(this);
    }

    @Override
    public @NotNull Builder<WorldEntity> reset() {
        this.entity = null;
        this.fellFrom = null;
        this.landedOn = null;
        this.position = null;
        this.world = null;
        return this;
    }

    @Override
    public @NotNull Builder<WorldEntity> copy() {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public @NotNull Builder<WorldEntity> from(WorldEntity value) {
        this.entity = value.getEntity();
        this.world = value.getWorld();
        this.fellFrom = value.getFellFrom().orElse(null);
        this.landedOn = value.getLandedOn().orElse(null);
        this.position = value.getPosition();
        this.instanceId = value.getInstanceId();
        return this;
    }
}
