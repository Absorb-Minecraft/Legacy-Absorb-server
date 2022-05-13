package org.absorb.net.data;

import org.absorb.net.data.inventory.SlotSerializer;
import org.absorb.net.data.nbt.NBTTagCompoundEntrySerializer;
import org.absorb.net.data.nbt.NBTTagCompoundGroupSerializer;
import org.absorb.net.data.number.*;
import org.absorb.net.data.number.array.BitSetSerializer;
import org.absorb.net.data.number.array.LongArraySerializer;
import org.absorb.net.data.string.*;

public class Serializers {

    public static final ByteSerializer BYTE = new ByteSerializer();
    public static final VarIntegerSerializer VAR_INTEGER = new VarIntegerSerializer();
    public static final StringSerializer STRING = new StringSerializer();
    public static final ShortDefinedStringSerializer SHORT_STRING = new ShortDefinedStringSerializer();
    public static final ShortSerializer SHORT = new ShortSerializer();
    public static final LongSerializer LONG = new LongSerializer();
    public static final IntegerSerializer INTEGER = new IntegerSerializer();
    public static final DoubleSerializer DOUBLE = new DoubleSerializer();
    public static final UnsignedShortSerializer UNSIGNED_SHORT = new UnsignedShortSerializer();
    public static final FloatSerializer FLOAT = new FloatSerializer();
    public static final ChatSerializer CHAT = new ChatSerializer();
    public static final UUIDSerializer UUID = new UUIDSerializer();
    public static final BitSetSerializer BITSET = new BitSetSerializer();
    public static final BooleanSerializer BOOLEAN = new BooleanSerializer();
    public static final NBTTagCompoundEntrySerializer NBT_COMPOUND_ENTRY = new NBTTagCompoundEntrySerializer();
    public static final NBTTagCompoundGroupSerializer NBT_COMPOUND_ENTRIES = new NBTTagCompoundGroupSerializer();
    public static final LongArraySerializer LONG_ARRAY = new LongArraySerializer();
    public static final ResourceKeySerializer RESOURCE_KEY = new ResourceKeySerializer();
    public static final SlotSerializer SLOT = new SlotSerializer();
    public static final PositionSerializer POSITION = new PositionSerializer();

    public static FixedSizeStringSerializer fixedSizeString(int size) {
        return new FixedSizeStringSerializer(size);
    }
}
