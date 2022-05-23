package org.absorb.module.loader.absorb;

import org.absorb.module.Module;
import org.absorb.module.ModuleBuilder;
import org.absorb.module.loader.ModuleLoader;
import org.absorb.module.loader.ModuleLoaders;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class AbsorbModule extends Module {

    private File load;

    public AbsorbModule(@NotNull ModuleBuilder builder) {
        super(builder);
    }

    @Override
    public ModuleLoader getLoader() {
        return ModuleLoaders.ABSORB_MODULE;
    }
}
