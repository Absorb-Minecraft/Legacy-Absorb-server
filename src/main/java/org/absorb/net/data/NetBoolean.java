package org.absorb.net.data;

import java.nio.ByteBuffer;

public class NetBoolean implements NetSerializer<Boolean> {
    @Override
    public NetEntryData<Boolean> read(int position, ByteBuffer bytes) {
        byte b = bytes.get(position);
        if (b!=0 && b!=1) {
            throw new RuntimeException("Cannot convert byte of " + b + " to boolean");
        }
        return new NetEntryData<>(position, position + 1, b==1);
    }

    @Override
    public ByteBuffer write(Boolean value) {
        ByteBuffer buffer = ByteBuffer.allocate(1);
        buffer.put(value ? (byte) 1:(byte) 0);
        return buffer;
    }
}
