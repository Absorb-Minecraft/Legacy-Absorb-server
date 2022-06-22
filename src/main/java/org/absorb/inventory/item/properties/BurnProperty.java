package org.absorb.inventory.item.properties;

import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

public class BurnProperty implements ItemTypeProperty {

    private final double exp;
    private final int burnTickTime;

    public BurnProperty(int burnTickTime, double exp) {
        this.exp = exp;
        this.burnTickTime = burnTickTime;
    }

    public double getExpGivenAfterBurn() {
        return this.exp;
    }

    public int getTicksForBurn() {
        return this.burnTickTime;
    }


    @Override
    public @NotNull String getName() {
        return "Burnable";
    }

    @Override
    public @NotNull String getKey() {
        return "burn";
    }

    @Override
    public @NotNull String getHost() {
        return Identifiable.ABSORB_HOST;
    }
}
