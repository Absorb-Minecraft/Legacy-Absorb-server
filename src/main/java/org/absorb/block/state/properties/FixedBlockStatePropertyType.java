package org.absorb.block.state.properties;

import java.util.Collection;

public interface FixedBlockStatePropertyType<T> extends BlockStatePropertyType<T> {

    Collection<T> getValues();
}
