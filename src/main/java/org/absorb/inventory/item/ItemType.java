package org.absorb.inventory.item;

import org.absorb.inventory.item.data.StackDataKey;
import org.absorb.utils.NetworkIdentifiable;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class ItemType implements NetworkIdentifiable {

    private final int networkId;
    private final @NotNull String name;
    private final @NotNull String key;
    private final @NotNull String host;
    private final @NotNull Collection<StackDataKey<?, ?>> supportedData = new HashSet<>();

    ItemType(int id, String host, String key, String name, Collection<StackDataKey<?, ?>> data){
        this.networkId = id;
        this.host = host;
        this.key = key;
        this.name = name;
        this.supportedData.addAll(data);
    }

    public Collection<StackDataKey<?, ?>> getSupportedData() {
        return Collections.unmodifiableCollection(this.supportedData);
    }

    public boolean isSupported(@NotNull StackDataKey<?, ?> key) {
        return this.supportedData.parallelStream().anyMatch(k -> k.equals(key));
    }

    @Override
    public int getNetworkId() {
        return this.networkId;
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    @Override
    public @NotNull String getKey() {
        return this.key;
    }

    @Override
    public @NotNull String getHost() {
        return this.host;
    }
}
