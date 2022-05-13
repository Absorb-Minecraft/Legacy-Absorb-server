package org.absorb.state;

public interface AbsorbNumberStateType<N extends Number> extends AbsorbStateType<N> {

    N getMinValue();

    N getMaxValue();
}
