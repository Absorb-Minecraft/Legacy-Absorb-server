package org.absorb.register.registry;

import org.absorb.utils.NetworkIdentifiable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class NetworkBuilderRegistry<I extends NetworkIdentifiable> implements MemoryBuilderRegistry<I> {

    private @Nullable I built;
    private final @NotNull Function<Integer, I> build;
    private final String name;
    private final String key;
    private final String host;

    public NetworkBuilderRegistry(String name, String host, String key, @NotNull Function<Integer, I> build) {
        this.build = build;
        this.name = name;
        this.key = key;
        this.host = host;
    }

    public I create(int id) {
        this.built = this.build.apply(id);
        if (!this.built.getHost().equals(this.getHost())) {
            throw new RuntimeException("Hosts don't match");
        }
        if (!this.built.getKey().equals(this.getKey())) {
            throw new RuntimeException("Keys don't match");
        }
        if (!this.built.getName().equals(this.getName())) {
            throw new RuntimeException("Names don't match");
        }
        if (this.built.getNetworkId()!=id) {
            throw new RuntimeException("Network id don't match");
        }
        return this.built;
    }

    @Override
    public I get() {
        if (this.built==null) {
            throw new RuntimeException("Register has not been created yet");
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
