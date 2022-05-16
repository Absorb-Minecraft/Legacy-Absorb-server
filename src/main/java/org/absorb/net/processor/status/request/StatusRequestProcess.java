package org.absorb.net.processor.status.request;

import org.absorb.net.Client;
import org.absorb.net.packet.status.request.IncomingStatusRequestPacket;
import org.absorb.net.packet.status.response.StatusResponsePacketBuilder;
import org.absorb.net.processor.NetProcess;

import java.io.IOException;

public class StatusRequestProcess implements NetProcess<IncomingStatusRequestPacket> {

    @Override
    public void onProcess(Client info, IncomingStatusRequestPacket packet) throws IOException {
        new StatusResponsePacketBuilder().build().writeTo(info);
    }
}
