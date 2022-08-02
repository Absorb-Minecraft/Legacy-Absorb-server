package org.absorb.net.processor.play.entity;

import org.absorb.net.Client;
import org.absorb.net.packet.play.incoming.client.query.entity.IncomingEntityQueryPacket;
import org.absorb.net.processor.NetProcess;

import java.io.IOException;

public class EntityQueryProcessor implements NetProcess<IncomingEntityQueryPacket> {
    @Override
    public void onProcess(Client connection, IncomingEntityQueryPacket packet) throws IOException {

    }
}
