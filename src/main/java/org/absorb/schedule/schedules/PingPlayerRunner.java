package org.absorb.schedule.schedules;

import org.absorb.AbsorbManagers;
import org.absorb.net.packet.status.pong.OutgoingPongPacketBuilder;
import org.absorb.schedule.Schedule;

import java.util.function.Consumer;

public class PingPlayerRunner implements Consumer<Schedule> {
    @Override
    public void accept(Schedule schedule) {
        AbsorbManagers.getNetManager().getClients().parallelStream().forEach(client -> {
            int id = client.getPingId();

            new OutgoingPongPacketBuilder().setUsePlay(true).setPayload(id).build().writeToAsync(client);
            client.addPingId(id);

        });
    }
}
