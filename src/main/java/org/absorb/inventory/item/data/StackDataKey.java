package org.absorb.inventory.item.data;

import org.absorb.files.nbt.compound.NBTCompoundKey;
import org.absorb.register.Typed;
import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.Nullable;

@Typed(getTypesClass = StackDataKeys.class)
public interface StackDataKey<V, T> extends Identifiable {

    NBTCompoundKey<V, T> asCompoundKey();

    StackData<V, T> withDefault();

    default StackData<V, T> with(@Nullable T value) {
        return new SimpleStackData<>(this, value);
    }

}
