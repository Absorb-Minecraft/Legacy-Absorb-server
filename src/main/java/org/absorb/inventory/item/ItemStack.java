package org.absorb.inventory.item;

import org.absorb.inventory.item.data.StackData;
import org.absorb.inventory.item.data.StackDataKey;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class ItemStack {

    private final @NotNull ItemType type;
    private final @NotNull LinkedBlockingQueue<StackData<?, ?>> data = new LinkedBlockingQueue<>();
    private byte stackSize;

    public ItemStack(@NotNull ItemStackBuilder builder) {
        this.type = builder.getType();
        this.stackSize = builder.getStackSize();

        Set<StackData<?, ?>> set = builder
                .getData()
                .parallelStream()
                .filter(sData -> this.type.getSupportedData().contains(sData.getKey()))
                .collect(Collectors.toSet());

        this.data.addAll(set);
    }

    public @NotNull ItemType getType() {
        return this.type;
    }

    public byte getStackSize() {
        return this.stackSize;
    }

    public void setStackSize(byte size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size cannot be less then 1");
        }
        this.stackSize = size;
    }

    public Collection<StackData<?, ?>> getData() {
        return Collections.unmodifiableCollection(this.data);
    }

    public <V, T> Optional<StackData<V, T>> getData(@NotNull StackDataKey<V, T> key) {
        return this.data
                .parallelStream()
                .filter(k -> k.getKey().getResourceKey().equals(key.getResourceKey()))
                .findAny()
                .map(k -> (StackData<V, T>) k);
    }

    public <V, T> void addData(@NotNull StackData<V, T> data) {
        Optional<StackData<?, ?>> opData = this.data
                .parallelStream()
                .filter(data1 -> data.getKey().getResourceKey().equals(data1.getKey().getResourceKey()))
                .findAny();
        opData.ifPresent(this.data::remove);
        this.data.add(data);
    }

    @Override
    public String toString() {
        String dataText = this.data
                .parallelStream()
                .map(data -> data.getKey().getResourceKey().asFormatted() + ": " + data.get().orElse(null))
                .sorted()
                .collect(Collectors.joining(",\t"));
        return "type: " + this.type.getResourceKey().asFormatted() + ",\tamount: " + this.stackSize + ",\t" + dataText;
    }
}
