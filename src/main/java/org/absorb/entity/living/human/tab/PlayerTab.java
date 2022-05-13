package org.absorb.entity.living.human.tab;

import net.kyori.adventure.text.Component;
import org.absorb.entity.living.human.Gamemode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class PlayerTab {

    private final @NotNull UUID uuid;
    private final @NotNull String name;
    private final @NotNull Gamemode gameMode;
    private final int ping;
    private final @Nullable Component displayName;
    private Collection<PlayerTabProperty> properties = new HashSet<>();

    public PlayerTab(@NotNull PlayerTabBuilder builder) {
        this.displayName = builder.getDisplayName();
        this.name = builder.getName();
        this.gameMode = builder.getGameMode();
        this.uuid = builder.getUuid();
        this.ping = builder.getPing();
        this.properties.addAll(builder.getProperties());
    }

    public Collection<PlayerTabProperty> getProperties() {
        return Collections.unmodifiableCollection(this.properties);
    }

    public @NotNull UUID getUuid() {
        return this.uuid;
    }

    public @NotNull String getName() {
        return this.name;
    }

    public @NotNull Gamemode getGameMode() {
        return this.gameMode;
    }

    public int getPing() {
        return this.ping;
    }

    public Optional<Component> getDisplayName() {
        return Optional.ofNullable(this.displayName);
    }
}
