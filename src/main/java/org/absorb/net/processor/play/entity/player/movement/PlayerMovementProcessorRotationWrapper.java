package org.absorb.net.processor.play.entity.player.movement;

import org.absorb.net.Client;
import org.absorb.net.packet.play.incoming.client.movement.IncomingPlayerMovementPacket;
import org.absorb.net.packet.play.incoming.client.movement.IncomingPlayerMovementPacketBuilder;
import org.absorb.net.packet.play.incoming.client.movement.rotation.IncomingRotationPacket;
import org.absorb.net.processor.NetProcess;
import org.spongepowered.math.vector.Vector3d;

import java.io.IOException;

public class PlayerMovementProcessorRotationWrapper implements NetProcess<IncomingRotationPacket> {

    private final PlayerMovementProcessor processor = new PlayerMovementProcessor();

    @Override
    public void onProcess(Client connection, IncomingRotationPacket packet) throws IOException {
        Vector3d position = connection.getEntity().getPosition();
        IncomingPlayerMovementPacket packetWrapper = new IncomingPlayerMovementPacketBuilder()
                .setPosition(position)
                .setPitch(packet.getPitch())
                .setYaw(packet.getYaw())
                .build();
        this.processor.onProcess(connection, packetWrapper);
    }
}
