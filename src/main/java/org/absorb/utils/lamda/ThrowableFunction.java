package org.absorb.utils.lamda;

public interface ThrowableFunction<O, R, T extends Throwable> {

    R apply(O value) throws T;
}
