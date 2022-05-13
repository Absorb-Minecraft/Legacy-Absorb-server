package org.absorb.files.nbt.compound;

import me.nullicorn.nedit.type.NBTCompound;
import me.nullicorn.nedit.type.NBTList;
import me.nullicorn.nedit.type.TagType;
import org.absorb.register.AbsorbKey;
import org.absorb.register.Typed;
import org.absorb.world.biome.Biome;
import org.absorb.world.biome.BiomeBuilder;
import org.absorb.world.type.PlayerWorldTypeView;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Typed(getTypesClass = NBTCompoundKeys.class)
public abstract class NBTCompoundKey<T, F> {

    public static class NamedEnum<E extends Enum<E>> extends NBTCompoundKey<String, E> {

        private final EnumSet<? extends E> values;

        NamedEnum(String key, EnumSet<? extends E> set) {
            super(TagType.STRING, key);
            this.values = set;
        }


        @Override
        protected E from(String value) {
            //noinspection unchecked
            return this.values.stream().filter(enu -> enu.name().equals(value.toUpperCase())).findAny().orElseThrow(() -> new IllegalArgumentException(value + " is not a valid enum"));
        }

        @Override
        protected String to(E value) {
            return value.name().toLowerCase();
        }
    }

    public static class BlankedResource extends NBTCompoundKey<String, AbsorbKey> {

        private final Supplier<AbsorbKey> blankKey;

        BlankedResource(String key, Supplier<AbsorbKey> supplier) {
            super(TagType.STRING, key);
            this.blankKey = supplier;
        }

        @Override
        protected AbsorbKey from(String value) {
            if (value.isBlank()) {
                return this.blankKey.get();
            }
            return AbsorbKey.resolve(value);
        }

        @Override
        protected String to(AbsorbKey value) {
            if (value==null) {
                return "";
            }
            return value.asFormatted();
        }
    }

    public static class Resource extends NBTCompoundKey<String, AbsorbKey> {

        Resource(String key) {
            super(TagType.STRING, key);
        }

        @Override
        protected AbsorbKey from(String value) {
            return AbsorbKey.resolve(value);
        }

        @Override
        protected String to(AbsorbKey value) {
            return value.asFormatted();
        }
    }

    public static class Type<C> extends NBTCompoundKey<C, C> {

        Type(TagType tag, String key) {
            super(tag, key);
        }

        @Override
        protected C from(C value) {
            return value;
        }

        @Override
        protected C to(C value) {
            return value;
        }
    }

    public static class Boolean extends NBTCompoundKey<Byte, java.lang.Boolean> {

        Boolean(String key) {
            super(TagType.BYTE, key);
        }

        @Override
        protected java.lang.Boolean from(Byte value) {
            return switch (value) {
                case 0 -> false;
                case 1 -> true;
                default -> throw new RuntimeException("Unknown boolean byte value of " + value);
            };
        }

        @Override
        protected Byte to(java.lang.Boolean value) {
            if (value) {
                return 1;
            }
            return 0;
        }
    }

    public static class BiomeValue extends NBTCompoundKey<NBTList, Collection<Biome>> {

        BiomeValue(String key) {
            super(TagType.LIST, key);
        }

        @Override
        protected Collection<Biome> from(NBTList value) {
            return value.stream().filter(element -> element instanceof NBTCompound).map(g -> new BiomeBuilder().from((NBTCompound) g).build()).toList();
        }

        @Override
        protected NBTList to(Collection<Biome> value) {
            return value.stream().map(Biome::toNBT).collect(Collectors.toCollection(() -> new NBTList(TagType.COMPOUND)));
        }
    }

    public static class Dimension extends NBTCompoundKey<NBTList, Collection<PlayerWorldTypeView>> {

        Dimension(String key) {
            super(TagType.LIST, key);
        }

        @Override
        protected Collection<PlayerWorldTypeView> from(NBTList value) {
            return value.stream().filter(element -> element instanceof NBTCompound).map(element -> PlayerWorldTypeView.of((NBTCompound) element)).collect(Collectors.toSet());
        }

        @Override
        protected NBTList to(Collection<PlayerWorldTypeView> value) {
            return value.stream().map(PlayerWorldTypeView::toNBT).collect(Collectors.toCollection(() -> new NBTList(TagType.COMPOUND)));
        }
    }

    private final TagType tag;
    private final String key;

    private NBTCompoundKey(TagType tag, String key) {
        this.tag = tag;
        this.key = key;
    }

    protected abstract F from(T value);

    protected abstract T to(F value);

    public TagType getTag() {
        return this.tag;
    }

    public String getKey() {
        return this.key;
    }

    public NBTCompoundEntry<T, F> withValue(F value) {
        return NBTCompoundEntry.from(this, value);
    }

    public NBTCompoundEntry<T, F> withRawValue(T value) {
        return new NBTCompoundEntry<>(this, value);
    }

    public Optional<T> getRawValue(@NotNull NBTCompound compound) {
        return Optional.ofNullable((T) compound.get(this.getKey()));
    }

    public Optional<F> getValue(@NotNull NBTCompound compound) {
        return Optional.ofNullable((F) compound.get(this.getKey()));
    }
}
