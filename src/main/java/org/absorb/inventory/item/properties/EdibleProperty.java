package org.absorb.inventory.item.properties;

import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

public class EdibleProperty implements ItemTypeProperty{
    @Override
    public @NotNull String getName() {
        return "Ediable";
    }

    @Override
    public @NotNull String getKey() {
        return "ediable";
    }

    @Override
    public @NotNull String getHost() {
        return Identifiable.ABSORB_HOST;
    }
}
