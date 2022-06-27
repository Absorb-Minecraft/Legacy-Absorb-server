package org.absorb.block;

import org.absorb.block.type.BlockType;
import org.absorb.register.AbsorbKey;
import org.absorb.register.Typed;
import org.absorb.register.registry.Registry;
import org.absorb.utils.Identifiable;
import org.absorb.utils.tag.Tag;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Typed(getTypesClass = BlockTags.class)
public interface BlockTag extends Tag<BlockType> {

    @NotNull Registry<BlockType>[] getBlockTypes();

    @Override
    default @NotNull Collection<BlockType> getRegistered() {
        return Arrays.stream(this.getBlockTypes()).map(Supplier::get).collect(Collectors.toUnmodifiableSet());
    }

    default boolean contains(@NotNull AbsorbKey key) {
        return Arrays.stream(this.getBlockTypes()).anyMatch(r -> r.getResourceKey().equals(key));
    }

    default boolean contains(@NotNull Identifiable type) {
        return this.contains(type.getResourceKey());
    }

}
