package org.absorb.schedule;

import org.absorb.AbsorbManagers;
import org.absorb.Main;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

public class ScheduleManager {

    private final Collection<Schedule> schedules = new LinkedTransferQueue<>();

    public void register(@NotNull Schedule schedule) {
        this.schedules.add(schedule);
    }

    public void unregister(@NotNull Schedule schedule) {
        this.schedules.remove(schedule);
    }

    public void runSchedulers() {
        long nanoTick = AbsorbManagers.getProperties().getNanoPerTick();
        long millis = TimeUnit.NANOSECONDS.toMillis(nanoTick);
        new Thread(() -> {
            while (Main.IS_RUNNING) {
                try {
                    Thread.sleep(millis);
                } catch (InterruptedException ignored) {

                }
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
