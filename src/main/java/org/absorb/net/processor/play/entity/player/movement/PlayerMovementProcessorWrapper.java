package org.absorb.net.processor.play.entity.player.movement;

import org.absorb.net.Client;
import org.absorb.net.packet.play.entity.player.movement.incoming.IncomingPlayerMovementPacket;
import org.absorb.net.packet.play.entity.player.movement.incoming.IncomingPlayerMovementPacketBuilder;
import org.absorb.net.packet.play.entity.player.movement.incoming.basic.IncomingBasicPlayerMovementPacket;
import org.absorb.net.processor.NetProcess;

import java.io.IOException;

public class PlayerMovementProcessorWrapper implements NetProcess<IncomingBasicPlayerMovementPacket> {

    private final PlayerMovementProcessor processor = new PlayerMovementProcessor();

    @Override
    public void onProcess(Client connection, IncomingBasicPlayerMovementPacket packet) throws IOException {
        IncomingPlayerMovementPacket packetWrapper = new IncomingPlayerMovementPacketBuilder()
                .setY(packet.getY())
                .setX(packet.getX())
                .setZ(packet.getZ())
                .build();


        this.processor.onProcess(connection, packetWrapper);
    }
}
