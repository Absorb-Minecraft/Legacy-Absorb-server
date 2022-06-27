package org.absorb.block.type.properties.light;

import org.absorb.block.type.properties.BlockTypeProperty;
import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

public class EmittingLightBlockTypeProperty implements BlockTypeProperty {

    private final int lightLevel;

    public EmittingLightBlockTypeProperty(int lightLevel) {
        this.lightLevel = lightLevel;
    }

    public int getLightLevel() {
        return this.lightLevel;
    }

    @Override
    public @NotNull String getName() {
        return "Emitting Light";
    }

    @Override
    public @NotNull String getKey() {
        return "emitting_light";
    }

    @Override
    public @NotNull String getHost() {
        return Identifiable.ABSORB_HOST;
    }
}
