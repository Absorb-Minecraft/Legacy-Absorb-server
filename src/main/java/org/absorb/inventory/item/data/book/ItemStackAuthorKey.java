package org.absorb.inventory.item.data.book;

import org.absorb.files.nbt.compound.NBTCompoundKey;
import org.absorb.files.nbt.compound.NBTCompoundKeys;
import org.absorb.inventory.item.data.SimpleStackData;
import org.absorb.inventory.item.data.StackData;
import org.absorb.inventory.item.data.StackDataKey;
import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

public class ItemStackAuthorKey implements StackDataKey<String, String> {
    @Override
    public NBTCompoundKey<String, String> asCompoundKey() {
        return NBTCompoundKeys.AUTHOR;
    }

    @Override
    public StackData<String, String> withDefault() {
        return new SimpleStackData<>(this, null);
    }

    @Override
    public @NotNull String getName() {
        return "Author";
    }

    @Override
    public @NotNull String getKey() {
        return "author";
    }

    @Override
    public @NotNull String getHost() {
        return Identifiable.ABSORB_HOST;
    }
}
