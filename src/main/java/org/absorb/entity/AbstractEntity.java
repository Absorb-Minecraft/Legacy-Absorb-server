package org.absorb.entity;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.LinkedTransferQueue;

public class AbstractEntity implements Entity {

    private final @NotNull EntityType<?> type;
    private final Collection<EntityEffect<?>> effects = new LinkedTransferQueue<>();
    private boolean hasSpawned;
    private boolean isOnFire;
    private boolean isGlowing;
    private @Nullable Component customName;
    private boolean isFlying;
    private boolean hasGravity;

    public AbstractEntity(@NotNull EntityType<?> type) {
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
    public void setGravity(boolean gravity) {
        this.hasGravity = gravity;
    }

    @Override
    public boolean hasGravity() {
        return this.hasGravity;
    }

    @Override
    public boolean isFlying() {
        return this.isFlying;
    }

    @Override
    public void setFlying(boolean isFlying) {
        this.isFlying = isFlying;
    }

    @Override
    public @NotNull EntityType<?> getType() {
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

    @Override
    public boolean isOnFire() {
        return this.isOnFire;
    }

    @Override
    public void setOnFire(boolean check) {
        this.isOnFire = check;
    }

    @Override
    public boolean isGlowing() {
        return this.isGlowing;
    }

    @Override
    public void setGlowing(boolean glowing) {
        this.isGlowing = glowing;
    }
}
