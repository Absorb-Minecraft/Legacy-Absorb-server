package org.absorb.inventory.item.data;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class SimpleStackData<V, T> implements StackData<V, T> {

    private final @NotNull StackDataKey<V, T> key;
    private final @Nullable T data;

    public SimpleStackData(@NotNull StackDataKey<V, T> key, @Nullable T data) {
        this.key = key;
        this.data = data;
    }

    @Override
    public @NotNull StackDataKey<V, T> getKey() {
        return this.key;
    }

    @Override
    public Optional<T> get() {
        return Optional.ofNullable(this.data);
    }
}
