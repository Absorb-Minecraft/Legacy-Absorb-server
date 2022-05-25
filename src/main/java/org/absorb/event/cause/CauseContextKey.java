package org.absorb.event.cause;

import org.absorb.register.Typed;
import org.jetbrains.annotations.NotNull;

@Typed(getTypesClass = CauseContextKeys.class)
public class CauseContextKey {

    private final @NotNull String key;

    public CauseContextKey(@NotNull String key) {
        this.key = key;
    }

    public @NotNull String getKey() {
        return this.key;
    }
}
