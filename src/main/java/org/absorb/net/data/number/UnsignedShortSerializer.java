package org.absorb.net.data.number;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.Serializer;
import org.absorb.net.data.Serializers;

import java.nio.ByteBuffer;

public class UnsignedShortSerializer implements Serializer<Short> {
    @Override
    public NetEntryData<Short> read(int position, ByteBuffer bytes) {
        short v = Serializers.SHORT.read(position, bytes).value();
        return new NetEntryData<>(position, position + 2, (short) (v & 0xFFFF));
    }

    @Override
    public ByteBuffer write(Short value) {
        //TODO
        return Serializers.SHORT.write(value);
    }
}
