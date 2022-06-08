package org.absorb.module;

import org.absorb.module.version.ModuleVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ModuleDependency {

    private final @NotNull String moduleId;
    private @Nullable ModuleVersion minimumVersion;
    private @Nullable ModuleVersion maximumVersion;
    private boolean isOptional;
    private boolean loadDependencyAfter;

    public ModuleDependency(@NotNull String moduleId) {
        this.moduleId = moduleId;
    }

    public Optional<ModuleVersion> getMaximumVersion() {
        return Optional.ofNullable(this.maximumVersion);
    }

    public Optional<ModuleVersion> getMinimumVersion() {
        return Optional.ofNullable(this.minimumVersion);
    }

    public @NotNull String getModuleId() {
        return this.moduleId;
    }

    public boolean isOptional() {
        return this.isOptional;
    }

    public boolean isLoadDependencyAfter() {
        return this.loadDependencyAfter;
    }

    public ModuleDependency setMinimumVersion(ModuleVersion minimumVersion) {
        this.minimumVersion = minimumVersion;
        return this;
    }

    public ModuleDependency setMaximumVersion(ModuleVersion maximumVersion) {
        this.maximumVersion = maximumVersion;
        return this;
    }

    public ModuleDependency setOptional(boolean optional) {
        this.isOptional = optional;
        return this;
    }

    public ModuleDependency setLoadDependencyAfter(boolean loadDependencyAfter) {
        this.loadDependencyAfter = loadDependencyAfter;
        return this;
    }
}
