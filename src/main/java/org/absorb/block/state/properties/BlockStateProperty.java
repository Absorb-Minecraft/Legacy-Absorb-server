package org.absorb.block.state.properties;

public class BlockStateProperty<V> {

    private final BlockStatePropertyType<V> type;
    private final V value;

    public BlockStateProperty(BlockStatePropertyType<V> type, V value) {
        this.type = type;
        this.value = value;
    }

    public BlockStatePropertyType<V> getType() {
        return this.type;
    }

    public V getValue() {
        return this.value;
    }
}
