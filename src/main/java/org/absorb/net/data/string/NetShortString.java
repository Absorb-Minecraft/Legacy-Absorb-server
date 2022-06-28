package org.absorb.net.data.string;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializer;
import org.absorb.net.data.NetSerializers;

import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class NetShortString implements NetSerializer<String> {

    @Override
    public NetEntryData<String> read(int position, ByteBuffer buffer) {
        NetEntryData<Short> length = NetSerializers.UNSIGNED_SHORT.read(position, buffer);
        byte[] newBytes = Arrays.copyOfRange(buffer.array(), length.endingPosition(),
                length.endingPosition() + length.value());
        String value = new String(newBytes, 0, newBytes.length);
        return new NetEntryData<>(position, length.endingPosition() + length.value(), value);
    }

    @Override
    public ByteBuffer write(String value) {
        try {
            //this code converts the string to Modified UTF-8
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            DataOutput output = new DataOutputStream(stream);
            output.writeUTF(value);
            stream.flush();
            byte[] bytes = stream.toByteArray();
            //End of stupid code


            ByteBuffer buffer = ByteBuffer.wrap(bytes);
            ByteBuffer lengthBuffer = NetSerializers.UNSIGNED_SHORT.write((short) bytes.length);
            ByteBuffer ret = ByteBuffer.allocate(buffer.limit() + lengthBuffer.limit());
            ret.put(lengthBuffer);
            ret.put(buffer);

            return ret;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
