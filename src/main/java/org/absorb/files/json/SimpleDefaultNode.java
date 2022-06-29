package org.absorb.files.json;

import org.absorb.utils.lamda.ThrowableBiConsumer;
import org.absorb.utils.lamda.ThrowableFunction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.serialize.SerializationException;

import java.util.Optional;
import java.util.function.Supplier;

public class SimpleDefaultNode<T> implements DefaultNode<T>, CommentedNode<T> {

    private final Supplier<T> defaultValue;
    private final Class<T> clazz;
    private final String comment;
    private final Object[] nodePath;
    private final ThrowableFunction<? super ConfigurationNode, ? extends T, ? extends SerializationException> from;
    private final ThrowableBiConsumer<? super ConfigurationNode, ? super T, ? extends SerializationException> to;

    public SimpleDefaultNode(String comment, Class<T> clazz,
                             ThrowableFunction<? super ConfigurationNode, ? extends T, ? extends SerializationException> from,
                             ThrowableBiConsumer<? super ConfigurationNode, ? super T, ? extends SerializationException> to,
                             T defaultValue, Object... nodePath) {
        this(comment, clazz, from, to, () -> defaultValue, nodePath);
    }

    public SimpleDefaultNode(String comment, Class<T> clazz,
                             ThrowableFunction<? super ConfigurationNode, ? extends T, ? extends SerializationException> from,
                             ThrowableBiConsumer<? super ConfigurationNode, ? super T, ? extends SerializationException> to,
                             Supplier<T> defaultValue, Object... nodePath) {
        this.defaultValue = defaultValue;
        this.to = to;
        this.from = from;
        this.clazz = clazz;
        this.nodePath = nodePath;
        this.comment = comment;
    }

    @Override
    public T getDefaultValue() {
        return this.defaultValue.get();
    }

    @Override
    public @NotNull Class<T> getTypeClass() {
        return this.clazz;
    }

    @Override
    public @NotNull Object[] getNodePath() {
        return this.nodePath;
    }

    @Override
    public Optional<T> getValue(@NotNull ConfigurationNode node) throws SerializationException {
        return Optional.ofNullable(this.from.apply(node.node(this.getNodePath())));
    }

    @Override
    public void setValue(@NotNull ConfigurationNode node, @Nullable T value) throws SerializationException {
        this.to.apply(node.node(this.getNodePath()), value);
    }

    @Override
    public String getComment() {
        return this.comment;
    }

    public static SimpleDefaultNode<Boolean> asBoolean(String comment, boolean defaultValue, Object... node) {
        return new SimpleDefaultNode<>(comment,
                                       boolean.class,
                                       value -> value.getBoolean(defaultValue),
                                       ConfigurationNode::set,
                                       defaultValue,
                                       node);
    }

    public static SimpleDefaultNode<Integer> asInt(String comment, int defaultValue, Object... node) {
        return new SimpleDefaultNode<>(comment,
                                       int.class,
                                       value -> value.getInt(defaultValue),
                                       ConfigurationNode::set,
                                       defaultValue,
                                       node);
    }
}
