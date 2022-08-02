package org.absorb.entity.living.human.tab;

import net.kyori.adventure.text.Component;
import org.absorb.entity.living.human.Gamemode;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.UUID;

public class PlayerTabBuilder implements Builder<PlayerTab> {

    private final Collection<PlayerTabProperty> properties = new HashSet<>();
    private UUID uuid;
    private String name;
    private Gamemode gameMode;
    private int ping;
    private Component displayName;
    private Long timestamp;
    private byte[] publicKey = new byte[0];
    private byte[] sig = new byte[0];

    public Long getTimestamp() {
        return this.timestamp;
    }

    public PlayerTabBuilder setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public byte[] getPublicKey() {
        return this.publicKey;
    }

    public PlayerTabBuilder setPublicKey(byte[] publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    public byte[] getSignature() {
        return this.sig;
    }

    public PlayerTabBuilder setSignature(byte[] sig) {
        this.sig = sig;
        return this;
    }

    public Collection<PlayerTabProperty> getProperties() {
        return Collections.unmodifiableCollection(this.properties);
    }

    public void addProperty(PlayerTabProperty player) {
        this.properties.add(player);
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public PlayerTabBuilder setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public PlayerTabBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Gamemode getGameMode() {
        return this.gameMode;
    }

    public PlayerTabBuilder setGameMode(Gamemode gameMode) {
        this.gameMode = gameMode;
        return this;
    }

    public int getPing() {
        return this.ping;
    }

    public PlayerTabBuilder setPing(int ping) {
        this.ping = ping;
        return this;
    }

    public Component getDisplayName() {
        return this.displayName;
    }

    public PlayerTabBuilder setDisplayName(Component displayName) {
        this.displayName = displayName;
        return this;
    }


    @Override
    public @NotNull PlayerTab build() {
        return new PlayerTab(this);
    }

    @Override
    public @NotNull Builder<PlayerTab> reset() {
        this.uuid = null;
        this.name = null;
        this.gameMode = null;
        this.ping = 0;
        this.displayName = null;
        return this;
    }

    @Override
    public @NotNull Builder<PlayerTab> copy() {
        return new PlayerTabBuilder()
                .setDisplayName(this.displayName)
                .setName(this.name)
                .setPing(this.ping)
                .setGameMode(this.gameMode)
                .setUuid(this.uuid);
    }

    @Override
    public @NotNull Builder<PlayerTab> from(PlayerTab value) {
        this.displayName = value.getDisplayName().orElse(null);
        this.name = value.getName();
        this.ping = value.getPing();
        this.gameMode = value.getGameMode();
        this.uuid = value.getUuid();

        return this;
    }
}
