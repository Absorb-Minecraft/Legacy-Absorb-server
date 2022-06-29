package org.absorb.schedule.schedules;

import org.absorb.AbsorbManagers;
import org.absorb.schedule.Schedule;
import org.absorb.schedule.ScheduleBuilder;

import java.time.Duration;

public interface Schedules {

    /*Schedule PING_PLAYER =
            new ScheduleBuilder().setRepeating(true).setAllowedParallelRun(false).setNext(Duration.ofMillis(1L))
            .setTaskToRun(new PingPlayerRunner()).build();*/

    Schedule UPDATE_PLAYER_TIME = new ScheduleBuilder()
            .setRepeating(true)
            .setAllowedParallelRun(false)
            .setNext(Duration.ofNanos(AbsorbManagers.getProperties().getNanoPerTick()))
            .setTaskToRun(new UpdateTimeRunner())
            .build();
}
