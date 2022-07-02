package org.absorb.net.processor.play.entity;

import org.absorb.net.Client;
import org.absorb.net.packet.play.incoming.client.keep.alive.IncomingKeepAlivePacket;
import org.absorb.net.processor.NetProcess;

import java.io.IOException;

public class KeepAliveProcessor implements NetProcess<IncomingKeepAlivePacket> {
    @Override
    public void onProcess(Client connection, IncomingKeepAlivePacket packet) throws IOException {
        connection.receivedKeepAliveId(packet.getKeepAliveId());
    }
}
