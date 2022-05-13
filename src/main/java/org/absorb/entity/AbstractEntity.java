package org.absorb.entity;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.LinkedTransferQueue;

public class AbstractEntity implements Entity {

    private boolean hasSpawned;
    private final @NotNull EntityType type;
    private @Nullable Component customName;
    private final Collection<EntityEffect<?>> effects = new LinkedTransferQueue<>();

    public AbstractEntity(@NotNull EntityType type) {
        this.type = type;
    }

    @Override
    public Collection<EntityEffect<?>> getEffects() {
        return this.effects;
    }

    @Override
    public void addEffect(EntityEffect<?> effect) {
        this.effects.add(effect);
    }

    @Override
    public boolean hasSpawned() {
        return this.hasSpawned;
    }

    @Override
    public @NotNull EntityType getType() {
        return this.type;
    }

    @Override
    public Optional<Component> getCustomName() {
        return Optional.ofNullable(this.customName);
    }

    @Override
    public void setCustomName(@Nullable Component component) {
        this.customName = component;
    }
}
