package org.absorb.utils;

import org.absorb.threaded.SimpleDataPoint;
import org.absorb.threaded.ThreadedDataPoint;
import org.jetbrains.annotations.NotNull;

public class Transaction<T> {

    private final @NotNull T original;
    private final @NotNull T newValue;
    private @NotNull ThreadedDataPoint<T, T> overrideValue;

    public Transaction(@NotNull T original, @NotNull T newValue) {
        this.newValue = newValue;
        this.original = original;
        this.overrideValue = new SimpleDataPoint<>(newValue);
    }

    public T getOriginal() {
        return this.original;
    }

    public T getOriginallyBecoming() {
        return this.newValue;
    }

    public T getBecoming() {
        return this.overrideValue.getValue();
    }

    public void setBecoming(@NotNull T value) {
        SimpleDataPoint<T, T> newValue = new SimpleDataPoint<>(value);
        if (newValue.isNewer(this.overrideValue)) {
            this.overrideValue = newValue;
        }
    }
}
