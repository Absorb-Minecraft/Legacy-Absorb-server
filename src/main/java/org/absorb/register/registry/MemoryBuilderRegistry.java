package org.absorb.register.registry;

import org.absorb.utils.Identifiable;

public interface MemoryBuilderRegistry<T extends Identifiable> extends Registry<T> {

    static <I extends Identifiable> BuilderRegister<I> of(I value) {
        return new BuilderRegister<>(value.getName(), value.getHost(), value.getKey(), () -> value);
    }

}
