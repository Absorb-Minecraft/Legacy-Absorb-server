package org.absorb.schedule.schedules;

import org.absorb.AbsorbManagers;
import org.absorb.net.PlayingState;
import org.absorb.net.packet.play.outgoing.client.keep.alive.OutgoingKeepAlivePacketBuilder;
import org.absorb.schedule.Schedule;

import java.util.function.Consumer;

public class KeepAliveRunner implements Consumer<Schedule> {
    @Override
    public void accept(Schedule schedule) {
        AbsorbManagers.getNetManager().getClients().parallelStream().filter(client -> {
            PlayingState state = client.getPlayingState();
            return state == PlayingState.PLAYING;
        }).forEach(client -> {
            new OutgoingKeepAlivePacketBuilder().setGeneratedId(client.getKeepAliveId()).build().writeToAsync(client);
        });
    }
}
