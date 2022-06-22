package org.absorb.block.state.properties.type.bool;

import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

public enum BooleanBlockStatePropertyTypes implements BooleanBlockStatePropertyType {
    POWERED("Powered");

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
