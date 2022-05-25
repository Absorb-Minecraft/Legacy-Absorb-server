package org.absorb.threaded;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

public interface ThreadedDataPoint<T, O> extends Comparable<ThreadedDataPoint<T, O>> {

    T getIdentifier();

    O getValue();

    LocalDateTime getTime();

    default boolean isNewer(@NotNull ThreadedDataPoint<T, O> point) {
        return this.compareTo(point) > 0;
    }

    @Override
    default int compareTo(@NotNull ThreadedDataPoint<T, O> o) {
        return this.getTime().compareTo(o.getTime());
    }
}
