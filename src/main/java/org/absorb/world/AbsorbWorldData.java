package org.absorb.world;

import org.absorb.register.AbsorbKey;
import org.absorb.world.type.WorldType;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3i;

public class AbsorbWorldData {

    private AbsorbKey key;
    private long seed;
    private @NotNull Difficulty difficulty = Difficulty.PEACEFUL;
    private WorldType type;
    private @NotNull Vector3i compassPoint = new Vector3i(0, 0, 0);
    private @NotNull Vector3i spawnPoint = new Vector3i(0, 0, 0);

    public @NotNull Vector3i getCompassPoint() {
        return this.compassPoint;
    }

    public AbsorbWorldData setCompassPoint(@NotNull Vector3i compassPoint) {
        this.compassPoint = compassPoint;
        return this;
    }

    public @NotNull Vector3i getSpawnPoint() {
        return this.spawnPoint;
    }

    public AbsorbWorldData setSpawnPoint(@NotNull Vector3i spawnPoint) {
        this.spawnPoint = spawnPoint;
        return this;
    }

    public @NotNull Difficulty getDifficulty() {
        return this.difficulty;
    }

    public AbsorbWorldData setDifficulty(@NotNull Difficulty difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public WorldType getType() {
        return this.type;
    }

    public AbsorbWorldData setType(WorldType type) {
        this.type = type;
        return this;
    }

    public AbsorbKey getKey() {
        return this.key;
    }

    public AbsorbWorldData setKey(AbsorbKey key) {
        this.key = key;
        return this;
    }

    public long getSeed() {
        return this.seed;
    }

    public AbsorbWorldData setSeed(long seed) {
        this.seed = seed;
        return this;
    }
}
