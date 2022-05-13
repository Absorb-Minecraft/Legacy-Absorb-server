package org.absorb.block.state;

import org.jetbrains.annotations.NotNull;

public class FullBlockState {

    private final @NotNull AbsorbBlockState state;
    private long blockLight;
    private long skyLight;

    public FullBlockState(@NotNull AbsorbBlockState state) {
        this.state = state;
    }

    public @NotNull AbsorbBlockState getState() {
        return this.state;
    }

    public long getBlockLight() {
        return this.blockLight;
    }

    public FullBlockState setBlockLight(long blockLight) {
        this.blockLight = blockLight;
        return this;
    }

    public long getSkyLight() {
        return this.skyLight;
    }

    public FullBlockState setSkyLight(long skyLight) {
        this.skyLight = skyLight;
        return this;
    }
}
