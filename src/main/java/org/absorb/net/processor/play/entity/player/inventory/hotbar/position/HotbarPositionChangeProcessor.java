package org.absorb.net.processor.play.entity.player.inventory.hotbar.position;

import org.absorb.net.Client;
import org.absorb.net.packet.play.incoming.client.inventory.hotbar.selected.IncomingHotbarChangePacket;
import org.absorb.net.processor.NetProcess;

import java.io.IOException;

public class HotbarPositionChangeProcessor implements NetProcess<IncomingHotbarChangePacket> {
    @Override
    public void onProcess(Client connection, IncomingHotbarChangePacket packet) throws IOException {
        connection.getInventory().getHotbar().setSelected(packet.getNewPosition());
    }
}
