package org.absorb.block.type.properties.mass;

import org.absorb.block.type.properties.BlockTypeProperty;
import org.jetbrains.annotations.NotNull;

public class MassProperty implements BlockTypeProperty<MassType> {

    private final @NotNull MassType type;

    public MassProperty(@NotNull MassType type) {
        this.type = type;
    }

    @Override
    public MassType get() {
        return this.type;
    }
}
