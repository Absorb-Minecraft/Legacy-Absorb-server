package org.absorb.inventory.item;

import org.absorb.inventory.item.data.StackData;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.concurrent.LinkedBlockingQueue;

public class ItemStackBuilder implements Builder<ItemStack> {

    private ItemType type;
    private byte stackSize = 1;
    private final @NotNull LinkedBlockingQueue<StackData<?, ?>> data = new LinkedBlockingQueue<>();

    public ItemType getType() {
        return this.type;
    }

    public ItemStackBuilder setType(ItemType type) {
        this.type = type;
        return this;
    }

    public byte getStackSize() {
        return this.stackSize;
    }

    public ItemStackBuilder setStackSize(byte stackSize) {
        this.stackSize = stackSize;
        return this;
    }

    public Collection<StackData<?, ?>> getData() {
        return this.data;
    }

    public ItemStackBuilder addData(Collection<? extends StackData<?, ?>> collection) {
        this.data.addAll(collection);
        return this;
    }

    @Override
    public @NotNull ItemStack build() {
        return new ItemStack(this);
    }

    @Override
    public @NotNull Builder<ItemStack> reset() {
        this.type = null;
        this.stackSize = 1;
        this.data.clear();
        return this;
    }

    @Override
    public @NotNull Builder<ItemStack> copy() {
        return new ItemStackBuilder().setStackSize(this.stackSize).setType(this.type).addData(this.data);
    }
}
