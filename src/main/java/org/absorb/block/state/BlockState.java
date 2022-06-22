package org.absorb.block.state;

import org.absorb.block.locatable.BlockData;
import org.absorb.block.state.properties.BlockStateProperty;
import org.absorb.block.type.BlockType;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class BlockState {

    private final Collection<BlockStateProperty<?>> properties;
    private final BlockType type;
    private final int id;

    public BlockState(BlockStateBuilder builder) {
        Collection<BlockStateProperty<?>> states = builder.getProperties();
        if (states==null) {
            states = new HashSet<>();
        }
        this.properties = Collections.unmodifiableCollection(states);
        this.type = builder.getType();
        this.id = builder.getId();
    }

    public int getId() {
        return this.id;
    }

    public int getNetworkId(){
        return this.getId() + this.getType().getMinimumNetworkBlockStateId();
    }

    public BlockType getType() {
        return this.type;
    }

    public Collection<BlockStateProperty<?>> getProperties() {
        return this.properties;
    }

    public BlockData asBlockData() {
        return new BlockData(this);
    }
}
