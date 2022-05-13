package org.absorb.inventory.item;

import org.absorb.inventory.item.data.StackData;
import org.absorb.inventory.item.data.StackDataKey;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ItemStack {

    private final @NotNull ItemType type;
    private byte stackSize;
    private final @NotNull LinkedBlockingQueue<StackData<?, ?>> data = new LinkedBlockingQueue<>();

    public ItemStack(@NotNull ItemStackBuilder builder){
        this.type = builder.getType();
        this.stackSize = builder.getStackSize();
        this.data.addAll(builder.getData());
    }

    public @NotNull ItemType getType(){
        return this.type;
    }

    public byte getStackSize(){
        return this.stackSize;
    }

    public void setStackSize(byte size){
        if(size < 1){
            throw new IllegalArgumentException("Size cannot be less then 1");
        }
        this.stackSize = size;
    }

    public Collection<StackData<?, ?>> getData(){
        return Collections.unmodifiableCollection(this.data);
    }

    public <V, T> Optional<StackData<V, T>> getData(@NotNull StackDataKey<V, T> key){
        return this.data.parallelStream().filter(k -> k.getKey().getResourceKey().equals(key.getResourceKey())).findAny().map(k -> (StackData<V, T>) k);
    }
}
