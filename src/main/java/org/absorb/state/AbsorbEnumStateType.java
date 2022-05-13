package org.absorb.state;

import java.util.EnumSet;

public interface AbsorbEnumStateType<E extends Enum<E>> extends AbsorbFixedStateType<E> {

    @Override
    EnumSet<E> getValues();
}
