package org.absorb.net.data.number;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.Serializer;

import java.nio.ByteBuffer;

public class LongSerializer implements Serializer<Long> {
    @Override
    public NetEntryData<Long> read(int position, ByteBuffer bytes) {
        byte[] bArray = new byte[Long.BYTES];
        for (int A = 0; A < bArray.length; A++) {
            bArray[A] = bytes.get(A);
        }
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.put(bArray);
        buffer.flip();
        return new NetEntryData<>(position, position + bArray.length, buffer.getLong());

    }

    @Override
    public ByteBuffer write(Long value) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putLong(value);
        return buffer;
    }
}
