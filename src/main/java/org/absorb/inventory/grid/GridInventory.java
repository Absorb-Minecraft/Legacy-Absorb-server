package org.absorb.inventory.grid;

import org.absorb.inventory.Inventory;
import org.absorb.inventory.slot.Slot;

public interface GridInventory extends Inventory {

    int getHeight();

    int getWidth();

    Slot getSlot(int x, int y);
}
