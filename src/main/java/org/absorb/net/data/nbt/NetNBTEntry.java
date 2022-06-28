package org.absorb.net.data.nbt;

import me.nullicorn.nedit.NBTInputStream;
import me.nullicorn.nedit.NBTOutputStream;
import me.nullicorn.nedit.type.TagType;
import org.absorb.files.nbt.compound.NBTCompoundEntry;
import org.absorb.files.nbt.compound.NBTCompoundKey;
import org.absorb.files.nbt.compound.NBTCompoundKeys;
import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializer;
import org.absorb.net.data.NetSerializers;
import org.absorb.utils.MarkedByteArrayInputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class NetNBTEntry implements NetSerializer<NBTCompoundEntry<?, ?>> {

    @Override
    public NetEntryData<NBTCompoundEntry<?, ?>> read(int position, ByteBuffer bytes) {
        NetEntryData<Byte> id = NetSerializers.BYTE.read(position, bytes);
        NetEntryData<String> key = NetSerializers.STRING.read(id.endingPosition(), bytes);
        try {
            return (NetEntryData<NBTCompoundEntry<?, ?>>) (Object) this.readValue(id, key, bytes);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public ByteBuffer write(NBTCompoundEntry<?, ?> value) {
        ByteBuffer idBuffer = NetSerializers.BYTE.write((byte) value.getTag().getId());
        ByteBuffer keyBuffer = NetSerializers.SHORT_STRING.write(value.getKey().getKey());
        ByteBuffer valueBuffer;
        try {
            valueBuffer = this.writeValue(value);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        System.out.println("\t\tKey: " + NetSerializers.SHORT_STRING.read(0, ByteBuffer.wrap(keyBuffer.array())).value());

        ByteBuffer ret = ByteBuffer.allocate(idBuffer.capacity() + keyBuffer.capacity() + valueBuffer.capacity());
        ret.put(idBuffer);
        ret.put(keyBuffer);
        ret.put(valueBuffer);
        return ret;
    }

    private <T, F> NetEntryData<NBTCompoundEntry<T, F>> readValue(NetEntryData<Byte> id, NetEntryData<String> key,
                                                                  ByteBuffer bytes) throws IOException {
        TagType tag = TagType.fromId(id.value());
        MarkedByteArrayInputStream markedIS = new MarkedByteArrayInputStream(bytes);
        NBTInputStream is = new NBTInputStream(markedIS);
        T value = (T) is.readValue(tag);
        NBTCompoundKey<T, F> compoundKey =
                NBTCompoundKeys.getKeysWithName(key.value(), tag).map(compound -> (NBTCompoundKey<T, F>) compound).orElseThrow(() -> new RuntimeException("Could " +
                        "not " +
                        "find the correct key of '" + key + "' with the tag type of " + tag.getClass().getSimpleName()));
        NBTCompoundEntry<T, F> entry = compoundKey.withRawValue(value);

        return new NetEntryData<>(id.originalPosition(), (int) (id.originalPosition() + markedIS.getCounter()), entry);
    }

    private <T, F> ByteBuffer writeValue(NBTCompoundEntry<T, F> entry) throws IOException {
        ByteArrayOutputStream baOs = new ByteArrayOutputStream();
        NBTOutputStream os = new NBTOutputStream(baOs, false);
        os.writeValue(entry.getRawValue());
        return ByteBuffer.wrap(baOs.toByteArray());
    }
}
