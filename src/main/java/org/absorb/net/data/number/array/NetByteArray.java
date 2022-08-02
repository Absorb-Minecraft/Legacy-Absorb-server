package org.absorb.net.data.number.array;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializer;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class NetByteArray implements NetSerializer<byte[]> {

    private final int length;

    public NetByteArray(int length) {
        this.length = length;
    }

    @Override
    public NetEntryData<byte[]> read(int position, ByteBuffer bytes) {
        byte[] result = Arrays.copyOfRange(bytes.array(), position, position + length);
        return new NetEntryData<>(position, position + length, result);
    }

    @Override
    public ByteBuffer write(byte[] result) {
        return ByteBuffer.wrap(result);
    }
}
