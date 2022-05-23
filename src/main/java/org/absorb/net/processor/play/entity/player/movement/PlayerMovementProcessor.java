package org.absorb.net.processor.play.entity.player.movement;

import net.kyori.adventure.text.Component;
import org.absorb.net.Client;
import org.absorb.net.PlayingState;
import org.absorb.net.packet.play.disconnect.OutgoingCloseConnectionPacketBuilder;
import org.absorb.net.packet.play.entity.player.movement.incoming.IncomingPlayerMovementPacket;
import org.absorb.net.packet.play.entity.player.movement.outgoing.OutgoingPlayerMovementPacketBuilder;
import org.absorb.net.processor.NetProcess;
import org.spongepowered.math.vector.Vector3d;

import java.io.IOException;

public class PlayerMovementProcessor implements NetProcess<IncomingPlayerMovementPacket> {
    @Override
    public void onProcess(Client connection, IncomingPlayerMovementPacket packet) throws IOException {
        if (connection.getPlayingState()==PlayingState.LOGIN_PRE_DATA) {
            connection.setPlayingState(PlayingState.LOGIN_END_DATA);
            int id = connection.newTeleportId();
            connection.registerTeleportId(id);
            new OutgoingPlayerMovementPacketBuilder().setPosition(connection.getLocation()).setTeleportId(id).build().writeTo(connection);
            return;
        }
        if (connection.getPlayingState()==PlayingState.AWAITING) {
            return;
        }
        if (connection.getPlayingState()==PlayingState.LOGIN_END_DATA) {
            connection.setPlayingState(PlayingState.PLAYING);
            connection.setLocation(packet.getPosition());
            return;
        }
        if (connection.getPlayingState()!=PlayingState.PLAYING) {
            throw new IOException("Unknown playing state of " + connection.getPlayingState().name());
        }

        Vector3d previous = connection.getLocation();
        Vector3d next = packet.getPosition();
        double distance = previous.distanceSquared(next);
        if (distance > 100) {
            new OutgoingCloseConnectionPacketBuilder()
                    .setUsingPlay(true)
                    .setMessage(Component.text("moved to quickly: " + distance))
                    .build()
                    .writeToAsync(connection);
            return;
        }
        connection.setLocation(packet.getPosition());
    }
}
