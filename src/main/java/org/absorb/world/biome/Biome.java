package org.absorb.world.biome;

import me.nullicorn.nedit.type.NBTCompound;
import org.absorb.files.nbt.compound.NBTCompoundBuilder;
import org.absorb.files.nbt.compound.NBTCompoundEntry;
import org.absorb.files.nbt.compound.NBTCompoundGroupable;
import org.absorb.files.nbt.compound.NBTCompoundKeys;
import org.absorb.register.Typed;
import org.absorb.utils.Identifiable;
import org.absorb.world.biome.properties.BiomeProperties;
import org.absorb.world.biome.properties.TemperatureModifier;
import org.absorb.world.biome.sound.BiomeSound;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Typed(getTypesClass = Biomes.class)
public class Biome implements Identifiable, NBTCompoundGroupable {

    private final float depth;
    private final float temperature;
    private final @Nullable TemperatureModifier modifier;
    private final float scale;
    private final @NotNull BiomeCategory category;
    private final @NotNull String name;
    private final @NotNull String supplier;
    private final float downfall;
    private final @NotNull BiomeProperties defaultProperties;
    private final int networkId;
    private final @Nullable Double offset;
    private final @Nullable BiomeSound sound;
    private final @Nullable Integer tickDelay;
    private final @Nullable Integer blockSearchExtent;

    public Biome(@NotNull BiomeBuilder builder) {
        this.offset = builder.getOffset();
        this.sound = builder.getSound();
        this.tickDelay = builder.getTickDelay();
        this.blockSearchExtent = builder.getBlockSearchExtent();
        this.category = builder.getCategory();
        this.defaultProperties = builder.getDefaultProperties();
        this.depth = builder.getDepth();
        this.downfall = builder.getDownfall();
        this.name = builder.getName();
        this.scale = builder.getScale();
        this.supplier = builder.getHost();
        this.modifier = builder.getTemperatureModifier();
        this.temperature = builder.getTemperature();
        this.networkId = builder.getNetworkId();
        if (this.defaultProperties==null) {
            throw new IllegalStateException("DefaultProperties cannot be null");
        }
        if (this.category==null) {
            throw new IllegalStateException("Category cannot be null");
        }
        if (this.name==null) {
            throw new IllegalStateException("Name cannot be null");
        }
        if (this.supplier==null) {
            throw new IllegalStateException("Supplier cannot be null");
        }
    }

    public Optional<Double> getOffset() {
        return Optional.ofNullable(this.offset);
    }

    public Optional<BiomeSound> getSound() {
        return Optional.ofNullable(this.sound);
    }

    public Optional<Integer> getTickDelay() {
        return Optional.ofNullable(this.tickDelay);
    }

    public Optional<Integer> getBlockSearchExtent() {
        return Optional.ofNullable(this.blockSearchExtent);
    }

    public int getNetworkId() {
        return this.networkId;
    }

    public Optional<TemperatureModifier> getTemperatureModifier() {
        return Optional.ofNullable(this.modifier);
    }

    public float getDepth() {
        return this.depth;
    }

    public float getScale() {
        return this.scale;
    }

    public @NotNull BiomeCategory getCategory() {
        return this.category;
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    @Override
    public @NotNull String getKey() {
        return this.name.toLowerCase();
    }

    @Override
    public @NotNull String getHost() {
        return this.supplier;
    }

    public float getDownfall() {
        return this.downfall;
    }

    public float getTemperature() {
        return this.temperature;
    }

    public @NotNull BiomeProperties getDefaultProperties() {
        return this.defaultProperties;
    }

    @Override
    public NBTCompound toNBT() {
        Collection<NBTCompoundEntry<?, ?>> values = new HashSet<>();
        Collection<NBTCompoundEntry<?, ?>> properties = new HashSet<>();
        Set<NBTCompoundEntry<?, ?>> effects = new HashSet<>();
        Collection<NBTCompoundEntry<?, ?>> sounds = new HashSet<>();

        values.add(NBTCompoundKeys.NAME.withValue(this.getResourceKey()));
        values.add(NBTCompoundKeys.ID.withValue(this.getNetworkId()));

        this.getSound().ifPresent(bs -> sounds.add(NBTCompoundKeys.SOUND.withValue(bs.getResourceKey())));
        this.getTickDelay().ifPresent(td -> sounds.add(NBTCompoundKeys.TICK_DELAY.withValue(this.tickDelay)));
        this.getOffset().ifPresent(os -> sounds.add(NBTCompoundKeys.OFFSET.withValue(os)));
        this.getBlockSearchExtent().ifPresent(bse -> sounds.add(NBTCompoundKeys.BLOCK_SEARCH_EXTENT.withValue(bse)));

        properties.add(NBTCompoundKeys.PRECIPITATION.withValue(this.defaultProperties.getWeather()));
        //properties.add(NBTCompoundKeys.DEPTH.withValue(this.getDepth()));
        properties.add(NBTCompoundKeys.TEMPERATURE.withValue(this.getTemperature()));
        //properties.add(NBTCompoundKeys.SCALE.withValue(this.getScale()));
        properties.add(NBTCompoundKeys.DOWNFALL.withValue(this.getDownfall()));
        properties.add(NBTCompoundKeys.CATEGORY.withValue(this.getCategory()));


        effects.add(NBTCompoundKeys.SKY_COLOR.withValue(this.getDefaultProperties().getSkyColour()));
        effects.add(NBTCompoundKeys.WATER_FOG_COLOR.withValue(this.getDefaultProperties().getWaterFogColour()));
        effects.add(NBTCompoundKeys.FOG_COLOR.withValue(this.getDefaultProperties().getFogColour()));
        effects.add(NBTCompoundKeys.WATER_COLOR.withValue(this.getDefaultProperties().getWaterColour()));
        this.getDefaultProperties().getFoliageColour().ifPresent(color -> effects.add(NBTCompoundKeys.FOLIAGE_COLOR.withValue(color)));
        this.getDefaultProperties().getGrassColourModifier().ifPresent(color -> effects.add(NBTCompoundKeys.GRASS_COLOR_MODIFIER.withValue(color)));


        effects.add(NBTCompoundKeys.MOOD_SOUND.withValue(new NBTCompoundBuilder().addAll(sounds).build()));

        NBTCompound effectsGroup = new NBTCompoundBuilder().addAll(effects).build();
        properties.add(NBTCompoundKeys.BIOME_EFFECTS.withValue(effectsGroup));

        NBTCompound propertiesGroup = new NBTCompoundBuilder().addAll(properties).build();
        values.add(NBTCompoundKeys.ELEMENT.withValue(propertiesGroup));

        return new NBTCompoundBuilder().addAll(values).build();
    }
}
