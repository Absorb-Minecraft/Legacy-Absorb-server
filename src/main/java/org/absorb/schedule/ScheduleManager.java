package org.absorb.schedule;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.concurrent.LinkedTransferQueue;

public class ScheduleManager {

    private Collection<Schedule> schedules = new LinkedTransferQueue<>();

    public void register(@NotNull Schedule schedule){
        this.schedules.add(schedule);
    }

}
