package org.absorb.block.locatable;

import org.absorb.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BlockData {

    private final @NotNull BlockState state;
    private long blockLight;
    private long skyLight;

    public BlockData(@NotNull BlockState state) {
        this.state = state;
    }

    public @NotNull BlockState getState() {
        return this.state;
    }

    public long getBlockLight() {
        return this.blockLight;
    }

    public BlockData setBlockLight(long blockLight) {
        this.blockLight = blockLight;
        return this;
    }

    public long getSkyLight() {
        return this.skyLight;
    }

    public BlockData setSkyLight(long skyLight) {
        this.skyLight = skyLight;
        return this;
    }
}
