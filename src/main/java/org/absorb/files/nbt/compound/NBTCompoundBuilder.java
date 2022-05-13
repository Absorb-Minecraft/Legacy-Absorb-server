package org.absorb.files.nbt.compound;

import me.nullicorn.nedit.type.NBTCompound;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class NBTCompoundBuilder implements Builder<NBTCompound> {

    private final Set<NBTCompoundEntry<?, ?>> compoundSet = new HashSet<>();

    public NBTCompoundBuilder add(NBTCompoundEntry<?, ?> entry) {
        this.compoundSet.add(entry);
        return this;
    }

    public NBTCompoundBuilder addAll(NBTCompoundEntry<?, ?>... array) {
        this.compoundSet.addAll(Arrays.asList(array));
        return this;
    }

    public NBTCompoundBuilder addAll(Collection<? extends NBTCompoundEntry<?, ?>> collection) {
        this.compoundSet.addAll(collection);
        return this;
    }

    @Override
    public @NotNull NBTCompound build() {
        NBTCompound compound = new NBTCompound();
        Map<String, Object> map =
                this.compoundSet.stream().collect(Collectors.toMap(entry -> entry.getKey().getKey(),
                        NBTCompoundEntry::getRawValue));
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof Long[] array) {
                long[] newArray = new long[array.length];
                for (int i = 0; i < array.length; i++) {
                    newArray[i] = array[i];
                }
                entry.setValue(newArray);
            }
        }
        compound.putAll(map);
        return compound;
    }

    @Override
    public @NotNull Builder<NBTCompound> reset() {
        this.compoundSet.clear();
        return this;
    }

    @Override
    public @NotNull Builder<NBTCompound> copy() {
        return new NBTCompoundBuilder().addAll(this.compoundSet);
    }
}
