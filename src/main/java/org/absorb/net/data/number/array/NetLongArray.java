package org.absorb.net.data.number.array;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializer;
import org.absorb.net.data.NetSerializers;

import java.nio.ByteBuffer;

public class NetLongArray implements NetSerializer<Long[]> {
    @Override
    public NetEntryData<Long[]> read(int position, ByteBuffer bytes) {
        NetEntryData<Integer> size = NetSerializers.VAR_INTEGER.read(position, bytes);
        NetEntryData<Long> previous = null;
        Long[] array = new Long[size.value()];
        for (int i = 0; i < size.value(); i++) {
            int newPos = previous==null ? size.endingPosition():previous.endingPosition();
            previous = NetSerializers.LONG.read(newPos, bytes);
            array[i] = previous.value();
        }
        return new NetEntryData<>(position, previous==null ? size.endingPosition():previous.endingPosition(),
                array);
    }

    @Override
    public ByteBuffer write(Long[] value) {
        ByteBuffer sizeBuffer = NetSerializers.VAR_INTEGER.write(value.length);
        ByteBuffer dataBuffer = ByteBuffer.allocate(0);
        for (long v : value) {
            ByteBuffer longBuffer = NetSerializers.LONG.write(v);
            dataBuffer.limit(dataBuffer.limit() + longBuffer.limit());
            dataBuffer.put(longBuffer);
        }

        ByteBuffer ret = ByteBuffer.allocate(sizeBuffer.limit() + dataBuffer.limit());
        ret.put(sizeBuffer);
        ret.put(dataBuffer);
        return ret;
    }
}
