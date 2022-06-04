package org.absorb.message;

import org.absorb.utils.Identifiable;
import org.absorb.utils.NetworkIdentifiable;
import org.jetbrains.annotations.NotNull;

public enum MessagePosition implements NetworkIdentifiable {

    CHAT("Chat", "chat", 0),
    SYSTEM("System Message", "system", 1),
    INFO("Game info", "game_info", 2);

    private final String name;
    private final String key;
    private final int networkId;

    MessagePosition(@NotNull String name, @NotNull String key, int networkId){
        this.key = key;
        this.name = name;
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
        return Identifiable.MINECRAFT_HOST;
    }

    @Override
    public int getNetworkId() {
        return this.networkId;
    }
}
