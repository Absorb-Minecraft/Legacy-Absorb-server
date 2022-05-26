package org.absorb.schedule;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.function.Consumer;

public class Schedule {

    private LocalDateTime shouldRun;
    private Duration next;
    private int isRunning;
    private boolean allowedParallelRun;
    private Consumer<Schedule> taskToRun;
    private boolean repeating;

    public Schedule(ScheduleBuilder builder){
        this.shouldRun = builder.getShouldRun();
        this.allowedParallelRun = builder.isAllowedParallelRun();
        this.taskToRun = builder.getTaskToRun();
        this.repeating = builder.isRepeating();
    }

    public Thread startNew() {
        Thread thread = new Thread(() -> {
            this.isRunning++;
            this.shouldRun = this.shouldRun.plus(this.next);
            this.taskToRun.accept(this);
            this.isRunning--;
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
        return this.isRunning!=0;
    }

    public LocalDateTime getTime() {
        return this.shouldRun;
    }


}
