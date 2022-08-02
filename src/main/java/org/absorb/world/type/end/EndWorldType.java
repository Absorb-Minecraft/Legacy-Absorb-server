package org.absorb.world.type.end;

import org.absorb.register.AbsorbKey;
import org.absorb.utils.Identifiable;
import org.absorb.world.area.ChunkPart;
import org.absorb.world.area.GeneratedChunk;
import org.absorb.world.type.WorldType;
import org.absorb.world.type.flat.GeneratedFlatChunk;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class EndWorldType implements WorldType {
    @Override
    public @NotNull String getName() {
        return "The End";
    }

    @Override
    public @NotNull String getKey() {
        return "the_end";
    }

    @Override
    public @NotNull String getHost() {
        return Identifiable.MINECRAFT_HOST;
    }

    @Override
    public boolean willBecomeZombifiedPiglins() {
        return false;
    }

    @Override
    public int getMonsterSpawnLightLevel() {
        return 0;
    }

    @Override
    public int getMonsterSpawnBlockLightLimit() {
        return 0;
    }

    @Override
    public int getNetworkId() {
        return 3;
    }

    @Override
    public boolean isNatural() {
        return false;
    }

    @Override
    public float getAmbientLightLevel() {
        return 0;
    }

    @Override
    public boolean hasSkylight() {
        return false;
    }

    @Override
    public boolean isBedsSafe() {
        return false;
    }

    @Override
    public boolean hasRaids() {
        return true;
    }

    @Override
    public int getMinimumHeight() {
        return 0;
    }

    @Override
    public int getMaximumHeight() {
        return 256;
    }

    @Override
    public int getSafeHeight() {
        return 256;
    }

    @Override
    public float getMultiplier() {
        return 1.0f;
    }

    @Override
    public boolean isUltraWarm() {
        return false;
    }

    @Override
    public boolean isLavaSpreadingQuickly() {
        return false;
    }

    @Override
    public @NotNull AbsorbKey getBasedUpon() {
        return new AbsorbKey(Identifiable.MINECRAFT_HOST, "the_end");
    }

    @Override
    public @NotNull AbsorbKey getInfiniteBurn() {
        return new AbsorbKey(MINECRAFT_HOST, "infiniburn_end");
    }

    @Override
    public boolean isRespawnAnchorUsed() {
        return false;
    }

    @Override
    public Optional<Long> getFixedTime() {
        return Optional.of(6000L);
    }

    @Override
    public @NotNull GeneratedChunk generateChunk(@NotNull ChunkPart part) {
        return new GeneratedFlatChunk();
    }

    @Override
    public int hashCode() {
        return this.getResourceKey().asFormatted().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof WorldType type)) {
            return false;
        }
        return type.getResourceKey().equals(this.getResourceKey());
    }
}
