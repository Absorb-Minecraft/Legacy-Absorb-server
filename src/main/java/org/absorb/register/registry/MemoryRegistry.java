package org.absorb.register.registry;

import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

public class MemoryRegistry <T extends Identifiable> implements Registry<T>{

    private final @NotNull T value;

    public MemoryRegistry(@NotNull T value){
        this.value = value;
    }

    @Override
    public T get() {
        return this.value;
    }

    @Override
    public @NotNull String getName() {
        return this.value.getName();
    }

    @Override
    public @NotNull String getKey() {
        return this.value.getKey();
    }

    @Override
    public @NotNull String getHost() {
        return this.value.getHost();
    }
}
