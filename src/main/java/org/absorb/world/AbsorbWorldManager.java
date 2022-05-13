package org.absorb.world;

import org.absorb.register.AbsorbKey;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.LinkedTransferQueue;

public class AbsorbWorldManager {

    private final LinkedTransferQueue<AbsorbWorld> worlds = new LinkedTransferQueue<>();
    private AbsorbWorld defaultWorld;

    public AbsorbWorldManager(@NotNull AbsorbWorld world) {
        this.defaultWorld = world;
    }

    public void setDefaultWorld(@NotNull AbsorbWorld world) {
        this.defaultWorld = world;
    }

    public Optional<AbsorbWorld> getWorld(AbsorbKey key) {
        return this.worlds.parallelStream().filter(world -> world.getKey().equals(key)).findAny();
    }

    public AbsorbWorld defaultWorld() {
        return this.defaultWorld;
    }

    public Collection<AbsorbWorld> worlds() {
        return Collections.unmodifiableCollection(this.worlds);
    }

}
