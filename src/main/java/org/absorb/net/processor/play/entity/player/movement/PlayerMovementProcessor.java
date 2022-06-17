package org.absorb.net.processor.play.entity.player.movement;

import org.absorb.net.Client;
import org.absorb.net.PlayingState;
import org.absorb.net.packet.play.entity.player.movement.incoming.IncomingPlayerMovementPacket;
import org.absorb.net.packet.play.entity.player.movement.outgoing.OutgoingPlayerMovementPacketBuilder;
import org.absorb.net.processor.NetProcess;
import org.absorb.world.location.Location;
import org.spongepowered.math.vector.Vector2i;
import org.spongepowered.math.vector.Vector3d;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

public class PlayerMovementProcessor implements NetProcess<IncomingPlayerMovementPacket> {
    @Override
    public void onProcess(Client connection, IncomingPlayerMovementPacket packet) throws IOException {
        if (connection.getPlayingState()==PlayingState.LOGIN_PRE_DATA) {
            connection.setPlayingState(PlayingState.LOGIN_END_DATA);
            int id = connection.newTeleportId();
            connection.registerTeleportId(id);
            new OutgoingPlayerMovementPacketBuilder().setPosition(connection.getEntity().getPosition()).setTeleportId(id).build().writeTo(connection);
            return;
        }
        if (connection.getPlayingState()==PlayingState.AWAITING) {
            return;
        }
        if (connection.getPlayingState()==PlayingState.LOGIN_END_DATA) {
            connection.setPlayingState(PlayingState.PLAYING);
            connection.getEntity().setPosition(packet.getPosition());
            return;
        }
        if (connection.getPlayingState()!=PlayingState.PLAYING) {
            throw new IOException("Unknown playing state of " + connection.getPlayingState().name());
        }

        Location previousLoc = connection.getEntity().getLocation();
        Vector3d previous = previousLoc.getPosition();
        Vector3d next = packet.getPosition();
        Location nextLoc = new Location(previousLoc.getWorld(), next);
        double distance = previous.distanceSquared(next);
        if (distance > 100) {
            /*new OutgoingCloseConnectionPacketBuilder()
                    .setUsingPlay(true)
                    .setMessage(Component.text("moved to quickly: " + distance))
                    .build()
                    .writeToAsync(connection);*/
            return;
        }

        Collection<Vector2i> oldChunks = connection.getViewingChunks();

        connection.getEntity().setPosition(next);

        if (previousLoc.getChunkPosition().equals(nextLoc.getChunkPosition())) {
            return;
        }
        Collection<Vector2i> newChunks = connection.getViewingChunks();
        Collection<Vector2i> genChunks = new HashSet<>(newChunks);
        Collection<Vector2i> commonChunks = new HashSet<>(newChunks);
        commonChunks.retainAll(oldChunks);
        genChunks.removeAll(commonChunks);

        connection.updateChunks(genChunks);


    }
}
