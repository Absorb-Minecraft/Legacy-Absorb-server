package org.absorb.module;

import org.absorb.module.loader.ModuleLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public abstract class Module {

    private final @NotNull String mainClass;
    private final @Nullable String displayName;
    private final @NotNull String keyName;
    private final @NotNull ModuleVersion version;
    private final @Nullable String description;
    private final Collection<ModuleDependency> dependencies = new HashSet<>();

    public Module(@NotNull ModuleBuilder builder) {
        this.dependencies.addAll(builder.getDependencies());
        this.mainClass = builder.getMainClass();
        this.displayName = builder.getDisplayName();
        this.description = builder.getDescription();
        this.version = builder.getVersion();
        this.keyName = builder.getKeyName();
    }

    public abstract ModuleLoader<?> getLoader();

    public @NotNull String getMainClass() {
        return this.mainClass;
    }

    public @Nullable String getDisplayName() {
        return this.displayName;
    }

    public @NotNull String getKeyName() {
        return this.keyName;
    }

    public @NotNull ModuleVersion getVersion() {
        return this.version;
    }

    public Optional<String> getDescription() {
        return Optional.ofNullable(this.description);
    }

    public Collection<ModuleDependency> getDependencies() {
        return this.dependencies;
    }

    public <T extends Module> void load() throws IOException {
        ModuleLoader<T> loader = (ModuleLoader<T>) this.getLoader();
        loader.load((T) this);
    }
}
