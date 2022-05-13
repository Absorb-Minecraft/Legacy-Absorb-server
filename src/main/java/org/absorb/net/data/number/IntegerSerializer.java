package org.absorb.net.data.number;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.Serializer;

import java.nio.ByteBuffer;

public class IntegerSerializer implements Serializer<Integer> {
    @Override
    public NetEntryData<Integer> read(int position, ByteBuffer bytes) {
        return new NetEntryData<>(position, position + Integer.BYTES, bytes.getInt(position));
    }

    @Override
    public ByteBuffer write(Integer value) {
        ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
        buffer.putInt(value);
        return buffer;
    }
}
