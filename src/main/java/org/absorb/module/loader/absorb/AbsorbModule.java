package org.absorb.module.loader.absorb;

import org.absorb.module.Module;
import org.absorb.module.loader.ModuleLoaders;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class AbsorbModule extends Module {

    private final @NotNull File load;

    public AbsorbModule(@NotNull AbsorbModuleBuilder builder) {
        super(builder);
        this.load = builder.getFile();
        if (this.load==null) {
            throw new IllegalStateException("Module must have file set");
        }
    }

    public File getFile() {
        return this.load;
    }

    @Override
    public AbsorbModuleLoader getLoader() {
        return ModuleLoaders.ABSORB_MODULE;
    }
}
