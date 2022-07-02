package org.absorb.world.type.nether;

import org.absorb.register.AbsorbKey;
import org.absorb.utils.Identifiable;
import org.absorb.world.area.ChunkPart;
import org.absorb.world.area.GeneratedChunk;
import org.absorb.world.type.WorldType;
import org.absorb.world.type.flat.GeneratedFlatChunk;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class NetherWorldType implements WorldType {
    @Override
    public @NotNull String getName() {
        return "The Nether";
    }

    @Override
    public @NotNull String getKey() {
        return "the_nether";
    }

    @Override
    public @NotNull String getHost() {
        return Identifiable.MINECRAFT_HOST;
    }

    @Override
    public boolean willBecomeZombifiedPiglins() {
        return true;
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
        return 2;
    }

    @Override
    public boolean isNatural() {
        return false;
    }

    @Override
    public float getAmbientLightLevel() {
        return 0.1f;
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
        return false;
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
        return 128;
    }

    @Override
    public float getMultiplier() {
        return 8.0f;
    }

    @Override
    public boolean isUltraWarm() {
        return true;
    }

    @Override
    public boolean isLavaSpreadingQuickly() {
        return true;
    }

    @Override
    public @NotNull AbsorbKey getBasedUpon() {
        return new AbsorbKey(MINECRAFT_HOST, "the_nether");
    }

    @Override
    public @NotNull AbsorbKey getInfiniteBurn() {
        return new AbsorbKey(MINECRAFT_HOST, "infiniburn_nether");
    }

    @Override
    public boolean isRespawnAnchorUsed() {
        return true;
    }

    @Override
    public Optional<Long> getFixedTime() {
        return Optional.of(18000L);
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
