package org.absorb.net.processor.play.entity.player.inventory.click.creative;

import org.absorb.inventory.entity.client.ClientInventory;
import org.absorb.inventory.slot.AbstractSlot;
import org.absorb.inventory.slot.Slot;
import org.absorb.net.Client;
import org.absorb.net.packet.play.client.inventory.creative.IncomingCreativeInventoryClickPacket;
import org.absorb.net.processor.NetProcess;

import java.io.IOException;

public class CreativeClickInventoryProcessor implements NetProcess<IncomingCreativeInventoryClickPacket> {
    @Override
    public void onProcess(Client connection, IncomingCreativeInventoryClickPacket packet) throws IOException {
        ClientInventory inventory = connection.getInventory();
        Slot slot = inventory.getSlot(packet.getInventorySlot());
        if (!(slot instanceof AbstractSlot abSlot)) {
            throw new RuntimeException("Slot in id of '" + packet.getInventorySlot() + "' is not Abstract");
        }
        abSlot.setItem(packet.getItem().getItem().orElse(null));
    }
}
