package org.absorb.block.state.properties;

import java.util.EnumSet;

public interface EnumBlockStatePropertyType<E extends Enum<E>> extends FixedBlockStatePropertyType<E> {

    @Override
    EnumSet<E> getValues();
}
