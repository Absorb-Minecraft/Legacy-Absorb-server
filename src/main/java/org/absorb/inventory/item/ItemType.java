package org.absorb.inventory.item;

import org.absorb.block.type.BlockType;
import org.absorb.event.events.client.inventory.item.use.UseItemEvent;
import org.absorb.inventory.item.data.StackDataKey;
import org.absorb.inventory.item.properties.ItemTypeProperty;
import org.absorb.register.AbsorbKey;
import org.absorb.register.Typed;
import org.absorb.utils.NetworkIdentifiable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.function.Consumer;

@Typed(getTypesClass = ItemTypes.class)
public class ItemType implements NetworkIdentifiable {

    private final int networkId;
    private final @NotNull String name;
    private final @NotNull String key;
    private final @NotNull String host;
    private final @NotNull Collection<StackDataKey<?, ?>> supportedData = new HashSet<>();
    private final @NotNull Collection<ItemTypeProperty> properties = new HashSet<>();
    private final @Nullable Consumer<UseItemEvent.Pre> onUseEvent;
    private final int stackSize;
    private @Nullable AbsorbKey blockKey;
    private @Nullable BlockType block;

    public ItemType(@NotNull ItemTypeBuilder builder) {
        this.supportedData.addAll(builder.getSupportedData());
        this.key = builder.getKey();
        this.host = builder.getHost();
        this.networkId = builder.getNetworkId();
        this.stackSize = builder.getStackSize();
        this.name = builder.getName();
        this.onUseEvent = builder.getOnUseEvent();
    }

    public Collection<ItemTypeProperty> getProperties() {
        return Collections.unmodifiableCollection(this.properties);
    }

    public Optional<Consumer<UseItemEvent.Pre>> onUseItem() {
        return Optional.ofNullable(this.onUseEvent);
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
