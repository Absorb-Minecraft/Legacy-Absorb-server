package org.absorb.net.data.number;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializer;

import java.nio.ByteBuffer;

public class NetFloat implements NetSerializer<Float> {
    @Override
    public NetEntryData<Float> read(int position, ByteBuffer bytes) {
        float value = bytes.getFloat(position);
        return new NetEntryData<>(position, position + 4, value);
    }

    @Override
    public ByteBuffer write(Float value) {
        ByteBuffer buffer = ByteBuffer.allocate(Float.BYTES);
        buffer.putFloat(value);
        return buffer;
    }
}
