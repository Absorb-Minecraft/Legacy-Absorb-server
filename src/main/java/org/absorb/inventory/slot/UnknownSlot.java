package org.absorb.inventory.slot;

import org.absorb.inventory.Inventory;
import org.absorb.inventory.InventoryType;
import org.absorb.inventory.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class UnknownSlot implements Slot {

    private @Nullable ItemStack stack;
    private @Nullable Inventory parent;

    public UnknownSlot(@Nullable Inventory parent, @Nullable ItemStack stack){
        this.parent = parent;
        this.stack = stack;
    }


    @Override
    public Optional<Inventory> getParent() {
        return Optional.ofNullable(this.parent);
    }

    @Override
    public Optional<InventoryType> getType() {
        return Optional.empty();
    }

    @Override
    public Optional<ItemStack> getItem() {
        return Optional.ofNullable(this.stack);
    }
}
