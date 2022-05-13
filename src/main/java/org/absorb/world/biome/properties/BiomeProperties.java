package org.absorb.world.biome.properties;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.OptionalInt;

public class BiomeProperties {

    private final @NotNull BiomeWeather weather;
    private final int skyColour;
    private final int waterFogColour;
    private final int fogColour;
    private final int waterColour;
    private final @Nullable Integer foliageColour;
    private final @Nullable Integer grassColour;
    private final @Nullable GrassModifier grassColourModifier;

    public BiomeProperties(BiomePropertiesBuilder builder) {
        this.weather = builder.getWeather();
        this.fogColour = builder.getFogColour();
        this.foliageColour = builder.getFoliageColour();
        this.grassColour = builder.getGrassColour();
        this.grassColourModifier = builder.getGrassColourModifier();
        this.waterColour = builder.getWaterColour();
        this.skyColour = builder.getSkyColour();
        this.waterFogColour = builder.getWaterFogColour();
        if (this.weather==null) {
            throw new IllegalStateException("weather cannot be null");
        }
    }

    public @NotNull BiomeWeather getWeather() {
        return this.weather;
    }

    public int getSkyColour() {
        return this.skyColour;
    }

    public int getWaterFogColour() {
        return this.waterFogColour;
    }

    public int getFogColour() {
        return this.fogColour;
    }

    public int getWaterColour() {
        return this.waterColour;
    }

    public @NotNull OptionalInt getFoliageColour() {
        if (this.foliageColour==null) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(this.foliageColour);
    }

    public @NotNull OptionalInt getGrassColour() {
        if (this.grassColour==null) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(this.grassColour);
    }

    public @NotNull Optional<GrassModifier> getGrassColourModifier() {
        return Optional.ofNullable(this.grassColourModifier);
    }
}
