package org.absorb.files.json;

import org.jetbrains.annotations.NotNull;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.serialize.SerializationException;

import java.util.Optional;

public interface DefaultNode<T> extends Node<T> {

    T getDefaultValue();

    default T getValueOrElse(@NotNull ConfigurationNode node) {
        ConfigurationNode nodePath = node.node(this.getNodePath());
        if (nodePath.empty() || (nodePath.isNull() && !this.isAllowedNulls())) {
            return this.getDefaultValue();
        }
        try {
            Optional<T> opValue = this.getValue(node);
            if (opValue.isPresent()) {
                return opValue.get();
            }
            return this.getDefaultValue();
        } catch (SerializationException e) {
            return this.getDefaultValue();
        }
    }

    default void setDefault(@NotNull ConfigurationNode node) throws SerializationException {
        this.setValue(node, this.getDefaultValue());
    }

    @Override
    default boolean isRequired() {
        return false;
    }
}
