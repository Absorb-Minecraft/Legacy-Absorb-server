package org.absorb.files.nbt.compound;


import me.nullicorn.nedit.type.TagType;

public class NBTCompoundEntry<T, F> {

    private final NBTCompoundKey<T, F> key;
    private final T value;

    public NBTCompoundEntry(NBTCompoundKey<T, F> key, T value) {
        this.key = key;
        this.value = value;
    }

    public TagType getTag() {
        return this.getKey().getTag();
    }

    public NBTCompoundKey<T, F> getKey() {
        return this.key;
    }

    public T getRawValue() {
        return this.value;
    }

    public F getValue() {
        return this.key.from(this.value);
    }

    public static <E, G> NBTCompoundEntry<E, G> from(NBTCompoundKey<E, G> key, G value) {
        return new NBTCompoundEntry<>(key, key.to(value));
    }
}
