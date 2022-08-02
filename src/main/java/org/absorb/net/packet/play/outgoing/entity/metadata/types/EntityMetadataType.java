package org.absorb.net.packet.play.outgoing.entity.metadata.types;

import org.jetbrains.annotations.NotNull;

public class EntityMetadataType<T> {

    private final int networkId;
    private final MetadataValueType type;

    EntityMetadataType(@NotNull MetadataValueType type, int networkId) {
        this.networkId = networkId;
        this.type = type;
    }

    public int getNetworkId() {
        return this.networkId;
    }

    public @NotNull MetadataValueType getValueType() {
        return this.type;
    }

}