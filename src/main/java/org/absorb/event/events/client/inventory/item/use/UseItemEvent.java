package org.absorb.event.events.client.inventory.item.use;

import org.absorb.event.Event;
import org.absorb.event.events.CancelableEvent;
import org.absorb.event.events.ClientEvent;
import org.absorb.inventory.item.ItemStack;
import org.absorb.inventory.slot.Slot;

public interface UseItemEvent extends Event, ClientEvent {

    interface Pre extends UseItemEvent, CancelableEvent {

    }

    Slot getSlot();

    default ItemStack getItem() {
        return this
                .getSlot()
                .getItem()
                .orElseThrow(() -> new RuntimeException("Event should never been created. Slot has no item"));
    }
}
