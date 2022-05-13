package org.absorb.net.data.string;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.Serializer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class FixedSizeStringSerializer implements Serializer<String> {

    private final int size;

    public FixedSizeStringSerializer(int size) {
        this.size = size;
    }

    @Override
    public NetEntryData<String> read(int position, ByteBuffer bytes) {
        byte[] charBytes = Arrays.copyOfRange(bytes.array(), position, position + this.size);
        String result = new String(charBytes);
        return new NetEntryData<>(position, position + this.size, result);
    }

    @Override
    public ByteBuffer write(String value) {
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
        ByteBuffer buffer = ByteBuffer.allocate(this.size);
        buffer.put(bytes);
        return buffer;
    }
}
