package org.absorb.world.biome.properties;

import org.absorb.utils.Builder;

public class BiomePropertiesBuilder implements Builder<BiomeProperties> {

    private BiomeWeather weather;
    private int skyColour;
    private int waterFogColour;
    private int fogColour;
    private int waterColour;
    private Integer foliageColour;
    private Integer grassColour;
    private GrassModifier grassColourModifier;

    public BiomeWeather getWeather() {
        return this.weather;
    }

    public BiomePropertiesBuilder setWeather(BiomeWeather weather) {
        this.weather = weather;
        return this;
    }

    public int getSkyColour() {
        return this.skyColour;
    }

    public BiomePropertiesBuilder setSkyColour(int skyColour) {
        this.skyColour = skyColour;
        return this;
    }

    public int getWaterFogColour() {
        return this.waterFogColour;
    }

    public BiomePropertiesBuilder setWaterFogColour(int waterFogColour) {
        this.waterFogColour = waterFogColour;
        return this;
    }

    public int getFogColour() {
        return this.fogColour;
    }

    public BiomePropertiesBuilder setFogColour(int fogColour) {
        this.fogColour = fogColour;
        return this;
    }

    public int getWaterColour() {
        return this.waterColour;
    }

    public BiomePropertiesBuilder setWaterColour(int waterColour) {
        this.waterColour = waterColour;
        return this;
    }

    public Integer getFoliageColour() {
        return this.foliageColour;
    }

    public BiomePropertiesBuilder setFoliageColour(int foliageColour) {
        this.foliageColour = foliageColour;
        return this;
    }

    public Integer getGrassColour() {
        return this.grassColour;
    }

    public BiomePropertiesBuilder setGrassColour(int grassColour) {
        this.grassColour = grassColour;
        return this;
    }

    public GrassModifier getGrassColourModifier() {
        return this.grassColourModifier;
    }

    public BiomePropertiesBuilder setGrassColourModifier(GrassModifier grassColourModifier) {
        this.grassColourModifier = grassColourModifier;
        return this;
    }

    @Override
    public BiomeProperties build() {
        return new BiomeProperties(this);
    }

    @Override
    public Builder<BiomeProperties> reset() {
        this.grassColourModifier = null;
        this.weather = null;
        this.grassColour = null;
        return this;
    }

    @Override
    public Builder<BiomeProperties> copy() {
        return new BiomePropertiesBuilder().setFogColour(this.getFogColour()).setFoliageColour(this.getFoliageColour()).setGrassColour(this.getGrassColour()).setGrassColourModifier(this.getGrassColourModifier());
    }
}
