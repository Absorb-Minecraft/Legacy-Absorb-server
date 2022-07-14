package org.absorb.inventory.item;

import org.absorb.event.events.inventory.client.inventory.item.use.UseItemEvent;
import org.absorb.inventory.item.data.StackDataKey;
import org.absorb.inventory.item.properties.ItemTypeProperty;
import org.absorb.register.AbsorbKey;
import org.absorb.utils.Builder;
import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Consumer;

public class ItemTypeBuilder implements Builder<ItemType> {

    private final @NotNull Collection<StackDataKey<?, ?>> supportedData = new HashSet<>();
    private final @NotNull Collection<ItemTypeProperty> properties = new HashSet<>();
    private int networkId;
    private String name;
    private String key;
    private String host;
    private @Nullable AbsorbKey blockKey;
    private Consumer<UseItemEvent.Pre> onUseEvent;

    private int stackSize;

    public ItemTypeBuilder() {
        reset();
    }

    public int getNetworkId() {
        return this.networkId;
    }

    public ItemTypeBuilder setNetworkId(int networkId) {
        this.networkId = networkId;
        return this;
    }

    public Consumer<UseItemEvent.Pre> getOnUseEvent() {
        return this.onUseEvent;
    }

    public ItemTypeBuilder setOnUseEvent(Consumer<UseItemEvent.Pre> onUseEvent) {
        this.onUseEvent = onUseEvent;
        return this;
    }

    public int getStackSize() {
        return this.stackSize;
    }

    public ItemTypeBuilder setStackSize(int stackSize) {
        this.stackSize = stackSize;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public ItemTypeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public ItemTypeBuilder setKey(String key) {
        this.key = key;
        return this;
    }

    public String getHost() {
        return this.host;
    }

    public ItemTypeBuilder setHost(String host) {
        this.host = host;
        return this;
    }

    public AbsorbKey getBlockKey() {
        return this.blockKey;
    }

    public ItemTypeBuilder setBlockKey(AbsorbKey blockKey) {
        this.blockKey = blockKey;
        return this;
    }

    public Collection<StackDataKey<?, ?>> getSupportedData() {
        return this.supportedData;
    }

    public ItemTypeBuilder addSupportedData(StackDataKey<?, ?>... keys) {
        this.supportedData.addAll(Arrays.asList(keys));
        return this;
    }

    public Collection<ItemTypeProperty> getProperties() {
        return this.properties;
    }

    @Override
    public @NotNull ItemType build() {
        return new ItemType(this);
    }

    @Override
    public @NotNull Builder<ItemType> reset() {
        this.stackSize = 64;
        this.key = null;
        this.host = Identifiable.MINECRAFT_HOST;
        this.name = null;
        this.blockKey = null;
        this.properties.clear();
        this.supportedData.clear();
        return this;
    }

    @Override
    public @NotNull Builder<ItemType> copy() {
        throw new RuntimeException("Not implemented yet");
    }
}
