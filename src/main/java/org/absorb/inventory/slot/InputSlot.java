package org.absorb.inventory.slot;

import org.absorb.inventory.Inventory;
import org.absorb.inventory.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class InputSlot extends AbstractSlot {
    public InputSlot(int networkId, @NotNull Inventory inventory) {
        super(networkId, inventory);
    }

    public InputSlot(int networkId, @NotNull Inventory inventory, @Nullable ItemStack stack) {
        super(networkId, inventory, stack);
    }
}
