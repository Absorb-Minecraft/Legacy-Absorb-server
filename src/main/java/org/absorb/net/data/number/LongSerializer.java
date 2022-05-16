package org.absorb.net.data.number;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.Serializer;

import java.nio.ByteBuffer;

public class LongSerializer implements Serializer<Long> {
    @Override
    public NetEntryData<Long> read(int position, ByteBuffer bytes) {
        long value = bytes.getLong(position);
        return new NetEntryData<>(position, position + Long.BYTES, value);
    }

    @Override
    public ByteBuffer write(Long value) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putLong(value);
        return buffer;
    }
}
