package org.absorb.files.json;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.serialize.SerializationException;

import java.util.Optional;

public interface Node<T> {

    @NotNull Object[] getNodePath();

    Optional<T> getValue(@NotNull ConfigurationNode node) throws SerializationException;

    void setValue(@NotNull ConfigurationNode node, @Nullable T value) throws SerializationException;

    boolean isRequired();


}
