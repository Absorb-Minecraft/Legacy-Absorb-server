package org.absorb.net.processor.play.entity.player.screen.inventory.hotbar.hand.use;

import org.absorb.event.events.inventory.client.inventory.item.use.UseItemEvent;
import org.absorb.event.events.inventory.client.inventory.item.use.UseItemEventBuilder;
import org.absorb.inventory.item.ItemStack;
import org.absorb.inventory.slot.Slot;
import org.absorb.net.Client;
import org.absorb.net.packet.play.incoming.client.screen.inventory.hotbar.hand.use.IncomingUseItemPacket;
import org.absorb.net.processor.NetProcess;

import java.io.IOException;
import java.util.Optional;
import java.util.function.Consumer;

public class UseItemProcessor implements NetProcess<IncomingUseItemPacket> {
    @Override
    public void onProcess(Client connection, IncomingUseItemPacket packet) throws IOException {
        System.out.println("Hand: " + packet.getHand().name());
        //assumes main
        Slot slot = connection.getInventory().getHotbar().getSelectedSlot();
        Optional<ItemStack> opStack = slot.getItem();
        if (opStack.isEmpty()) {
            return;
        }
        ItemStack stack = opStack.get();
        System.out.println("Item: " + stack.getType().getResourceKey().asFormatted());
        Optional<Consumer<UseItemEvent.Pre>> opUseItem = stack.getType().onUseItem();
        if (opUseItem.isEmpty()) {
            return;
        }
        Consumer<UseItemEvent.Pre> useItem = opUseItem.get();
        UseItemEvent.Pre event = new UseItemEventBuilder<UseItemEvent.Pre>()
                .setItem(slot)
                .setClient(connection)
                .build();
        useItem.accept(event);
    }
}
