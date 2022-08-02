package org.absorb.net.packet.play.outgoing.entity.metadata.types;

import org.absorb.net.data.NetSerializer;
import org.absorb.net.data.NetSerializers;

import java.nio.ByteBuffer;

public enum MetadataValueType {

    BYTE(NetSerializers.BYTE, 0),
    VAR_INT(NetSerializers.VAR_INTEGER, 1),
    FLOAT(NetSerializers.FLOAT, 2),
    STRING(NetSerializers.STRING, 3),
    CHAT(NetSerializers.CHAT, 4),
    OPTIONAL_CHAT(NetSerializers.CHAT, 5, true),
    SLOT(NetSerializers.SLOT, 6),
    BOOLEAN(NetSerializers.BOOLEAN, 7);

    private final NetSerializer<?> serializer;
    private final int networkId;
    private final boolean isOptional;

    MetadataValueType(NetSerializer<?> serializer, int networkId) {
        this(serializer, networkId, false);
    }

    MetadataValueType(NetSerializer<?> serializer, int networkId, boolean isOptional) {
        this.serializer = serializer;
        this.networkId = networkId;
        this.isOptional = isOptional;
    }

    public NetSerializer<?> getSerializer() {
        return this.serializer;
    }

    public int getNetworkId() {
        return this.networkId;
    }

    public <T> ByteBuffer serialize(Object obj) {
        if (obj == null && !this.isOptional) {
            throw new IllegalArgumentException("Type is not optional");
        }
        if (obj == null) {
            return ByteBuffer.allocate(0);
        }
        return ((NetSerializer<T>) this.serializer).write((T) obj);
    }
}
