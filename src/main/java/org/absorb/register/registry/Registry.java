package org.absorb.register.registry;

import org.absorb.utils.Identifiable;

import java.util.function.Supplier;

public interface Registry<T extends Identifiable> extends Supplier<T>, Identifiable {

    default boolean isEqual(T value) {
        return this.getResourceKey().equals(value.getResourceKey());
    }


}
