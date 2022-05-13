package org.absorb.world.biome.sound;

import org.jetbrains.annotations.NotNull;

public enum BiomeSounds implements BiomeSound {
    ;

    private final @NotNull String name;
    private final @NotNull String key;
    private final @NotNull String host;

    BiomeSounds(@NotNull String name, @NotNull String host, @NotNull String key){
        this.host = host;
        this.name = name;
        this.key = key;
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
