package org.absorb.inventory.item.data.damage;

import org.absorb.files.nbt.compound.NBTCompoundKey;
import org.absorb.files.nbt.compound.NBTCompoundKeys;
import org.absorb.inventory.item.data.SimpleStackData;
import org.absorb.inventory.item.data.StackData;
import org.absorb.inventory.item.data.StackDataKey;
import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

public class ItemStackDamageKey implements StackDataKey<Integer, Integer> {
    @Override
    public NBTCompoundKey<Integer, Integer> asCompoundKey() {
        return NBTCompoundKeys.ITEM_DAMAGE;
    }

    @Override
    public StackData<Integer, Integer> withDefault() {
        return new SimpleStackData<>(this, 0);
    }

    @Override
    public @NotNull String getName() {
        return "Damage";
    }

    @Override
    public @NotNull String getKey() {
        return "damage";
    }

    @Override
    public @NotNull String getHost() {
        return Identifiable.MINECRAFT_HOST;
    }
}
