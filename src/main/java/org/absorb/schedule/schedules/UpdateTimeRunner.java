package org.absorb.schedule.schedules;

import org.absorb.AbsorbManagers;
import org.absorb.net.PlayingState;
import org.absorb.net.packet.play.outgoing.world.time.OutgoingTimeUpdatePacketBuilder;
import org.absorb.schedule.Schedule;
import org.absorb.world.AbsorbWorldData;

import java.util.function.Consumer;

public class UpdateTimeRunner implements Consumer<Schedule> {
    @Override
    public void accept(Schedule schedule) {
        AbsorbManagers.getWorldManager().worlds().parallelStream().forEach(world -> {
            AbsorbWorldData worldData = world.getWorldData();
            long worldTime = worldData.getWorldTime() + 20;
            if (worldTime > 24000) {
                worldTime = worldTime - 24000;
            }
            worldData.setWorldTime(worldTime);
        });


        AbsorbManagers.getNetManager().getClients().parallelStream().filter(client -> client.getPlayingState()==PlayingState.PLAYING).forEach(client -> {
            new OutgoingTimeUpdatePacketBuilder().setWorld(client.getEntity().getWorld().getWorldData()).build().writeToAsync(client);
        });
    }
}
