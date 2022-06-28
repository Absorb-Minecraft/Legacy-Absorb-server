package org.absorb.net.processor.play.teleport.confirm;

import org.absorb.net.Client;
import org.absorb.net.packet.play.incoming.client.movement.teleport.confirm.IncomingTeleportConfirmPacket;
import org.absorb.net.processor.NetProcess;

public class TeleportConfirmProcessor implements NetProcess<IncomingTeleportConfirmPacket> {
    @Override
    public void onProcess(Client connection, IncomingTeleportConfirmPacket packet) {
        connection.confirmTeleport(packet.getTeleportId());
    }
}
