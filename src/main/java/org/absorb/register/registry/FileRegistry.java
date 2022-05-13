package org.absorb.register.registry;

import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

public class FileRegistry<T extends Identifiable> extends SingletonRegistry<T> {

    public FileRegistry(@NotNull String host, @NotNull String key, @NotNull String name) {
        super(host, key, name);
    }

    @Override
    protected T getSingleton() {
        throw new RuntimeException("Not implemented yet");
    }
}
