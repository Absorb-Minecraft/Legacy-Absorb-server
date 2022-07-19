package org.absorb.net.processor.play.entity.player.screen.inventory.hotbar.cooldown;

import org.absorb.net.Client;
import org.absorb.net.packet.play.incoming.client.screen.inventory.hotbar.cooldown.IncomingItemCooldownPacket;
import org.absorb.net.processor.NetProcess;

import java.io.IOException;

public class ItemCooldownProcessor implements NetProcess<IncomingItemCooldownPacket> {
    @Override
    public void onProcess(Client connection, IncomingItemCooldownPacket packet) throws IOException {
        System.out.println("ItemCooldown ItemId: " + packet.getItemId());
    }
}
