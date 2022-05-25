package org.absorb.event.cause;

import org.jetbrains.annotations.NotNull;

public class CauseEntry<T> {

    private final @NotNull T value;
    private final @NotNull CauseContextKey reason;

    public CauseEntry(@NotNull CauseContextKey reason, @NotNull T value) {
        this.reason = reason;
        this.value = value;
    }

    public @NotNull T getValue() {
        return this.value;
    }

    public @NotNull CauseContextKey getReason() {
        return this.reason;
    }
}
