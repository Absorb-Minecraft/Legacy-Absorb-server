package org.absorb.schedule;

import org.absorb.AbsorbManagers;
import org.absorb.register.Typed;
import org.absorb.schedule.schedules.Schedules;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Consumer;

@Typed(getTypesClass = Schedules.class)
public class Schedule {

    private final @Nullable Duration next;
    private final boolean allowedParallelRun;
    private final @NotNull Consumer<Schedule> taskToRun;
    private final boolean repeating;
    private @NotNull LocalDateTime shouldRun;
    private @Nullable LocalDateTime lastRan;
    private int isRunning;

    public Schedule(ScheduleBuilder builder) {
        this.shouldRun = builder.getShouldRun();
        this.allowedParallelRun = builder.isAllowedParallelRun();
        this.taskToRun = builder.getTaskToRun();
        this.repeating = builder.isRepeating();
        this.next = builder.getNext();
        if (this.shouldRun == null) {
            this.shouldRun = LocalDateTime.now();
        }
        if (this.taskToRun == null) {
            throw new RuntimeException(".setTaskToRun(Consumer<Schedule>) is missing");
        }
    }

    public Optional<LocalDateTime> getLastRan() {
        return Optional.ofNullable(this.lastRan);
    }

    public synchronized Thread startNew() {
        this.lastRan = LocalDateTime.now();
        this.setRunning(1);
        Thread thread = new Thread(() -> {
            if (this.next != null) {
                this.shouldRun = this.shouldRun.plus(this.next);
            }
            try {
                this.taskToRun.accept(this);
                if (!this.isRepeating()) {
                    AbsorbManagers.getScheduleManager().unregister(this);
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
            this.setRunning(-1);
        });
        thread.start();
        return thread;
    }

    public boolean isRepeating() {
        return this.repeating;
    }

    public boolean isAllowingParallelRuns() {
        return this.allowedParallelRun;
    }

    public boolean isRunning() {
        return this.isRunning != 0;
    }

    private synchronized void setRunning(int i) {
        this.isRunning = this.isRunning + i;
    }

    public LocalDateTime getTime() {
        return this.shouldRun;
    }


}
