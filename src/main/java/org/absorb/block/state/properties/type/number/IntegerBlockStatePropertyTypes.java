package org.absorb.block.state.properties.type.number;

import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

public enum IntegerBlockStatePropertyTypes implements NumberBlockStatePropertyType<Integer> {


    DISTANCE("Distance", 1, 7),
    GROWTH_STAGE("Growth Stage", "stage", 0, 1),
    CANDLES("Candles", 1, 4),
    AGE_2("Age", 0, 2),
    AGE_3("Age", 0, 3),
    AGE_4("Age", 0, 4),
    AGE_6("Age", 0, 6),
    AGE_8("Age", 0, 8),
    AGE_16("Age", 0, 16),
    AGE_26("Age", 0, 26),
    PICKLES("Pickles", 1, 4),
    HONEY_LEVEL("Honey Level", 0, 6),
    SNOW_LAYER("Snow Layer", "layers", 1, 8),
    REDSTONE_POWER_LEVEL("Redstone Power Level", "level", 0, 15),
    DELAY("Redstone Delay", "delay", 1, 4),
    BITES("Bites", 0, 6),
    LIQUID_LEVEL("Liquid Level", "level", 0, 15),
    CAULDRON_LEVEL("Cauldron Level", "level", 1, 3),
    COMPOSTER_LEVEL("Composter Level", "level", 0, 8),
    LIGHT_LEVEL("Light Level", "level", 0, 15),
    TURTLE_EGGS("Turtle Eggs", "eggs", 1, 4),
    TURTLE_HATCHED("Turtle Hatched", "hatched", 0, 2),
    MOISTURE("Moisture", 0, 7),
    NOTE("Note", 0, 24),
    RESPAWN_ANCHOR_CHARGE("Respawn Anchor Changes", "charges", 0, 4);
    private final int min;
    private final int max;
    private final String name;
    private final String key;
    private final String host;

    IntegerBlockStatePropertyTypes(String name, int min, int max) {
        this(name, name.toLowerCase().replaceAll(" ", "_"), Identifiable.ABSORB_HOST, min, max);
    }

    IntegerBlockStatePropertyTypes(String name, String key, int min, int max) {
        this(name, Identifiable.ABSORB_HOST, key, min, max);
    }

    IntegerBlockStatePropertyTypes(String name, String host, String key, int min, int max) {
        this.min = min;
        this.max = max;
        this.name = name;
        this.key = key;
        this.host = host;
    }

    @Override
    public Integer getMinValue() {
        return this.min;
    }

    @Override
    public Integer getMaxValue() {
        return this.max;
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    @Override
    public @NotNull String getKey() {
        return this.key;
    }

    @Override
    public @NotNull String getHost() {
        return this.host;
    }
}
