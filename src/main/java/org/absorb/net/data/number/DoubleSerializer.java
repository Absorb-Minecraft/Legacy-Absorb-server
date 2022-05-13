package org.absorb.net.data.number;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.Serializer;

import java.nio.ByteBuffer;

public class DoubleSerializer implements Serializer<Double> {
    @Override
    public NetEntryData<Double> read(int position, ByteBuffer bytes) {
        return new NetEntryData<>(position, position + Double.BYTES, bytes.getDouble(position));
    }

    @Override
    public ByteBuffer write(Double value) {
        ByteBuffer buffer = ByteBuffer.allocate(Double.BYTES);
        buffer.putDouble(value);
        return buffer;
    }
}
