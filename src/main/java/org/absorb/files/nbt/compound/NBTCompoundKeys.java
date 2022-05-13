package org.absorb.files.nbt.compound;

import me.nullicorn.nedit.type.NBTCompound;
import me.nullicorn.nedit.type.TagType;
import org.absorb.world.biome.BiomeCategory;
import org.absorb.world.biome.properties.BiomeWeather;
import org.absorb.world.biome.properties.GrassModifier;
import org.absorb.world.biome.properties.TemperatureModifier;

import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class NBTCompoundKeys {

    public static final NBTCompoundKey.Type<Integer> BLOCK_SEARCH_EXTENT = new NBTCompoundKey.Type<>(TagType.INT,
            "block_search_extent");
    public static final NBTCompoundKey.Type<Double> OFFSET = new NBTCompoundKey.Type<>(TagType.DOUBLE, "offset");
    public static final NBTCompoundKey.Resource SOUND = new NBTCompoundKey.Resource("sound");
    public static final NBTCompoundKey.Type<Integer> TICK_DELAY = new NBTCompoundKey.Type<>(TagType.INT,
            "tick_delay");
    public static final NBTCompoundKey.Type<Long[]> MOTION_BLOCKING = new NBTCompoundKey.Type<>(TagType.LONG_ARRAY,
            "MOTION_BLOCKING");
    public static final NBTCompoundKey.Type<NBTCompound> MOOD_SOUND = new NBTCompoundKey.Type<>(TagType.COMPOUND
            , "mood_sound");
    public static final NBTCompoundKey.Type<Long[]> WORLD_SURFACE = new NBTCompoundKey.Type<>(TagType.LONG_ARRAY,
            "WORLD_SURFACE");
    public static final NBTCompoundKey.Type<NBTCompound> DIMENSION_TYPE =
            new NBTCompoundKey.Type<>(TagType.COMPOUND, "minecraft:dimension_type");
    public static final NBTCompoundKey.Type<NBTCompound> WORLD_GEN_BIOME =
            new NBTCompoundKey.Type<>(TagType.COMPOUND, "minecraft:worldgen/biome");

    public static final NBTCompoundKey.BiomeValue BIOMES = new NBTCompoundKey.BiomeValue("value");
    public static final NBTCompoundKey.Type<String> COMPOUND_TYPE = new NBTCompoundKey.Type<>(TagType.STRING, "type");

    public static final NBTCompoundKey.Boolean PIGLIN_SAFE =
            new NBTCompoundKey.Boolean("piglin_safe");
    public static final NBTCompoundKey.Boolean NATURAL =
            new NBTCompoundKey.Boolean("natural");
    public static final NBTCompoundKey.Type<Float> AMBIENT_LIGHT = new NBTCompoundKey.Type<>(TagType.FLOAT,
            "ambient_light");
    public static final NBTCompoundKey.Type<Long> FIXED_TIME = new NBTCompoundKey.Type<>(TagType.LONG, "fixed_time");
    public static final NBTCompoundKey.Type<String> INFINIBURN = new NBTCompoundKey.Type<>(TagType.STRING,
            "infiniburn");
    public static final NBTCompoundKey.Boolean RESPAWN_ANCHOR_WORKS = new NBTCompoundKey.Boolean(
            "respawn_anchor_works");
    public static final NBTCompoundKey.Boolean HAS_SKYLIGHT = new NBTCompoundKey.Boolean("has_skylight");
    public static final NBTCompoundKey.Boolean BED_WORKS = new NBTCompoundKey.Boolean("bed_works");
    public static final NBTCompoundKey.Resource DIMENSION_EFFECTS = new NBTCompoundKey.Resource(
            "effects");
    public static final NBTCompoundKey.Boolean HAS_RAIDS = new NBTCompoundKey.Boolean("has_raids");
    public static final NBTCompoundKey.Type<Integer> MIN_Y = new NBTCompoundKey.Type<>(TagType.INT, "min_y");
    public static final NBTCompoundKey.Type<Integer> HEIGHT = new NBTCompoundKey.Type<>(TagType.INT, "height");
    public static final NBTCompoundKey.Type<Integer> LOGICAL_HEIGHT = new NBTCompoundKey.Type<>(TagType.INT,
            "logical_height");
    public static final NBTCompoundKey.Type<Double> COORDINATE_SCALE = new NBTCompoundKey.Type<>(TagType.DOUBLE,
            "coordinate_scale");
    public static final NBTCompoundKey.Boolean ULTRAWARM = new NBTCompoundKey.Boolean("ultrawarm");
    public static final NBTCompoundKey.Boolean HAS_CEILING = new NBTCompoundKey.Boolean("has_ceiling");
    public static final NBTCompoundKey.Resource NAME = new NBTCompoundKey.Resource("name");
    public static final NBTCompoundKey.Type<Integer> ID = new NBTCompoundKey.Type<>(TagType.INT, "id");
    public static final NBTCompoundKey.Resource RESOURCE_TYPE = new NBTCompoundKey.Resource("type");
    public static final NBTCompoundKey.Dimension DIMENSION = new NBTCompoundKey.Dimension("value");
    public static final NBTCompoundKey.Type<NBTCompound> ELEMENT = new NBTCompoundKey.Type<>(TagType.COMPOUND,
            "element");
    public static final NBTCompoundKey.NamedEnum<BiomeWeather> PRECIPITATION = new NBTCompoundKey.NamedEnum<>(
            "precipitation", EnumSet.allOf(BiomeWeather.class));
    public static final NBTCompoundKey.Type<Float> DEPTH = new NBTCompoundKey.Type<>(TagType.FLOAT, "depth");
    public static final NBTCompoundKey.Type<Float> TEMPERATURE = new NBTCompoundKey.Type<>(TagType.FLOAT,
            "temperature");
    public static final NBTCompoundKey.Type<Float> SCALE = new NBTCompoundKey.Type<>(TagType.FLOAT, "scale");
    public static final NBTCompoundKey.Type<Float> DOWNFALL = new NBTCompoundKey.Type<>(TagType.FLOAT, "downfall");
    public static final NBTCompoundKey.NamedEnum<BiomeCategory> CATEGORY = new NBTCompoundKey.NamedEnum<>("category",
            EnumSet.allOf(BiomeCategory.class));
    public static final NBTCompoundKey.NamedEnum<TemperatureModifier> TEMPERATURE_MODIFIER =
            new NBTCompoundKey.NamedEnum<>("temperature_modifier", EnumSet.allOf(TemperatureModifier.class));
    public static final NBTCompoundKey.Type<Integer> SKY_COLOR = new NBTCompoundKey.Type<>(TagType.INT,
            "sky_color");
    public static final NBTCompoundKey.Type<Integer> WATER_FOG_COLOR = new NBTCompoundKey.Type<>(TagType.INT,
            "water_fog_color");
    public static final NBTCompoundKey.Type<Integer> FOG_COLOR = new NBTCompoundKey.Type<>(TagType.INT,
            "fog_color");
    public static final NBTCompoundKey.Type<Integer> FOLIAGE_COLOR = new NBTCompoundKey.Type<>(TagType.INT,
            "foliage_color");
    public static final NBTCompoundKey.Type<Integer> GRASS_COLOR = new NBTCompoundKey.Type<>(TagType.INT,
            "grass_color");
    public static final NBTCompoundKey.Type<Integer> WATER_COLOR = new NBTCompoundKey.Type<>(TagType.INT,
            "water_color");
    public static final NBTCompoundKey.NamedEnum<GrassModifier> GRASS_COLOR_MODIFIER =
            new NBTCompoundKey.NamedEnum<>("grass_color_modifier", EnumSet.allOf(GrassModifier.class));
    public static final NBTCompoundKey.Type<NBTCompound> BIOME_EFFECTS =
            new NBTCompoundKey.Type<>(TagType.COMPOUND, "effects");

    public static final Set<NBTCompoundKey<?, ?>> KEYS;

    static {
        KEYS = Arrays
                .stream(NBTCompoundKeys.class.getDeclaredFields())
                .filter(field -> field.getType().isAssignableFrom(NBTCompoundKey.class))
                .filter(field -> Modifier.isPublic(field.getModifiers()))
                .filter(field -> Modifier.isStatic(field.getModifiers()))
                .map(field -> {
                    try {
                        return (NBTCompoundKey<?, ?>) field.get(null);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        //noinspection ReturnOfNull
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toUnmodifiableSet());
    }

    public static Set<NBTCompoundKey<?, ?>> getKeysWithName(String name) {
        return KEYS.parallelStream().filter(key -> key.getKey().equals(name)).collect(Collectors.toUnmodifiableSet());
    }

    public static <T> Optional<NBTCompoundKey<T, ?>> getKeysWithName(String name, TagType tag) {
        return KEYS.parallelStream().filter(key -> key.getKey().equals(name)).filter(key -> key.getTag().equals(tag)).findAny().map(key -> (NBTCompoundKey<T, ?>) key);
    }
}
