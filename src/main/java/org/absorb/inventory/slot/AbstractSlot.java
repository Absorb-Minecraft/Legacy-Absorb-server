package org.absorb.inventory.slot;

import org.absorb.inventory.Inventory;
import org.absorb.inventory.InventoryType;
import org.absorb.inventory.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class AbstractSlot implements Slot {

    private final @Nullable Inventory parent;
    private final int networkId;
    private @Nullable ItemStack stack;

    public AbstractSlot(int networkId, @Nullable Inventory inventory) {
        this(networkId, inventory, null);
    }

    public AbstractSlot(int networkId, @Nullable Inventory inventory, @Nullable ItemStack stack) {
        this.parent = inventory;
        this.stack = stack;
        this.networkId = networkId;
    }

    public int getNetworkId() {
        return this.networkId;
    }

    public Optional<ItemStack> getItem() {
        return Optional.ofNullable(this.stack);
    }

    public void setItem(@Nullable ItemStack stack) {
        this.stack = stack;
    }

    public void removeItem() {
        this.setItem(null);
    }

    @Override
    public Optional<Inventory> getParent() {
        return Optional.ofNullable(this.parent);
    }


    @Override
    public Optional<InventoryType> getType() {
        return Optional.empty();
    }


}
