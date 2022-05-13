package org.absorb.net.processor.status.request;

import org.absorb.net.Client;
import org.absorb.net.packet.status.request.IncomingStatusRequestPacket;
import org.absorb.net.packet.status.response.StatusResponsePacketBuilder;
import org.absorb.net.processor.NetProcess;

public class StatusRequestProcess implements NetProcess<IncomingStatusRequestPacket> {

    @Override
    public void onProcess(Client info, IncomingStatusRequestPacket packet) {
        new StatusResponsePacketBuilder().build().sendAsync(info);
    }
}
