package org.absorb.particle;

import me.nullicorn.nedit.type.NBTCompound;
import org.absorb.files.nbt.compound.NBTCompoundBuilder;
import org.absorb.files.nbt.compound.NBTCompoundEntry;
import org.absorb.files.nbt.compound.NBTCompoundGroupable;
import org.absorb.files.nbt.compound.NBTCompoundKeys;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class Particle implements NBTCompoundGroupable {

    private final @NotNull ParticleType type;
    private final float probability;

    public Particle(@NotNull ParticleBuilder builder) {
        this.type = builder.getType();
        this.probability = builder.getProbability();
    }

    public @NotNull ParticleType getType() {
        return this.type;
    }

    public float getProbability() {
        return this.probability;
    }

    @Override
    public NBTCompound toNBT() {
        Set<NBTCompoundEntry<?, ?>> set = new HashSet<>();
        Set<NBTCompoundEntry<?, ?>> options = new HashSet<>();
        set.add(NBTCompoundKeys.PROBABILITY.withValue(this.probability));
        options.add(NBTCompoundKeys.RESOURCE_TYPE.withValue(this.type.getResourceKey()));
        set.add(NBTCompoundKeys.OPTIONS.withValue(new NBTCompoundBuilder().addAll(options).build()));
        return new NBTCompoundBuilder().addAll(set).build();
    }
}
