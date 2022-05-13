package org.absorb.world.type.overworld;

import org.absorb.register.AbsorbKey;
import org.absorb.utils.Identifiable;
import org.absorb.world.area.ChunkPart;
import org.absorb.world.area.GeneratedChunk;
import org.absorb.world.type.WorldType;
import org.absorb.world.type.flat.GeneratedFlatChunk;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class OverworldType implements WorldType {
    @Override
    public @NotNull String getName() {
        return "Over world";
    }

    @Override
    public @NotNull String getKey() {
        return "overworld";
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
    public int getNetworkId() {
        return 0;
    }

    @Override
    public boolean isNatural() {
        return true;
    }

    @Override
    public float getAmbientLightLevel() {
        return 0;
    }

    @Override
    public boolean hasSkylight() {
        return true;
    }

    @Override
    public boolean isBedsSafe() {
        return true;
    }

    @Override
    public boolean hasRaids() {
        return true;
    }

    @Override
    public int getMinimumHeight() {
        return -64;
    }

    @Override
    public int getMaximumHeight() {
        return 384;
    }

    @Override
    public int getSafeHeight() {
        return 384;
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
        return new AbsorbKey(Identifiable.MINECRAFT_HOST, "overworld");
    }

    @Override
    public @NotNull AbsorbKey getInfiniteBurn() {
        return new AbsorbKey(MINECRAFT_HOST, "infiniburn_overworld");
    }

    @Override
    public boolean isRespawnAnchorUsed() {
        return false;
    }

    @Override
    public Optional<Long> getFixedTime() {
        return Optional.empty();
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
