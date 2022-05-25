package org.absorb.net.processor.status.request;

import org.absorb.AbsorbManagers;
import org.absorb.event.events.connection.ping.ClientPingEvent;
import org.absorb.event.events.connection.ping.ClientPingEventBuilder;
import org.absorb.net.Client;
import org.absorb.net.packet.status.request.IncomingStatusRequestPacket;
import org.absorb.net.packet.status.response.StatusResponsePacketBuilder;
import org.absorb.net.processor.NetProcess;

import java.io.IOException;

public class StatusRequestProcess implements NetProcess<IncomingStatusRequestPacket> {

    @Override
    public void onProcess(Client info, IncomingStatusRequestPacket packet) throws IOException {
        ClientPingEvent event = new ClientPingEventBuilder().setClient(info).build();
        event = AbsorbManagers.getEventManager().callAwaiting(event);
        new StatusResponsePacketBuilder().from(event).build().writeToAsync(info);
    }
}
