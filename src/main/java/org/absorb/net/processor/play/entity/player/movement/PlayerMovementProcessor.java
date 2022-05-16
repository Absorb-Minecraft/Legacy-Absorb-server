package org.absorb.net.processor.play.entity.player.movement;

import org.absorb.net.Client;
import org.absorb.net.packet.play.entity.player.movement.incoming.IncomingPlayerMovementPacket;
import org.absorb.net.processor.NetProcess;

import java.io.IOException;

public class PlayerMovementProcessor implements NetProcess<IncomingPlayerMovementPacket> {
    @Override
    public void onProcess(Client connection, IncomingPlayerMovementPacket packet) throws IOException {

    }
}
