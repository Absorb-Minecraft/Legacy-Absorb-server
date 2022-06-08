package org.absorb.module;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.concurrent.LinkedTransferQueue;

public class ModuleManager {

    private final Collection<Module> modules = new LinkedTransferQueue<>();

    public Collection<Module> getModules() {
        return this.modules;
    }

    public void registerModule(@NotNull Module module) {
        this.modules.add(module);
    }

}
