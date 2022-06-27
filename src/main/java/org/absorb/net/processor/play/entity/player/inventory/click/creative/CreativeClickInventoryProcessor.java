package org.absorb.net.processor.play.entity.player.inventory.click.creative;

import org.absorb.net.Client;
import org.absorb.net.packet.play.client.inventory.creative.IncomingCreativeInventoryClickPacket;
import org.absorb.net.processor.NetProcess;

import java.io.IOException;

public class CreativeClickInventoryProcessor implements NetProcess<IncomingCreativeInventoryClickPacket> {
    @Override
    public void onProcess(Client connection, IncomingCreativeInventoryClickPacket packet) throws IOException {
        System.out.println("Clicked: " + packet.getInventorySlot() +
                " | " + packet.getItem().getItem().map(item -> item.getType().getResourceKey().asFormatted()));
    }
}
