package org.absorb.block.state.properties.type.number;

import org.absorb.block.state.properties.BlockStatePropertyType;

public interface NumberBlockStatePropertyType<N extends Number> extends BlockStatePropertyType<N> {

    N getMinValue();

    N getMaxValue();
}
