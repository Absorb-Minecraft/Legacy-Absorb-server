package org.absorb.entity.living.human.tab;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class PlayerTabProperty {

    private final @NotNull String name;
    private final @NotNull String value;
    private final @Nullable String signature;

    public PlayerTabProperty(@NotNull String name, @NotNull String value, @Nullable String signature) {
        this.name = name;
        this.value = value;
        this.signature = signature;
    }

    public @NotNull String getName() {
        return this.name;
    }

    public @NotNull String getValue() {
        return this.value;
    }

    public Optional<String> getSignature() {
        return Optional.ofNullable(this.signature);
    }
}
