package org.absorb.block;

import org.absorb.block.type.BlockType;
import org.absorb.register.registry.Registry;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CustomBlockTag implements BlockTag {

    private Registry<BlockType>[] blockTypes;
    private @NotNull String host;
    private @NotNull String key;
    private @NotNull String name;

    @SafeVarargs
    public CustomBlockTag(@NotNull String host, @NotNull String key, @NotNull String name,
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
