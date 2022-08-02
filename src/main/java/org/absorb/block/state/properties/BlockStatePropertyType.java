package org.absorb.block.state.properties;

import org.absorb.utils.Identifiable;

public interface BlockStatePropertyType<V> extends Identifiable {

    default BlockStateProperty<V> withValue(V value) {
        return new BlockStateProperty<>(this, value);
    }
}
