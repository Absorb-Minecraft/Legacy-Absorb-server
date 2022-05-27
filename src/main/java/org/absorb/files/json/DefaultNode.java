package org.absorb.files.json;

import org.jetbrains.annotations.NotNull;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.serialize.SerializationException;

public interface DefaultNode<T> extends Node<T> {

    T getDefaultValue();

    default T getValueOrElse(@NotNull ConfigurationNode node) throws SerializationException {
        return this.getValue(node).orElseGet(this::getDefaultValue);
    }

    default void setDefault(@NotNull ConfigurationNode node) throws SerializationException {
        this.setValue(node, this.getDefaultValue());
    }

    @Override
    default boolean isRequired() {
        return false;
    }
}
