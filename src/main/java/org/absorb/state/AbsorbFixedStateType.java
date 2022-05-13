package org.absorb.state;

import java.util.Collection;

public interface AbsorbFixedStateType<T> extends AbsorbStateType<T> {

    Collection<T> getValues();
}
