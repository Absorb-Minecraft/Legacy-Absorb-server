package org.absorb.utils;

import org.jetbrains.annotations.NotNull;

public interface Builder<T> {

    @NotNull T build();

    @NotNull Builder<T> reset();

    @NotNull Builder<T> copy();

    @NotNull Builder<T> from(T value);
}
