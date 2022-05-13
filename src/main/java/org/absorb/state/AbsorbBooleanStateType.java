package org.absorb.state;

import java.util.Collection;
import java.util.Set;

public interface AbsorbBooleanStateType extends AbsorbFixedStateType<Boolean> {

    @Override
    default Collection<Boolean> getValues() {
        return Set.of(false, true);
    }
}
