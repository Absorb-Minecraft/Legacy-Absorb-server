package org.absorb.event.annotations.cause;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class WhenData {

    private final int index;
    private final @Nullable String key;
    private final @NotNull Class<?> type;
    private final @NotNull CauseType causeType;


    public WhenData(int index, @NotNull Class<?> type, @NotNull CauseType causeType, @Nullable String key) {
        this.index = index;
        this.type = type;
        this.key = key;
        this.causeType = causeType;
    }

    public CauseType getCauseType() {
        return this.causeType;
    }

    public int getMethodIndex() {
        return this.index;
    }

    public @NotNull Optional<String> getTriggerKey() {
        return Optional.ofNullable(this.key);
    }

    public @NotNull Class<?> getType() {
        return this.type;
    }
}
