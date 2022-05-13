package org.absorb.net.data.number.array;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.Serializer;
import org.absorb.net.data.Serializers;

import java.nio.ByteBuffer;
import java.util.BitSet;

public class BitSetSerializer implements Serializer<BitSet> {
    @Override
    public NetEntryData<BitSet> read(int position, ByteBuffer bytes) {
        NetEntryData<Integer> size = Serializers.VAR_INTEGER.read(position, bytes);
        NetEntryData<Long> previous = null;
        long[] array = new long[size.value()];
        for (int i = 0; i < size.value(); i++) {
            int newPos = previous==null ? size.endingPosition():previous.endingPosition();
            previous = Serializers.LONG.read(newPos, bytes);
            array[i] = previous.value();
        }
        return new NetEntryData<>(position, previous==null ? size.endingPosition():previous.endingPosition(),
                BitSet.valueOf(array));
    }

    @Override
    public ByteBuffer write(BitSet value) {
        long[] array = value.toLongArray();
        ByteBuffer sizeBuffer = Serializers.VAR_INTEGER.write(array.length);
        ByteBuffer dataBuffer = ByteBuffer.allocate(0);
        for (int i = 0; i < value.size(); i++) {
            long v = array[i];
            ByteBuffer longBuffer = Serializers.LONG.write(v);
            dataBuffer.limit(dataBuffer.limit() + longBuffer.limit());
            dataBuffer.put(longBuffer);
        }

        ByteBuffer ret = ByteBuffer.allocate(sizeBuffer.limit() + dataBuffer.limit());
        ret.put(sizeBuffer);
        ret.put(dataBuffer);
        return ret;
    }
}
