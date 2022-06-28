package org.absorb.net.data.number;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializer;

import java.nio.ByteBuffer;

public class NetByte implements NetSerializer<Byte> {
    @Override
    public NetEntryData<Byte> read(int position, ByteBuffer bytes) {
        return new NetEntryData<>(position, position + 1, bytes.get(position));
    }

    @Override
    public ByteBuffer write(Byte value) {
        ByteBuffer buffer = ByteBuffer.allocate(Byte.BYTES);
        buffer.put(value);
        return buffer;
    }
}
