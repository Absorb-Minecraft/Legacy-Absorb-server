package org.absorb.threaded;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.function.Function;

public class SimpleDataPoint<T, O> implements ThreadedDataPoint<T, O> {

    private Function<? super O, ? extends T> to;
    private @NotNull O value;
    private @NotNull LocalDateTime time;

    public SimpleDataPoint(O value) {
        this(value, v -> (T) v);
    }

    public SimpleDataPoint(@NotNull O value, Function<? super O, ? extends T> to) {
        this.time = LocalDateTime.now();
        this.value = value;
        this.to = to;
    }

    @Override
    public T getIdentifier() {
        return this.to.apply(this.value);
    }

    @Override
    public O getValue() {
        return this.value;
    }

    @Override
    public LocalDateTime getTime() {
        return this.time;
    }
}
