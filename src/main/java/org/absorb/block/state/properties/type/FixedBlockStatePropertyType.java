package org.absorb.block.state.properties.type;

import org.absorb.block.state.properties.BlockStatePropertyType;

import java.util.Collection;

public interface FixedBlockStatePropertyType<T> extends BlockStatePropertyType<T> {

    Collection<T> getValues();
}
