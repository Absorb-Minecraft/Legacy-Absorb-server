package org.absorb.inventory.item.data.book;

import me.nullicorn.nedit.type.NBTList;
import org.absorb.files.nbt.compound.NBTCompoundKey;
import org.absorb.files.nbt.compound.NBTCompoundKeys;
import org.absorb.inventory.item.data.SimpleStackData;
import org.absorb.inventory.item.data.StackData;
import org.absorb.inventory.item.data.StackDataKey;
import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;

public class ItemStackSimplePageKey implements StackDataKey<NBTList, Collection<String>> {
    @Override
    public NBTCompoundKey<NBTList, Collection<String>> asCompoundKey() {
        return NBTCompoundKeys.PAGES;
    }

    @Override
    public StackData<NBTList, Collection<String>> withDefault() {
        return new SimpleStackData<>(this, Collections.emptyList());
    }

    @Override
    public @NotNull String getName() {
        return "Pages";
    }

    @Override
    public @NotNull String getKey() {
        return "pages";
    }

    @Override
    public @NotNull String getHost() {
        return Identifiable.ABSORB_HOST;
    }
}
