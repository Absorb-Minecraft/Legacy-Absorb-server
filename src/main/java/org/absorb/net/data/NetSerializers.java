package org.absorb.net.data;

import org.absorb.net.data.inventory.NetSlot;
import org.absorb.net.data.nbt.NetNBTCompound;
import org.absorb.net.data.nbt.NetNBTEntry;
import org.absorb.net.data.number.*;
import org.absorb.net.data.number.array.NetBitSet;
import org.absorb.net.data.number.array.NetByteArray;
import org.absorb.net.data.number.array.NetLongArray;
import org.absorb.net.data.string.NetChat;
import org.absorb.net.data.string.NetKey;
import org.absorb.net.data.string.NetShortString;
import org.absorb.net.data.string.NetString;

public class NetSerializers {

    public static final NetByte BYTE = new NetByte();
    public static final NetVarInteger VAR_INTEGER = new NetVarInteger();
    public static final NetString STRING = new NetString();
    public static final NetShortString SHORT_STRING = new NetShortString();
    public static final NetShort SHORT = new NetShort();
    public static final NetLong LONG = new NetLong();
    public static final NetLongUnsigned UNSIGNED_LONG = new NetLongUnsigned();
    public static final NetInteger INTEGER = new NetInteger();
    public static final NetDouble DOUBLE = new NetDouble();
    public static final NetShortUnsigned UNSIGNED_SHORT = new NetShortUnsigned();
    public static final NetFloat FLOAT = new NetFloat();
    public static final NetChat CHAT = new NetChat();
    public static final NetUniqueIdentifier UUID = new NetUniqueIdentifier();
    public static final NetBitSet BITSET = new NetBitSet();
    public static final NetBoolean BOOLEAN = new NetBoolean();
    public static final NetNBTEntry NBT_COMPOUND_ENTRY = new NetNBTEntry();
    public static final NetNBTCompound NBT_COMPOUND_ENTRIES = new NetNBTCompound();
    public static final NetLongArray LONG_ARRAY = new NetLongArray();
    public static final NetKey RESOURCE_KEY = new NetKey();
    public static final NetSlot SLOT = new NetSlot();
    public static final NetPosition POSITION = new NetPosition();

    public static NetByteArray byteArray(int length) {
        return new NetByteArray(length);
    }
}
