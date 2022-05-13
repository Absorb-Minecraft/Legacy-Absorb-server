package org.absorb.net.data.string;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.Serializer;
import org.absorb.net.data.Serializers;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringSerializer implements Serializer<String> {
    @Override
    public NetEntryData<String> read(int position, ByteBuffer buffer) {
        NetEntryData<Integer> length = Serializers.VAR_INTEGER.read(position, buffer);
        byte[] newBytes = Arrays.copyOfRange(buffer.array(), length.endingPosition(),
                length.endingPosition() + length.value());
        String value = new String(newBytes, 0, newBytes.length);
        return new NetEntryData<>(position, length.endingPosition() + length.value(), value);
    }

    @Override
    public ByteBuffer write(String value) {
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        ByteBuffer lengthBuffer = Serializers.VAR_INTEGER.write(bytes.length);
        ByteBuffer ret = ByteBuffer.allocate(buffer.limit() + lengthBuffer.limit());
        ret.put(lengthBuffer);
        ret.put(buffer);

        return ret;
    }
}
