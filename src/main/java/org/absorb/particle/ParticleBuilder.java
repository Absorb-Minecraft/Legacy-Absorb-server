package org.absorb.particle;

import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

public class ParticleBuilder implements Builder<Particle> {

    private ParticleType type;
    private float probability;

    public ParticleType getType() {
        return this.type;
    }

    public ParticleBuilder setType(ParticleType type) {
        this.type = type;
        return this;
    }

    public float getProbability() {
        return this.probability;
    }

    public ParticleBuilder setProbability(float probability) {
        this.probability = probability;
        return this;
    }

    @Override
    public @NotNull Particle build() {
        return new Particle(this);
    }

    @Override
    public @NotNull Builder<Particle> reset() {
        this.probability = 0;
        this.type = null;
        return this;
    }

    @Override
    public @NotNull Builder<Particle> copy() {
        return new ParticleBuilder().setType(this.type).setProbability(this.probability);
    }
}
