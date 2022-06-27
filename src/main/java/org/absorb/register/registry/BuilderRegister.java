package org.absorb.register.registry;

import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class BuilderRegister<I extends Identifiable> implements MemoryBuilderRegistry<I> {

    private @Nullable I built;
    private final @NotNull Supplier<I> build;
    private final @NotNull String name;
    private final @NotNull String key;
    private final @NotNull String host;

    public BuilderRegister(@NotNull String name, @NotNull String host, @NotNull String key, @NotNull Supplier<I> build) {
        this.build = build;
        this.key = key;
        this.name = name;
        this.host = host;
    }

    @Override
    public I get() {
        if (this.built==null) {
            I result = this.build.get();
            if (!result.getKey().equals(this.getKey())) {
                throw new RuntimeException("Keys do not match");
            }
            if (!result.getHost().equals(this.getHost())) {
                throw new RuntimeException("Hosts do not match");
            }
            if (!result.getName().equals(this.getName())) {
                throw new RuntimeException("Name does not match");
            }
            this.built = result;
        }
        return this.built;
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
