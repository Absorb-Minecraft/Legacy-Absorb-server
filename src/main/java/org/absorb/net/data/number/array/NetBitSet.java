package org.absorb.net.data.number.array;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializer;
import org.absorb.net.data.NetSerializers;

import java.nio.ByteBuffer;
import java.util.BitSet;

public class NetBitSet implements NetSerializer<BitSet> {
    @Override
    public NetEntryData<BitSet> read(int position, ByteBuffer bytes) {
        NetEntryData<Integer> size = NetSerializers.VAR_INTEGER.read(position, bytes);
        NetEntryData<Long> previous = null;
        long[] array = new long[size.value()];
        for (int i = 0; i < size.value(); i++) {
            int newPos = previous==null ? size.endingPosition():previous.endingPosition();
            previous = NetSerializers.LONG.read(newPos, bytes);
            array[i] = previous.value();
        }
        return new NetEntryData<>(position, previous==null ? size.endingPosition():previous.endingPosition(),
                BitSet.valueOf(array));
    }

    @Override
    public ByteBuffer write(BitSet value) {
        long[] array = value.toLongArray();
        ByteBuffer sizeBuffer = NetSerializers.VAR_INTEGER.write(array.length);
        ByteBuffer dataBuffer = ByteBuffer.allocate(0);
        for (int i = 0; i < array.length; i++) {
            long v = array[i];
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
