package org.absorb.inventory.slot;

import org.absorb.inventory.Inventory;
import org.absorb.inventory.item.ItemStack;
import org.absorb.inventory.item.ItemType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SpecificInputSlot extends InputSlot{

    private final ItemType[] acceptable;
    private final int maxStack;

    public SpecificInputSlot(int networkId, @NotNull Inventory inventory, int maxStack, ItemType... types) {
        this(networkId, inventory, null, maxStack, types);
    }

    public SpecificInputSlot(int networkId, @NotNull Inventory inventory, @Nullable ItemStack stack, int maxStack,
                             ItemType... types) {
        super(networkId, inventory, stack);
        this.acceptable = types;
        this.maxStack = maxStack;
    }

    public ItemType[] getAcceptableInput(){
        return this.acceptable;
    }

    public int getMaxStackSize(){
        return this.maxStack;
    }
}
