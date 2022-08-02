package org.absorb.entity;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Optional;

public interface Entity {

    Collection<EntityEffect<?>> getEffects();

    void addEffect(EntityEffect<?> effect);

    boolean hasSpawned();

    void setGravity(boolean gravity);

    boolean hasGravity();

    boolean isFlying();

    void setFlying(boolean isFlying);

    @NotNull EntityType<? extends Entity> getType();

    Optional<Component> getCustomName();

    void setCustomName(@Nullable Component component);

    boolean isOnFire();

    void setOnFire(boolean check);

    boolean isGlowing();

    void setGlowing(boolean glowing);

    default void removeCustomName() {
        this.setCustomName(null);
    }

}
