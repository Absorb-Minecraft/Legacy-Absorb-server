package org.absorb.block.state.properties.type.enu;

import org.absorb.block.state.properties.type.FixedBlockStatePropertyType;

import java.util.EnumSet;

public interface EnumBlockStatePropertyType<E extends Enum<E>> extends FixedBlockStatePropertyType<E> {

    @Override
    EnumSet<E> getValues();
}
