package org.absorb.net.data.number;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializer;

import java.nio.ByteBuffer;

public class NetShort implements NetSerializer<Short> {
    @Override
    public NetEntryData<Short> read(int position, ByteBuffer bytes) {
        ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.put(bytes.get(position));
        buffer.put(bytes.get(position + 1));
        short result = buffer.getShort(0);

        return new NetEntryData<>(position, position + 2, result);
    }

    @Override
    public ByteBuffer write(Short value) {
        ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.putShort(value);
        return buffer;
    }
}
