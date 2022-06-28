package org.absorb.net.processor.play.entity.player.inventory.close;

import org.absorb.net.Client;
import org.absorb.net.packet.play.incoming.client.inventory.close.IncomingCloseInventoryPacket;
import org.absorb.net.processor.NetProcess;

import java.io.IOException;

public class InventoryCloseProcessor implements NetProcess<IncomingCloseInventoryPacket> {
    @Override
    public void onProcess(Client connection, IncomingCloseInventoryPacket packet) throws IOException {
        connection.requestInventoryClose(false);
    }
}
