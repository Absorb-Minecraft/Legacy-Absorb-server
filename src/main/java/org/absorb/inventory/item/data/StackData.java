package org.absorb.inventory.item.data;

import org.absorb.files.nbt.compound.NBTCompoundEntry;

import java.util.Optional;

public interface StackData<V, T> {

    StackDataKey<V, T> getKey();

    Optional<T> get();

    default NBTCompoundEntry<V, T> asCompoundEntry() {
        return this.getKey().asCompoundKey().withValue(this.get().orElse(null));
    }

}
