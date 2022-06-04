package org.absorb.schedule;

import org.absorb.Main;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.concurrent.LinkedTransferQueue;

public class ScheduleManager {

    private final Collection<Schedule> schedules = new LinkedTransferQueue<>();

    public void register(@NotNull Schedule schedule) {
        this.schedules.add(schedule);
    }

    public void unregister(@NotNull Schedule schedule) {
        this.schedules.remove(schedule);
    }

    public void runSchedulers() {
        new Thread(() -> {
            while (Main.IS_RUNNING) {
                this.schedules.parallelStream().forEach(schedule -> {
                    LocalDateTime now = LocalDateTime.now();
                    LocalDateTime scheduleTime = schedule.getTime();

                    if (now.isBefore(scheduleTime)) {
                        return;
                    }
                    if (!schedule.isAllowingParallelRuns() && schedule.isRunning()) {
                        return;
                    }
                    if (!schedule.isRepeating() && schedule.getLastRan().isPresent()) {
                        return;
                    }
                    schedule.startNew();
                });
            }
        }).start();
    }

}
