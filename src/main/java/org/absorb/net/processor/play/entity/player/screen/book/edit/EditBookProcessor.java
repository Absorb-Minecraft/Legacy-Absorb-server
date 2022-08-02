package org.absorb.net.processor.play.entity.player.screen.book.edit;

import org.absorb.inventory.action.InventoryActions;
import org.absorb.inventory.item.ItemStack;
import org.absorb.inventory.item.ItemStackBuilder;
import org.absorb.inventory.item.ItemTypes;
import org.absorb.inventory.item.data.StackDataKeys;
import org.absorb.inventory.slot.AbstractSlot;
import org.absorb.inventory.slot.Slot;
import org.absorb.net.Client;
import org.absorb.net.packet.play.incoming.client.screen.book.edit.IncomingEditBookPacket;
import org.absorb.net.packet.play.incoming.client.screen.inventory.slot.update.OutgoingUpdateSlotPacketBuilder;
import org.absorb.net.processor.NetProcess;

import java.io.IOException;
import java.util.Optional;

public class EditBookProcessor implements NetProcess<IncomingEditBookPacket> {
    @Override
    public void onProcess(Client connection, IncomingEditBookPacket packet) throws IOException {
        Slot slot = connection.getInventory().getHotbar().getSlotAt(packet.getSlotIndex());
        if (!(slot instanceof AbstractSlot aSlot)) {
            throw new RuntimeException(
                    "Slot found however not abstract class, but instead " + slot.getClass().getName());
        }
        Optional<String> opTitle = packet.getTitle();
        if (opTitle.isPresent()) {
            this.publishBook(connection, packet, aSlot);
            return;
        }
        this.editBook(packet, aSlot);
    }

    public void publishBook(Client client, IncomingEditBookPacket packet, AbstractSlot slot) {
        ItemStack stack = slot
                .getItem()
                .orElseThrow(() -> new RuntimeException("Edit book was called on a slotindex that doesn't have a book"));
        ItemStack publishedBook = new ItemStackBuilder()
                .setStackSize((byte) 1)
                .setType(ItemTypes.WRITTEN_BOOK.get())
                .addData(stack.getData())
                .addData(StackDataKeys.SIMPLE_PAGES.with(packet.getEntries()))
                .addData(StackDataKeys.AUTHOR.with(client.getUsername()))
                .addData(StackDataKeys.TITLE.with(packet
                                                          .getTitle()
                                                          .orElseThrow(() -> new RuntimeException("Packet lost title"))))
                .build();

        slot.setItem(publishedBook);


        System.out.println("Updating client");
        new OutgoingUpdateSlotPacketBuilder()
                .setInventoryAsClient()
                .setSlot(slot)
                .setInventoryState(InventoryActions.STANDARD)
                .build()
                .writeToAsync(client);

    }

    public void editBook(IncomingEditBookPacket packet, Slot slot) {
        ItemStack stack = slot
                .getItem()
                .orElseThrow(() -> new RuntimeException(
                        "Edit book was called on a slotindex (" + packet.getSlotIndex() + ") that " + "doesn't "
                                + "have a " + "book"));
        stack.addData(StackDataKeys.SIMPLE_PAGES.with(packet.getEntries()));
        System.out.println("Item: \n" + stack.toString());
    }
}
