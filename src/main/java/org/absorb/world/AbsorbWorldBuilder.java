package org.absorb.world;

import org.absorb.utils.Builder;
import org.spongepowered.math.vector.Vector3i;

public class AbsorbWorldBuilder implements Builder<AbsorbWorld> {

    private Vector3i blockMin;
    private Vector3i blockMax;
    private AbsorbWorldData worldData;

    public AbsorbWorldData getWorldData() {
        return this.worldData;
    }

    public AbsorbWorldBuilder setWorldData(AbsorbWorldData worldData) {
        this.worldData = worldData;
        return this;
    }

    public Vector3i getBlockMin() {
        return this.blockMin;
    }

    public AbsorbWorldBuilder setBlockMin(Vector3i blockMin) {
        this.blockMin = blockMin;
        return this;
    }

    public Vector3i getBlockMax() {
        return this.blockMax;
    }

    public AbsorbWorldBuilder setBlockMax(Vector3i blockMax) {
        this.blockMax = blockMax;
        return this;
    }

    @Override
    public AbsorbWorld build() {
        return new AbsorbWorld(this);
    }

    @Override
    public AbsorbWorldBuilder reset() {
        this.blockMax = null;
        this.blockMin = null;
        return this;
    }

    @Override
    public AbsorbWorldBuilder copy() {
        return new AbsorbWorldBuilder().setBlockMax(this.getBlockMax()).setBlockMin(this.getBlockMin());
    }
}
