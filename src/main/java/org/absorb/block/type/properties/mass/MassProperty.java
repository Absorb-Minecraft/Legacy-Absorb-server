package org.absorb.block.type.properties.mass;

import org.absorb.block.type.properties.BlockTypeProperty;
import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

public class MassProperty implements BlockTypeProperty {

    private final @NotNull MassType type;

    public MassProperty(@NotNull MassType type) {
        this.type = type;
    }

    public MassType get() {
        return this.type;
    }

    @Override
    public @NotNull String getName() {
        return "Mass Type";
    }

    @Override
    public @NotNull String getKey() {
        return "mass_type";
    }

    @Override
    public @NotNull String getHost() {
        return Identifiable.ABSORB_HOST;
    }
}
