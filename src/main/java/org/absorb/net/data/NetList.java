package org.absorb.net.data;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class NetList<T> implements NetSerializer<List<T>> {

    private final NetSerializer<T> serializer;

    public NetList(NetSerializer<T> serializer) {
        this.serializer = serializer;
    }

    @Override
    public NetEntryData<List<T>> read(int position, ByteBuffer bytes) {
        NetEntryData<Integer> count = NetSerializers.VAR_INTEGER.read(position, bytes);
        int previous = count.endingPosition();
        List<T> list = new ArrayList<>(count.value());
        for (int i = 0; i < count.value(); i++) {
            NetEntryData<T> v = this.serializer.read(previous, bytes);
            previous = v.endingPosition();
            list.add(v.value());
        }
        return new NetEntryData<>(position, previous, list);
    }

    @Override
    public ByteBuffer write(List<T> value) {
        ByteBuffer ret = NetSerializers.VAR_INTEGER.write(value.size());
        for (T entry : value) {
            ByteBuffer entryBuffer = this.serializer.write(entry);
            ByteBuffer temp = ByteBuffer.allocate(entryBuffer.limit() + ret.limit());
            temp.put(ret.array());
            temp.put(entryBuffer.array());
            /*some reason it doesnt work when you put the entryBuffer, so thats why the array is
            extracted before hand and that is added*/
            ret = temp;
        }
        return ret;
    }
}
