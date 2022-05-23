package org.absorb.particle;

import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

public enum ParticleTypes implements ParticleType {

    WARPED_SPORE("Warped Spore", Identifiable.MINECRAFT_HOST, "warped_spore"),
    CRIMSON_SPORE("Crimson Spore", Identifiable.MINECRAFT_HOST, "crimson_spore"),
    ASH("Ash", Identifiable.MINECRAFT_HOST, "ash"),
    WHITE_ASH("Ash", Identifiable.MINECRAFT_HOST, "white_ash");

    private final @NotNull String name;
    private final @NotNull String key;
    private final @NotNull String host;

    ParticleTypes(@NotNull String name, @NotNull String host, @NotNull String key) {
        this.key = key;
        this.host = host;
        this.name = name;
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
