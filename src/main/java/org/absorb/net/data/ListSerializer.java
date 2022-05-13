package org.absorb.net.data;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class ListSerializer<T> implements Serializer<List<T>> {

    private final Serializer<T> serializer;

    public ListSerializer(Serializer<T> serializer) {
        this.serializer = serializer;
    }

    @Override
    public NetEntryData<List<T>> read(int position, ByteBuffer bytes) {
        NetEntryData<Integer> count = Serializers.VAR_INTEGER.read(position, bytes);
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
        ByteBuffer ret = Serializers.VAR_INTEGER.write(value.size());
        for (T entry : value) {
            ByteBuffer entryBuffer = this.serializer.write(entry);
            byte[] array = entryBuffer.array();
            ByteBuffer temp = ByteBuffer.allocate(entryBuffer.limit() + ret.limit());
            temp.put(ret);
            temp.put(array); //some reason it doesnt work when you put the entryBuffer, so thats why the array is
            // extracted before hand and that is added
            ret = temp;
        }
        return ret;
    }
}
