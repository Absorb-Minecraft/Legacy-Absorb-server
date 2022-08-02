package org.absorb.world;

import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3i;

public class WorldBuilder implements Builder<World> {

    private Vector3i blockMin;
    private Vector3i blockMax;
    private WorldData worldData;

    public WorldData getWorldData() {
        return this.worldData;
    }

    public WorldBuilder setWorldData(WorldData worldData) {
        this.worldData = worldData;
        return this;
    }

    public Vector3i getBlockMin() {
        return this.blockMin;
    }

    public WorldBuilder setBlockMin(Vector3i blockMin) {
        this.blockMin = blockMin;
        return this;
    }

    public Vector3i getBlockMax() {
        return this.blockMax;
    }

    public WorldBuilder setBlockMax(Vector3i blockMax) {
        this.blockMax = blockMax;
        return this;
    }

    @Override
    public World build() {
        return new World(this);
    }

    @Override
    public WorldBuilder reset() {
        this.blockMax = null;
        this.blockMin = null;
        return this;
    }

    @Override
    public WorldBuilder copy() {
        return new WorldBuilder().setBlockMax(this.getBlockMax()).setBlockMin(this.getBlockMin());
    }

    @Override
    public @NotNull Builder<World> from(World value) {
        this.blockMax = value.getMaxBlock();
        this.blockMin = value.getMinBlock();
        this.worldData = value.getWorldData();
        return this;
    }
}
