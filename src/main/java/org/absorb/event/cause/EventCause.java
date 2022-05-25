package org.absorb.event.cause;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class EventCause {

    private final @NotNull Collection<CauseEntry<?>> causeEntries = new LinkedList<>();

    public EventCause(Collection<? extends CauseEntry<?>> collection) {
        this.causeEntries.addAll(collection);
    }

    public List<?> getValues() {
        return this.causeEntries.stream().map(CauseEntry::getValue).toList();
    }

    public List<?> getValues(@NotNull CauseContextKey... keys) {
        return this.causeEntries.stream().filter(entry -> Arrays.stream(keys).anyMatch(key -> entry.getReason().equals(key))).map(CauseEntry::getValue).toList();
    }

    public Optional<?> getFirst(@NotNull CauseContextKey... keys) {
        return this.causeEntries.parallelStream().filter(entry -> Arrays.stream(keys).anyMatch(key -> entry.getReason().equals(key))).findFirst().map(CauseEntry::getValue);
    }
}
