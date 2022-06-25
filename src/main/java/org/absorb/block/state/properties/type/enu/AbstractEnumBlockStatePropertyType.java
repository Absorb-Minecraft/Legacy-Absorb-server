package org.absorb.block.state.properties.type.enu;

import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;

public class AbstractEnumBlockStatePropertyType<E extends Enum<E>> implements EnumBlockStatePropertyType<E> {

    private final EnumSet<E> values;
    private final String name;
    private final String key;
    private final String host;

    public AbstractEnumBlockStatePropertyType(String name, String key, Class<E> clazz) {
        this(name, Identifiable.MINECRAFT_HOST, key, clazz);
    }

    public AbstractEnumBlockStatePropertyType(String name, String host, String key, Class<E> clazz) {
        this(name, host, key, EnumSet.allOf(clazz));
    }

    public AbstractEnumBlockStatePropertyType(String name, String key, EnumSet<E> values) {
        this(name, Identifiable.MINECRAFT_HOST, key, values);
    }

    public AbstractEnumBlockStatePropertyType(String name, String host, String key, EnumSet<E> values) {
        this.values = values;
        this.host = host;
        this.key = key;
        this.name = name;
    }

    @Override
    public EnumSet<E> getValues() {
        return this.values;
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
