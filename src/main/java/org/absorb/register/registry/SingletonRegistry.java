package org.absorb.register.registry;

import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class SingletonRegistry<T extends Identifiable> implements Registry<T> {

    private @Nullable T value;
    private final @NotNull String host;
    private final @NotNull String key;
    private final @NotNull String name;

    public SingletonRegistry(@NotNull String host, @NotNull String key, @NotNull String name){
        this.host = host;
        this.key = key;
        this.name = name;
    }

    protected abstract T getSingleton();

    @Override
    public T get() {
        if (value==null) {
            synchronized (this) {
                if (value!=null) {
                    return this.value;
                }
                this.value = this.getSingleton();
            }
        }
        return this.value;
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    @Override
    public @NotNull String getKey() {
        return this.key;
    }

    @Override
    public @NotNull String getHost() {
        return this.host;
    }
}
