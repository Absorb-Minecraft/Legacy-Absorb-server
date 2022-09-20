package org.absorb.net.packet.play.outgoing.entity.metadata.types;

import org.absorb.net.packet.play.outgoing.entity.metadata.types.value.MetadataValueType;
import org.jetbrains.annotations.NotNull;

public class EntityMetadataType<S, I> {

    private final int networkId;
    private final MetadataValueType<S, I> type;
    private final I defaultValue;

    EntityMetadataType(@NotNull MetadataValueType<S, I> type, int networkId, I defaultValue) {
        this.networkId = networkId;
        this.type = type;
        this.defaultValue = defaultValue;
    }

    public I getDefaultValue() {
        return this.defaultValue;
    }

    public int getNetworkId() {
        return this.networkId;
    }

    public @NotNull MetadataValueType<S, I> getValueType() {
        return this.type;
    }

}