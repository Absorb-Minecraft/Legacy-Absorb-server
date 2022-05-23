package org.absorb.module.loader;

import org.absorb.module.Module;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public interface ModuleLoader<M extends Module> {

    void load(@NotNull M module) throws IOException;
}
