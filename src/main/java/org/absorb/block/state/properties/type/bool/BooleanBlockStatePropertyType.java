package org.absorb.block.state.properties.type.bool;

import org.absorb.block.state.properties.type.FixedBlockStatePropertyType;

import java.util.Collection;
import java.util.Set;

public interface BooleanBlockStatePropertyType extends FixedBlockStatePropertyType<Boolean> {

    @Override
    default Collection<Boolean> getValues() {
        return Set.of(false, true);
    }
}
