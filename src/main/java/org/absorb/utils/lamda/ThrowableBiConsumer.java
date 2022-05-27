package org.absorb.utils.lamda;

public interface ThrowableBiConsumer<F, S, T extends Throwable> {

    void apply(F first, S second) throws T;
}
