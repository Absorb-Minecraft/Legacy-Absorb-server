package org.absorb.net.data.nbt;

import me.nullicorn.nedit.NBTInputStream;
import me.nullicorn.nedit.NBTOutputStream;
import me.nullicorn.nedit.type.NBTList;
import me.nullicorn.nedit.type.TagType;
import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.Serializer;
import org.absorb.utils.MarkedByteArrayInputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class NBTListSerializer implements Serializer<NBTList> {

    private final TagType tag;

    public NBTListSerializer(TagType tag) {
        this.tag = tag;
    }

    @Override
    public NetEntryData<NBTList> read(int position, ByteBuffer bytes) {
        try {
            MarkedByteArrayInputStream markedBaIs = new MarkedByteArrayInputStream(bytes.array());
            NBTList list = new NBTInputStream(markedBaIs).readList();
            return new NetEntryData<>(position, (int) (position + markedBaIs.getCounter()), list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ByteBuffer write(NBTList value) {
        try {
            ByteArrayOutputStream baIs = new ByteArrayOutputStream();
            NBTOutputStream nbtOs = new NBTOutputStream(baIs, false);
            nbtOs.writeList(value);
            baIs.flush();
            return ByteBuffer.wrap(baIs.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
