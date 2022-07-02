package org.absorb.world.biome;

import me.nullicorn.nedit.type.NBTCompound;
import org.absorb.files.nbt.compound.NBTCompoundBuilder;
import org.absorb.files.nbt.compound.NBTCompoundEntry;
import org.absorb.files.nbt.compound.NBTCompoundGroupable;
import org.absorb.files.nbt.compound.NBTCompoundKeys;
import org.absorb.particle.Particle;
import org.absorb.register.Typed;
import org.absorb.utils.Identifiable;
import org.absorb.world.biome.properties.BiomeProperties;
import org.absorb.world.biome.properties.TemperatureModifier;
import org.absorb.world.biome.sound.BiomeSound;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

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
    private final @Nullable BiomeSound moodSound;
    private final @Nullable Integer tickDelay;
    private final @Nullable Integer blockSearchExtent;
    private final @Nullable BiomeSound musicSound;
    private final @Nullable Integer musicMinimumDelay;
    private final @Nullable Integer musicMaximumDelay;
    private final @Nullable Boolean replaceCurrentMusic;
    private final @Nullable BiomeSound additionsSound;
    private final @Nullable BiomeSound ambientSound;
    private final @Nullable Double additionsTickChance;
    private final @Nullable Particle particle;

    public Biome(@NotNull BiomeBuilder builder) {
        this.offset = builder.getOffset();
        this.moodSound = builder.getMoodSound();
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
        this.musicMaximumDelay = builder.getMusicMaximumDelay();
        this.musicMinimumDelay = builder.getMusicMinimumDelay();
        this.musicSound = builder.getMusicSound();
        this.replaceCurrentMusic = builder.getReplaceCurrentMusic();
        this.additionsSound = builder.getAdditionsSound();
        this.additionsTickChance = builder.getAdditionTickChance();
        this.ambientSound = builder.getAmbientSound();
        this.particle = builder.getParticle();
        if (this.defaultProperties == null) {
            throw new IllegalStateException("DefaultProperties cannot be null");
        }
        if (this.category == null) {
            throw new IllegalStateException("Category cannot be null");
        }
        if (this.name == null) {
            throw new IllegalStateException("Name cannot be null");
        }
        if (this.supplier == null) {
            throw new IllegalStateException("Supplier cannot be null");
        }
    }

    public Optional<BiomeSound> getAdditionsSound() {
        return Optional.ofNullable(this.additionsSound);
    }

    public Optional<BiomeSound> getAmbientSound() {
        return Optional.ofNullable(this.ambientSound);
    }

    public OptionalDouble getAdditionsTickChance() {
        if (this.additionsTickChance == null) {
            return OptionalDouble.empty();
        }
        return OptionalDouble.of(this.additionsTickChance);
    }

    public Optional<BiomeSound> getMusic() {
        return Optional.ofNullable(this.musicSound);
    }

    public OptionalInt getMusicMinimumDelay() {
        if (this.musicMinimumDelay == null) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(this.musicMinimumDelay);
    }

    public OptionalInt getMusicMaximumDelay() {
        if (this.musicMaximumDelay == null) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(this.musicMaximumDelay);
    }

    public Optional<Boolean> willMusicReplaceCurrent() {
        return Optional.ofNullable(this.replaceCurrentMusic);
    }

    public OptionalDouble getOffset() {
        if (this.offset == null) {
            return OptionalDouble.empty();
        }
        return OptionalDouble.of(this.offset);
    }

    public Optional<BiomeSound> getMoodSound() {
        return Optional.ofNullable(this.moodSound);
    }

    public OptionalInt getTickDelay() {
        if (this.tickDelay == null) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(this.tickDelay);
    }

    public OptionalInt getBlockSearchExtent() {
        if (this.blockSearchExtent == null) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(this.blockSearchExtent);
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
        Collection<NBTCompoundEntry<?, ?>> music = new HashSet<>();
        Collection<NBTCompoundEntry<?, ?>> additionsSound = new HashSet<>();

        this
                .getMusic()
                .ifPresent(musicSound -> music.add(NBTCompoundKeys.SOUND.withValue(musicSound.getResourceKey())));
        this.getMusicMaximumDelay().ifPresent(max -> music.add(NBTCompoundKeys.MAX_DELAY.withValue(max)));
        this.getMusicMinimumDelay().ifPresent(min -> music.add(NBTCompoundKeys.MIN_DELAY.withValue(min)));
        this
                .willMusicReplaceCurrent()
                .ifPresent(replace -> music.add(NBTCompoundKeys.REPLACE_CURRENT_MUSIC.withValue(replace)));

        values.add(NBTCompoundKeys.NAME.withValue(this.getResourceKey()));
        values.add(NBTCompoundKeys.ID.withValue(this.getNetworkId()));

        this.getMoodSound().ifPresent(bs -> sounds.add(NBTCompoundKeys.SOUND.withValue(bs.getResourceKey())));
        this.getTickDelay().ifPresent(td -> sounds.add(NBTCompoundKeys.TICK_DELAY.withValue(this.tickDelay)));
        this.getOffset().ifPresent(os -> sounds.add(NBTCompoundKeys.OFFSET.withValue(os)));
        this.getBlockSearchExtent().ifPresent(bse -> sounds.add(NBTCompoundKeys.BLOCK_SEARCH_EXTENT.withValue(bse)));

        properties.add(NBTCompoundKeys.PRECIPITATION.withValue(this.defaultProperties.getWeather()));
        //properties.add(NBTCompoundKeys.DEPTH.withValue(this.getDepth()));
        properties.add(NBTCompoundKeys.TEMPERATURE.withValue(this.getTemperature()));
        //properties.add(NBTCompoundKeys.SCALE.withValue(this.getScale()));
        properties.add(NBTCompoundKeys.DOWNFALL.withValue(this.getDownfall()));
        properties.add(NBTCompoundKeys.CATEGORY.withValue(this.getCategory()));
        this
                .getTemperatureModifier()
                .ifPresent(modifier -> properties.add(NBTCompoundKeys.TEMPERATURE_MODIFIER.withValue(modifier)));

        this
                .getAdditionsSound()
                .ifPresent(sound -> additionsSound.add(NBTCompoundKeys.SOUND.withValue(sound.getResourceKey())));
        this
                .getAdditionsTickChance()
                .ifPresent(chance -> additionsSound.add(NBTCompoundKeys.TICK_CHANCE.withValue(chance)));

        effects.add(NBTCompoundKeys.SKY_COLOR.withValue(this.getDefaultProperties().getSkyColour()));
        effects.add(NBTCompoundKeys.WATER_FOG_COLOR.withValue(this.getDefaultProperties().getWaterFogColour()));
        effects.add(NBTCompoundKeys.FOG_COLOR.withValue(this.getDefaultProperties().getFogColour()));
        effects.add(NBTCompoundKeys.WATER_COLOR.withValue(this.getDefaultProperties().getWaterColour()));
        this
                .getDefaultProperties()
                .getFoliageColour()
                .ifPresent(color -> effects.add(NBTCompoundKeys.FOLIAGE_COLOR.withValue(color)));
        this
                .getDefaultProperties()
                .getGrassColourModifier()
                .ifPresent(color -> effects.add(NBTCompoundKeys.GRASS_COLOR_MODIFIER.withValue(color)));
        this
                .getDefaultProperties()
                .getGrassColour()
                .ifPresent(color -> effects.add(NBTCompoundKeys.GRASS_COLOR.withValue(color)));

        effects.add(NBTCompoundKeys.MOOD_SOUND.withValue(new NBTCompoundBuilder().addAll(sounds).build()));
        if (!music.isEmpty()) {
            effects.add(NBTCompoundKeys.MUSIC.withValue(new NBTCompoundBuilder().addAll(music).build()));
        }
        if (!additionsSound.isEmpty()) {
            effects.add(NBTCompoundKeys.ADDITIONS_SOUND.withValue(new NBTCompoundBuilder()
                                                                          .addAll(additionsSound)
                                                                          .build()));
        }
        this
                .getAmbientSound()
                .ifPresent(sound -> effects.add(NBTCompoundKeys.AMBIENT_SOUND.withValue(sound.getResourceKey())));
        if (this.particle != null) {
            NBTCompound particleCompound = this.particle.toNBT();
            effects.add(NBTCompoundKeys.PARTICLE.withValue(particleCompound));
        }

        NBTCompound effectsGroup = new NBTCompoundBuilder().addAll(effects).build();
        properties.add(NBTCompoundKeys.BIOME_EFFECTS.withValue(effectsGroup));

        NBTCompound propertiesGroup = new NBTCompoundBuilder().addAll(properties).build();
        values.add(NBTCompoundKeys.ELEMENT.withValue(propertiesGroup));

        return new NBTCompoundBuilder().addAll(values).build();
    }
}
