package org.absorb.module.loader;

import org.absorb.module.Module;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public interface FileModuleLoader<M extends Module> extends ModuleLoader<M> {

    boolean canLoad(@NotNull File module);

    @NotNull Module create(@NotNull File module) throws IOException;
}
