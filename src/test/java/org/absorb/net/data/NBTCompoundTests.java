package org.absorb.net.data;

import me.nullicorn.nedit.type.NBTCompound;
import org.absorb.files.nbt.compound.NBTCompoundBuilder;
import org.absorb.files.nbt.compound.NBTCompoundKeys;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

public class NBTCompoundTests {

    public static final String TITLE = NBTCompoundKeys.TITLE.getKey();
    public static final String AUTHOR = NBTCompoundKeys.AUTHOR.getKey();

    @Test
    public void testNBTWrite() {
        NBTCompound compound = new NBTCompoundBuilder()
                .add(NBTCompoundKeys.TITLE.withValue("title"))
                .add(NBTCompoundKeys.AUTHOR.withValue("author"))
                .build();

        Assertions.assertTrue(compound.containsKey(AUTHOR));
        Assertions.assertTrue(compound.containsKey(TITLE));
        Assertions.assertEquals("title", compound.getString(TITLE));
        Assertions.assertEquals("author", compound.getString(AUTHOR));
    }

    @Test
    public void testRead() {
        NBTCompound compound = new NBTCompoundBuilder()
                .add(NBTCompoundKeys.TITLE.withValue("title"))
                .add(NBTCompoundKeys.AUTHOR.withValue("author"))
                .build();

        byte[] array = NetSerializers.NBT_COMPOUND_ENTRIES.write(compound).array();


        ByteBuffer buffer = ByteBuffer.wrap(array);
        NBTCompound nbt = NetSerializers.NBT_COMPOUND_ENTRIES.read(0, buffer).value();

        Assertions.assertEquals(compound, nbt);
    }
}
