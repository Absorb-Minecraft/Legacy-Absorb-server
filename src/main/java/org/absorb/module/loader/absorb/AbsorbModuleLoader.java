package org.absorb.module.loader.absorb;

import org.absorb.module.Module;
import org.absorb.module.loader.FileModuleLoader;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class AbsorbModuleLoader implements FileModuleLoader<AbsorbModule> {
    @Override
    public boolean canLoad(@NotNull File module) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public @NotNull Module create(@NotNull File module) throws IOException {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public void load(@NotNull AbsorbModule module) throws IOException {
        throw new RuntimeException("Not implemented yet");

    }
}
