package org.absorb.event.events.module.load.construct;

import org.absorb.event.Event;
import org.absorb.event.cause.EventCause;
import org.absorb.module.Module;
import org.absorb.module.loader.ModuleLoader;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;

public class ConstructModuleEvent implements Event {

    private final @NotNull Module module;
    private final @NotNull ModuleLoader<? extends Module> loader;

    public <T extends Module> ConstructModuleEvent(@NotNull T module, @NotNull ModuleLoader<T> loader) {
        this.loader = loader;
        this.module = module;
    }

    @Override
    public @NotNull EventCause willCause() {
        return new EventCause(Collections.emptyList());
    }

    @Override
    public @NotNull EventCause hasCaused() {
        return new EventCause(Collections.emptyList());
    }

    @Override
    public Event copy() {
        return this.createCopy();
    }

    private <T extends Module> ConstructModuleEvent createCopy() {
        return new ConstructModuleEvent((T) this.module, (ModuleLoader<T>) this.loader);
    }
}
