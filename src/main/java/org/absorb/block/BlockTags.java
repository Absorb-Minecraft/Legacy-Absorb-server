package org.absorb.block;

import org.absorb.block.type.BlockType;
import org.absorb.block.type.BlockTypes;
import org.absorb.register.registry.Registry;
import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public enum BlockTags implements BlockTag {

    AIR(Identifiable.MINECRAFT_HOST, "air", "Air", BlockTypes.AIR, BlockTypes.CAVE_AIR, BlockTypes.VOID_AIR);

    private final @NotNull Registry<BlockType>[] blockTypes;
    private final @NotNull String host;
    private final @NotNull String key;
    private final @NotNull String name;

    @SafeVarargs
    BlockTags(@NotNull String host, @NotNull String key, @NotNull String name,
              Registry<BlockType>... blockTypes) {
        this.blockTypes = blockTypes;
        this.host = host;
        this.key = key;
        this.name = name;
    }

    @Override
    public Collection<BlockType> getRegistered() {
        return Arrays.stream(this.getBlockTypes()).map(Supplier::get).collect(Collectors.toUnmodifiableSet());
    }

    public Registry<BlockType>[] getBlockTypes() {
        return this.blockTypes;
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    @Override
    public @NotNull String getKey() {
        return this.key;
    }

    @Override
    public @NotNull String getHost() {
        return this.host;
    }

}
