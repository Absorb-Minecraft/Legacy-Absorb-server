package org.absorb.utils;

import org.jetbrains.annotations.NotNull;

public final class Validation {

    private Validation() {
    }

    public static <T> @NotNull T notNull(@NotNull T value) {
        //noinspection ConstantConditions
        if (value==null) {
            throw new RuntimeException("Value cannot be null");
        }
        return value;
    }
}
