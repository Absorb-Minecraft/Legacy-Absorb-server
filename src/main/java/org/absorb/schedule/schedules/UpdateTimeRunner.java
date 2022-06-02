package org.absorb.schedule.schedules;

import org.absorb.AbsorbManagers;
import org.absorb.net.PlayingState;
import org.absorb.net.packet.play.entity.player.world.time.OutgoingTimeUpdatePacketBuilder;
import org.absorb.net.packet.status.pong.OutgoingPongPacketBuilder;
import org.absorb.schedule.Schedule;

import java.io.IOException;
import java.util.Comparator;
import java.util.function.Consumer;

public class UpdateTimeRunner implements Consumer<Schedule> {
    @Override
    public void accept(Schedule schedule) {
        AbsorbManagers.getNetManager().getClients().parallelStream().filter(client -> client.getPlayingState() == PlayingState.PLAYING).forEach(client -> {
            new OutgoingTimeUpdatePacketBuilder().setWorld(client.getEntity().getWorld().getWorldData()).build().writeToAsync(client);
        });
    }
}
