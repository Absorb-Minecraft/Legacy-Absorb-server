package org.absorb.entity.living.human;

import org.absorb.utils.NetworkIdentifiable;
import org.jetbrains.annotations.NotNull;

public class Gamemode implements NetworkIdentifiable {

    private final @NotNull String name;
    private final @NotNull String key;
    private final @NotNull String host;
    private final int networkId;


    Gamemode(int networkId, @NotNull String host, @NotNull String key, @NotNull String name) {
        this.name = name;
        this.key = key;
        this.host = host;
        this.networkId = networkId;
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

    @Override
    public int getNetworkId() {
        return this.networkId;
    }
}
