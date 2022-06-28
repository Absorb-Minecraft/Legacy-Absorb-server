package org.absorb.net.data.number;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializer;

import java.nio.ByteBuffer;

public class NetLongUnsigned implements NetSerializer<Long> {
    @Override
    public NetEntryData<Long> read(int position, ByteBuffer bytes) {
        long b1 = (long)bytes.get(position) << 56;
        long b2 = ((long)bytes.get(position + 1) & 255) << 48;
        long b3 = ((long)bytes.get(position + 2) & 255) << 40;
        long b4 = ((long)bytes.get(position + 3) & 255) << 32;
        long b5 = ((long)bytes.get(position + 4) & 255) << 24;
        long b6 = (bytes.get(position + 5) & 255) << 16;
        long b7 = (bytes.get(position + 6) & 255) << 8;
        long b8 = (bytes.get(position + 7) & 255) << 0;

        long result = b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8;
        return new NetEntryData<>(position, position + 8, result);

    }

    @Override
    public ByteBuffer write(Long value) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.put((byte) (value >>> 56));
        buffer.put((byte) (value >>> 48));
        buffer.put((byte) (value >>> 40));
        buffer.put((byte) (value >>> 32));
        buffer.put((byte) (value >>> 24));
        buffer.put((byte) (value >>> 16));
        buffer.put((byte) (value >>> 8));
        buffer.put((byte)  (value >>> 0));
        return buffer;
    }
}
