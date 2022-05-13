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

    @NotNull EntityType getType();

    Optional<Component> getCustomName();

    void setCustomName(@Nullable Component component);

    default void removeCustomName() {
        this.setCustomName(null);
    }

}
