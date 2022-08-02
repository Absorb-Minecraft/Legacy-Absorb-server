package org.absorb.net.data.number;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializer;
import org.absorb.net.data.NetSerializers;

import java.nio.ByteBuffer;

public class NetShortUnsigned implements NetSerializer<Short> {
    @Override
    public NetEntryData<Short> read(int position, ByteBuffer bytes) {
        short v = NetSerializers.SHORT.read(position, bytes).value();
        return new NetEntryData<>(position, position + 2, (short) (v & 0xFFFF));
    }

    @Override
    public ByteBuffer write(Short value) {
        //TODO
        return NetSerializers.SHORT.write(value);
    }
}
