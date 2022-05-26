package org.absorb.schedule;

import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.function.Consumer;

public class ScheduleBuilder implements Builder<Schedule> {

    private LocalDateTime shouldRun;
    private boolean allowedParallelRun;
    private Consumer<Schedule> taskToRun;
    private boolean repeating;
    private Duration next;

    public Duration getNext() {
        return this.next;
    }

    public ScheduleBuilder setNext(@Nullable Duration next) {
        this.next = next;
        return this;
    }

    public LocalDateTime getShouldRun() {
        return this.shouldRun;
    }

    public ScheduleBuilder setShouldRun(@NotNull LocalDateTime shouldRun) {
        this.shouldRun = shouldRun;
        return this;
    }

    public boolean isAllowedParallelRun() {
        return this.allowedParallelRun;
    }

    public ScheduleBuilder setAllowedParallelRun(boolean allowedParallelRun) {
        this.allowedParallelRun = allowedParallelRun;
        return this;
    }

    public Consumer<Schedule> getTaskToRun() {
        return this.taskToRun;
    }

    public ScheduleBuilder setTaskToRun(Consumer<Schedule> taskToRun) {
        this.taskToRun = taskToRun;
        return this;
    }

    public boolean isRepeating() {
        return this.repeating;
    }

    public ScheduleBuilder setRepeating(boolean repeating) {
        this.repeating = repeating;
        return this;
    }

    @Override
    public @NotNull Schedule build() {
        return new Schedule(this);
    }

    @Override
    public @NotNull Builder<Schedule> reset() {
        this.shouldRun = null;
        this.allowedParallelRun = false;
        this.repeating = false;
        this.taskToRun = null;
        return this;
    }

    @Override
    public @NotNull Builder<Schedule> copy() {
        return new ScheduleBuilder().setRepeating(this.repeating).setAllowedParallelRun(this.allowedParallelRun).setTaskToRun(this.taskToRun).setShouldRun(this.shouldRun);
    }
}
