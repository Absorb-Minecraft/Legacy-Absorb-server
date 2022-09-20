package org.absorb.net.packet.play.outgoing.entity.metadata.types.value;

import org.absorb.net.data.Bitmaskable;
import org.absorb.net.data.NetSerializer;
import org.absorb.net.data.NetSerializers;

import java.nio.ByteBuffer;
import java.util.function.Function;

public class MetadataValueType<S, I> {

    private final NetSerializer<S> serializer;
    private final int networkId;
    private final boolean isOptional;
    private final Function<I, S> convert;

    public static class SimpleMetadataValueType<I> extends MetadataValueType<I, I> {

        SimpleMetadataValueType(NetSerializer<I> serializer, int networkId) {
            this(serializer, networkId, false);
        }

        SimpleMetadataValueType(NetSerializer<I> serializer, int networkId, boolean isOptional) {
            super(serializer, d -> d, networkId, isOptional);
        }
    }

    public static class BooleanDefinedOptionalType<S, I> extends MetadataValueType<S, I> {

        BooleanDefinedOptionalType(NetSerializer<S> serializer, int networkId) {
            this(serializer, t -> (S) t, networkId);
        }

        BooleanDefinedOptionalType(NetSerializer<S> serializer, Function<I, S> convert, int networkId) {
            super(serializer, convert, networkId);
        }

        @Override
        public ByteBuffer serialize(I obj) {
            if (obj == null) {
                return NetSerializers.BOOLEAN.write(false);
            }
            ByteBuffer valueBuffer = super.serialize(obj);
            ByteBuffer booleanBuffer = NetSerializers.BOOLEAN.write(true);

            ByteBuffer ret = ByteBuffer.allocate(valueBuffer.limit() + booleanBuffer.limit());
            ret.put(booleanBuffer.array());
            ret.put(valueBuffer.array());

            return ret;
        }
    }

    public static class BitMaskMetadataValueType<B extends Bitmaskable> extends MetadataValueType<Byte, B> {

        BitMaskMetadataValueType(int networkId) {
            this(networkId, false);
        }

        BitMaskMetadataValueType(int networkId, boolean isOptional) {
            super(NetSerializers.BYTE, Bitmaskable::toBitmask, networkId, isOptional);
        }
    }

    MetadataValueType(NetSerializer<S> serializer, Function<I, S> function, int networkId) {
        this(serializer, function, networkId, false);
    }

    MetadataValueType(NetSerializer<S> serializer, Function<I, S> convert, int networkId, boolean isOptional) {
        this.serializer = serializer;
        this.networkId = networkId;
        this.isOptional = isOptional;
        this.convert = convert;
    }

    public NetSerializer<S> getSerializer() {
        return this.serializer;
    }

    public int getNetworkId() {
        return this.networkId;
    }

    public ByteBuffer serialize(I obj) {
        if (obj == null && !this.isOptional) {
            throw new IllegalArgumentException("Type is not optional");
        }
        if (obj == null) {
            return ByteBuffer.allocate(0);
        }
        return this.serializer.write(this.convert.apply(obj));
    }
}
