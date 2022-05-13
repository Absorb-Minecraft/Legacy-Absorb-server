package org.absorb.world.biome;

import me.nullicorn.nedit.type.NBTCompound;
import org.absorb.files.nbt.compound.NBTCompoundKeys;
import org.absorb.register.AbsorbKey;
import org.absorb.utils.Builder;
import org.absorb.world.biome.properties.BiomeProperties;
import org.absorb.world.biome.properties.BiomePropertiesBuilder;
import org.absorb.world.biome.properties.TemperatureModifier;
import org.absorb.world.biome.sound.BiomeSound;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

public class BiomeBuilder implements Builder<Biome> {

    private float depth;
    private float temperature;
    private float scale;
    private BiomeCategory category;
    private String name;
    private String host;
    private float downfall;
    private BiomeProperties defaultProperties;
    private TemperatureModifier modifier;
    private int networkId;
    private Double offset;
    private BiomeSound sound;
    private Integer tickDelay;
    private Integer blockSearchExtent;

    public Integer getTickDelay() {
        return this.tickDelay;
    }

    public BiomeBuilder setTickDelay(Integer tickDelay) {
        this.tickDelay = tickDelay;
        return this;
    }

    public Integer getBlockSearchExtent() {
        return this.blockSearchExtent;
    }

    public BiomeBuilder setBlockSearchExtent(Integer blockSearchExtent) {
        this.blockSearchExtent = blockSearchExtent;
        return this;
    }

    public BiomeSound getSound() {
        return this.sound;
    }

    public BiomeBuilder setSound(BiomeSound sound) {
        this.sound = sound;
        return this;
    }

    public BiomeBuilder setOffset(@Nullable Double offset) {
        this.offset = offset;
        return this;
    }

    public Double getOffset() {
        return this.offset;
    }

    public TemperatureModifier getTemperatureModifier() {
        return this.modifier;
    }

    public BiomeBuilder setTemperatureModifier(TemperatureModifier modifier) {
        this.modifier = modifier;
        return this;
    }

    public float getDepth() {
        return this.depth;
    }

    public BiomeBuilder setDepth(float depth) {
        this.depth = depth;
        return this;
    }

    public float getTemperature() {
        return this.temperature;
    }

    public BiomeBuilder setTemperature(float temperature) {
        this.temperature = temperature;
        return this;
    }

    public float getScale() {
        return this.scale;
    }

    public BiomeBuilder setScale(float scale) {
        this.scale = scale;
        return this;
    }

    public BiomeCategory getCategory() {
        return this.category;
    }

    public BiomeBuilder setCategory(BiomeCategory category) {
        this.category = category;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public BiomeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getHost() {
        return this.host;
    }

    public BiomeBuilder setHost(String host) {
        this.host = host;
        return this;
    }

    public float getDownfall() {
        return this.downfall;
    }

    public BiomeBuilder setDownfall(float downfall) {
        this.downfall = downfall;
        return this;
    }

    public BiomeProperties getDefaultProperties() {
        return this.defaultProperties;
    }

    public BiomeBuilder setDefaultProperties(BiomeProperties defaultProperties) {
        this.defaultProperties = defaultProperties;
        return this;
    }

    public int getNetworkId() {
        return this.networkId;
    }

    public BiomeBuilder setNetworkId(int id) {
        this.networkId = id;
        return this;
    }

    @Override
    public Biome build() {
        return new Biome(this);
    }

    @Override
    public Builder<Biome> reset() {
        this.category = null;
        this.defaultProperties = null;
        this.depth = 0;
        this.downfall = 0;
        this.name = null;
        this.scale = 0;
        this.host = null;
        this.temperature = 0;
        return this;
    }

    @Override
    public Builder<Biome> copy() {
        return new BiomeBuilder()
                .setCategory(this.category)
                .setDefaultProperties(this.defaultProperties)
                .setDepth(this.getDepth())
                .setDownfall(this.getDownfall())
                .setName(this.getName())
                .setHost(this.getHost())
                .setScale(this.getScale())
                .setTemperature(this.getTemperature())
                .setNetworkId(this.getNetworkId());
    }

    public BiomeBuilder from(@NotNull NBTCompound group) {
        AbsorbKey name =
                NBTCompoundKeys.NAME.getValue(group).orElseThrow(() -> new IllegalArgumentException(
                        "Name " +
                                "is " +
                                "required"));
        this.host = name.host();
        this.name = name.value();
        this.depth =
                NBTCompoundKeys.DEPTH.getValue(group).orElseThrow(() -> new IllegalArgumentException(
                        "Depth" +
                                " is " +
                                "required"));
        this.scale =
                NBTCompoundKeys.SCALE.getValue(group).orElseThrow(() -> new IllegalArgumentException("Scale is " +
                        "required"));
        this.temperature = NBTCompoundKeys.TEMPERATURE.getValue(group).orElseThrow(() -> new IllegalArgumentException(
                "temperature is required"));
        this.downfall =
                NBTCompoundKeys.DOWNFALL.getValue(group).orElseThrow(() -> new IllegalArgumentException(
                        "downfall is required"));
        this.category =
                NBTCompoundKeys.CATEGORY.getValue(group).orElseThrow(() -> new IllegalArgumentException(
                        "Category is required"));
        this.modifier = NBTCompoundKeys.TEMPERATURE_MODIFIER.getValue(group).orElseThrow(() -> new IllegalArgumentException(
                "temperature modifier is required"));
        this.networkId =
                NBTCompoundKeys.ID.getValue(group).orElseThrow(() -> new IllegalArgumentException("ID is " +
                        "required"));
        this.defaultProperties = new BiomePropertiesBuilder()
                .setGrassColourModifier(NBTCompoundKeys.GRASS_COLOR_MODIFIER.getValue(group).orElseThrow(() -> new IllegalArgumentException("Grass colour modifier is required")))
                .setFoliageColour(NBTCompoundKeys.FOLIAGE_COLOR.getValue(group).orElseThrow(() -> new IllegalArgumentException("Foliage colour is required")))
                .setGrassColour(NBTCompoundKeys.GRASS_COLOR.getValue(group).orElseThrow(() -> new IllegalArgumentException("Grass colour is required")))
                .setFogColour(NBTCompoundKeys.FOG_COLOR.getValue(group).orElseThrow(() -> new IllegalArgumentException("Fog colour is required")))
                .setWaterColour(NBTCompoundKeys.WATER_COLOR.getValue(group).orElseThrow(() -> new IllegalArgumentException("Water colour is required")))
                .setSkyColour(NBTCompoundKeys.SKY_COLOR.getValue(group).orElseThrow(() -> new IllegalArgumentException("Sky colour is required")))
                .setWaterFogColour(NBTCompoundKeys.WATER_FOG_COLOR.getValue(group).orElseThrow(() -> new IllegalArgumentException("water fog color is required")))
                .build();
        return this;
    }
}
