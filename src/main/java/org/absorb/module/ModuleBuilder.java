package org.absorb.module;

import org.absorb.module.loader.ModuleLoader;
import org.absorb.module.version.ModuleVersion;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;

public abstract class ModuleBuilder implements Builder<Module> {

    protected final Collection<ModuleDependency> dependencies = new HashSet<>();
    protected String mainClass;
    protected String displayName;
    protected String keyName;
    protected ModuleVersion version;
    protected String description;

    public String getMainClass() {
        return this.mainClass;
    }

    public ModuleBuilder setMainClass(String mainClass) {
        this.mainClass = mainClass;
        return this;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public ModuleBuilder setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public String getKeyName() {
        return this.keyName;
    }

    public ModuleBuilder setKeyName(String keyName) {
        this.keyName = keyName;
        return this;
    }

    public ModuleVersion getVersion() {
        return this.version;
    }

    public ModuleBuilder setVersion(ModuleVersion version) {
        this.version = version;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public ModuleBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public Collection<ModuleDependency> getDependencies() {
        return this.dependencies;
    }

    public abstract ModuleLoader<?> getLoader();

    @Override
    public @NotNull Builder<Module> from(Module value) {
        this.description = value.getDescription().orElse(null);
        this.displayName = value.getDisplayName();
        this.keyName = value.getKeyName();
        this.version = value.getVersion();
        this.mainClass = value.getMainClass();
        return this;
    }
}
