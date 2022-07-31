package org.absorb.module.loader.absorb;

import org.absorb.module.Module;
import org.absorb.module.ModuleBuilder;
import org.absorb.module.loader.ModuleLoaders;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class AbsorbModuleBuilder extends ModuleBuilder {

    private File file;

    public File getFile() {
        return this.file;
    }

    public AbsorbModuleBuilder setFile(File file) {
        this.file = file;
        return this;
    }

    @Override
    public AbsorbModuleLoader getLoader() {
        return ModuleLoaders.ABSORB_MODULE;
    }

    @Override
    public @NotNull Builder<Module> from(Module value) {
        if (value instanceof AbsorbModule module) {
            this.file = module.getFile();
        }
        return super.from(value);
    }

    @Override
    public @NotNull AbsorbModule build() {
        return new AbsorbModule(this);
    }

    @Override
    public @NotNull Builder<Module> reset() {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public @NotNull Builder<Module> copy() {
        throw new RuntimeException("Not implemented yet");
    }
}
