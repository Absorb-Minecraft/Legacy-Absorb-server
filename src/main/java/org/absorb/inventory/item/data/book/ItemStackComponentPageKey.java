package org.absorb.inventory.item.data.book;

import me.nullicorn.nedit.type.NBTList;
import net.kyori.adventure.text.Component;
import org.absorb.files.nbt.compound.NBTCompoundKey;
import org.absorb.files.nbt.compound.NBTCompoundKeys;
import org.absorb.inventory.item.data.SimpleStackData;
import org.absorb.inventory.item.data.StackData;
import org.absorb.inventory.item.data.StackDataKey;
import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class ItemStackComponentPageKey implements StackDataKey<NBTList, List<Component>> {
    @Override
    public NBTCompoundKey<NBTList, List<Component>> asCompoundKey() {
        return NBTCompoundKeys.COMPONENT_PAGES;
    }

    @Override
    public StackData<NBTList, List<Component>> withDefault() {
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
