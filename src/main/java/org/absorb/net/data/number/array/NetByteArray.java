package org.absorb.net.data.number.array;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializer;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class NetByteArray implements NetSerializer<Byte[]> {

    private final int length;

    public NetByteArray(int length) {
        this.length = length;
    }

    @Override
    public NetEntryData<Byte[]> read(int position, ByteBuffer bytes) {
        byte[] result = Arrays.copyOfRange(bytes.array(), position, position + length);
        Byte[] resultClass = new Byte[result.length];
        for (int i = 0; i < result.length; i++) {
            resultClass[i] = result[i];
        }

        return new NetEntryData<>(position, position + length, resultClass);
    }

    @Override
    public ByteBuffer write(Byte[] result) {
        byte[] resultPrim = new byte[result.length];
        for (int i = 0; i < result.length; i++) {
            resultPrim[i] = result[i];
        }

        return ByteBuffer.wrap(resultPrim);
    }
}
