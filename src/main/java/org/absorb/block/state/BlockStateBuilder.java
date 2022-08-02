package org.absorb.block.state;

import org.absorb.block.state.properties.BlockStateProperty;
import org.absorb.block.type.BlockType;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;

public class BlockStateBuilder implements Builder<BlockState> {

    private Collection<BlockStateProperty<?>> properties;
    private BlockType type;
    private int id;

    public Collection<BlockStateProperty<?>> getProperties() {
        return this.properties;
    }

    public BlockStateBuilder setProperties(Collection<BlockStateProperty<?>> states) {
        this.properties = states;
        return this;
    }

    public BlockType getType() {
        return this.type;
    }

    public BlockStateBuilder setType(BlockType type) {
        this.type = type;
        return this;
    }

    public int getId() {
        return this.id;
    }

    public BlockStateBuilder setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public BlockState build() {
        return new BlockState(this);
    }

    @Override
    public Builder<BlockState> reset() {
        this.properties = new HashSet<>();
        this.type = null;
        this.id = 0;
        return this;
    }

    @Override
    public Builder<BlockState> copy() {
        return new BlockStateBuilder().setProperties(this.getProperties()).setId(this.getId()).setType(this.getType());
    }

    @Override
    public @NotNull Builder<BlockState> from(BlockState value) {
        this.properties.addAll(value.getProperties());
        this.id = value.getId();
        this.type = value.getType();
        return this;
    }
}
