package org.absorb.block.state.properties;

public interface NumberBlockStatePropertyType<N extends Number> extends BlockStatePropertyType<N> {

    N getMinValue();

    N getMaxValue();
}
