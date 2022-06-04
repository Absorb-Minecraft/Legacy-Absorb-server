package org.absorb.utils;

import org.absorb.register.AbsorbKey;
import org.jetbrains.annotations.NotNull;

public interface Identifiable {

    String MINECRAFT_HOST = "minecraft";
    String ABSORB_HOST = "absorb";
    String BRIGADIER_HOST = "brigadier";

    @NotNull String getName();

    @NotNull String getKey();

    @NotNull String getHost();

    default AbsorbKey getResourceKey() {
        return new AbsorbKey(this.getHost(), this.getKey());
    }
}
