package org.absorb.block.state.properties.type.bool;

import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

public enum BooleanBlockStatePropertyTypes implements BooleanBlockStatePropertyType {
    POWERED("Powered"),
    OPEN("Open"),
    NORTH("Connected North", "north"),
    SOUTH("Connected South", "south"),
    EAST("Connected East", "east"),
    WEST("Connected West", "west"),
    UP("Connected above", "up"),
    DOWN("Connected down", "down"),
    BOTTOM("Bottom"),
    WATERLOGGED("Water Logged", "waterlogged"),
    IN_WALL("In Wall"),
    PERSISTENT("Persistent"),
    LIT("Lit"),
    OCCUPIED("Occupied"),
    HAS_BOTTLE_0("Has First Bottle", "has_bottle_0"),
    HAS_BOTTLE_1("Has Second Bottle", "has_bottle_1"),
    HAS_BOTTLE_2("Has Third Bottle", "has_bottle_2"),
    SNOWY("Is Snowy", "snowy"),
    HAS_RECORD("Has Record"),
    HAS_BOOK("Has Book"),
    HANGING("Hanging"),
    EXTENDED("Extended"),
    SHORT("Short"),
    ATTACHED("Attached"),
    DISARMED("Disarmed"),
    DRAG("Drag"),
    TRIGGERED("Triggered"),
    UNSTABLE("Unstable"),
    EYE("Eye"),
    ENABLED("Enabled"),
    INVERTED("Inverted"),
    LOCKED("Locked"),
    REPEAT_CONDITIONAL("Repeat Conditional", "conditional"),
    SIGNAL_FIRE("Signal Fire");
    private final String name;
    private final String key;
    private final String host;

    BooleanBlockStatePropertyTypes(String name) {
        this(name, name.toLowerCase().replaceAll(" ", "_"));
    }

    BooleanBlockStatePropertyTypes(String name, String key) {
        this(name, key, Identifiable.MINECRAFT_HOST);
    }

    BooleanBlockStatePropertyTypes(String name, String key, String host) {
        this.name = name;
        this.key = key;
        this.host = host;
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
