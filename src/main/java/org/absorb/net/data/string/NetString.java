package org.absorb.net.data.string;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializer;
import org.absorb.net.data.NetSerializers;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class NetString implements NetSerializer<String> {
    @Override
    public NetEntryData<String> read(int position, ByteBuffer buffer) {
        NetEntryData<Integer> length = NetSerializers.VAR_INTEGER.read(position, buffer);
        if (buffer.array().length < (length.endingPosition() + length.value())) {
            throw new IndexOutOfBoundsException(
                    "Buffer (" + buffer.array().length + ") is smaller then " + (length.endingPosition()
                            + length.value()));
        }
        byte[] newBytes = Arrays.copyOfRange(buffer.array(),
                                             length.endingPosition(),
                                             length.endingPosition() + length.value());
        String value = new String(newBytes, 0, newBytes.length);
        return new NetEntryData<>(position, length.endingPosition() + length.value(), value);
    }

    @Override
    public ByteBuffer write(String value) {
        return this.write(value, true);
    }

    public ByteBuffer write(String value, boolean checkStringLength) {
        if (checkStringLength && value.length() >= 32767) {
            throw new RuntimeException("Passed String is greater then 32767 characters");
        }
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        ByteBuffer lengthBuffer = NetSerializers.VAR_INTEGER.write(bytes.length);
        ByteBuffer ret = ByteBuffer.allocate(buffer.limit() + lengthBuffer.limit());
        ret.put(lengthBuffer);
        ret.put(buffer);

        return ret;
    }
}
