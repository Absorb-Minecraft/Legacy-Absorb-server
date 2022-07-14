package org.absorb.world;

import org.absorb.register.AbsorbKey;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.LinkedTransferQueue;

public class WorldManager {

    private final LinkedTransferQueue<World> worlds = new LinkedTransferQueue<>();
    private World defaultWorld;

    public WorldManager(@NotNull World world) {
        this.defaultWorld = world;
    }

    public void setDefaultWorld(@NotNull World world) {
        this.defaultWorld = world;
    }

    public Optional<World> getWorld(AbsorbKey key) {
        return this.worlds.parallelStream().filter(world -> world.getKey().equals(key)).findAny();
    }

    public World defaultWorld() {
        return this.defaultWorld;
    }

    public Collection<World> worlds() {
        return Collections.unmodifiableCollection(this.worlds);
    }

}
