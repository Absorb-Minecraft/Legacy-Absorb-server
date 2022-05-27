package org.absorb.files.json;

import org.absorb.utils.lamda.ThrowableBiConsumer;
import org.absorb.utils.lamda.ThrowableFunction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.serialize.SerializationException;

import java.util.Optional;

public class SimpleNode<T> implements Node<T> {

    private final Object[] node;
    private final boolean isRequired;
    private final ThrowableFunction<? super ConfigurationNode, ? extends T, ? extends SerializationException> from;
    private final ThrowableBiConsumer<? super ConfigurationNode, ? super T, ? extends SerializationException> to;

    public SimpleNode(boolean isRequired, ThrowableFunction<? super ConfigurationNode, ? extends T, ? extends SerializationException> function,
                      ThrowableBiConsumer<? super ConfigurationNode, ? super T, ? extends SerializationException> consumer, Object... node){
        this.from = function;
        this.to = consumer;
        this.node = node;
        this.isRequired = isRequired;
    }

    @Override
    public @NotNull Object[] getNodePath() {
        return this.node;
    }

    @Override
    public Optional<T> getValue(@NotNull ConfigurationNode node) throws SerializationException {
        return Optional.ofNullable(this.from.apply(node.node(this.node)));
    }

    @Override
    public void setValue(@NotNull ConfigurationNode node, @Nullable T value) throws SerializationException {
        if (value==null) {
            node.node(this.node).set(null);
            return;
        }
        this.to.apply(node.node(this.node), value);
    }

    @Override
    public boolean isRequired() {
        return this.isRequired;
    }

    public static SimpleNode<Boolean> asBoolean(boolean isRequired, Object... node){
        return new SimpleNode<>(isRequired, ConfigurationNode::getBoolean, ConfigurationNode::set, node);
    }

    public static SimpleNode<Integer> asInteger(boolean isRequired, Object... node){
        return new SimpleNode<>(isRequired, ConfigurationNode::getInt, ConfigurationNode::set, node);
    }

    public static SimpleNode<String> asString(boolean isRequired, Object... node){
        return new SimpleNode<>(isRequired, ConfigurationNode::getString, ConfigurationNode::set, node);
    }


}
