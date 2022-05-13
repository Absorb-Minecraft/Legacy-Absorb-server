package org.absorb.world.type;

import org.absorb.register.AbsorbKey;
import org.absorb.register.Typed;
import org.absorb.utils.Identifiable;
import org.absorb.world.area.ChunkPart;
import org.absorb.world.area.GeneratedChunk;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

@Typed(getTypesClass = WorldTypes.class)
public interface WorldType extends Identifiable {

    boolean willBecomeZombifiedPiglins();

    int getNetworkId();

    boolean isNatural();

    float getAmbientLightLevel();

    boolean hasSkylight();

    boolean isBedsSafe();

    boolean hasRaids();

    int getMinimumHeight();

    int getMaximumHeight();

    int getSafeHeight();

    float getMultiplier();

    boolean isUltraWarm();

    boolean isLavaSpreadingQuickly();

    @NotNull AbsorbKey getBasedUpon();

    @NotNull AbsorbKey getInfiniteBurn();

    boolean isRespawnAnchorUsed();

    Optional<Long> getFixedTime();

    @NotNull GeneratedChunk generateChunk(@NotNull ChunkPart part);


}
