package org.absorb.world.type.overworld.custom;

import org.absorb.register.AbsorbKey;
import org.absorb.world.area.ChunkPart;
import org.absorb.world.area.GeneratedChunk;
import org.absorb.world.type.WorldType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CustomWorldType implements WorldType {

    private final @NotNull String name;
    private final @NotNull String key;
    private final @NotNull String host;
    private final boolean zombiePiglins;
    private final boolean natural;
    private final float light;
    private final boolean hasSkylight;
    private final boolean areBedsAllowed;
    private final boolean hasRaids;
    private final int minHeight;
    private final int maxHeight;
    private final int logicalHeight;
    private final float multiplier;
    private final boolean isUltrawarm;
    private final boolean lavaSpreading;
    private final @NotNull AbsorbKey basedUpon;
    private final @NotNull AbsorbKey infiBurn;
    private final boolean isRespawnAnchorUsed;
    private final @Nullable Long fixedTime;
    private final int monsterSpawnLightLevel;
    private final int monsterSpawnBlockLightLimit;

    public static final int CUSTOM_JSON_WORLD_TYPE_PROTOCOL_ID = 1;

    public CustomWorldType(@NotNull CustomWorldTypeBuilder builder) {
        this.name = builder.getName();
        this.key = builder.getKey();
        this.host = builder.getHost();
        this.monsterSpawnBlockLightLimit = builder.getMonsterSpawnBlockLightLimit();
        this.monsterSpawnLightLevel = builder.getMonsterSpawnLightLevel();
        this.zombiePiglins = builder.isZombiePiglins();
        this.natural = builder.isNatural();
        this.light = builder.getLight();
        this.hasSkylight = builder.isHasSkylight();
        this.areBedsAllowed = builder.isAreBedsAllowed();
        this.hasRaids = builder.isHasRaids();
        this.minHeight = builder.getMinHeight();
        this.maxHeight = builder.getMaxHeight();
        this.logicalHeight = builder.getLogicalHeight();
        this.multiplier = builder.getMultiplier();
        this.isUltrawarm = builder.isUltrawarm();
        this.lavaSpreading = builder.isLavaSpreading();
        this.basedUpon = builder.getBasedUpon();
        this.infiBurn = builder.getInfiBurn();
        this.isRespawnAnchorUsed = builder.isRespawnAnchorUsed();
        this.fixedTime = builder.getFixedTime().orElse(null);
        if (this.infiBurn == null) {
            throw new IllegalStateException("Infinite Burn needs to be set");
        }
        if (this.basedUpon == null) {
            throw new IllegalStateException("Based upon needs to be set");
        }
        if (this.name == null) {
            throw new IllegalStateException("Name needs to be set");
        }
        if (this.host == null) {
            throw new IllegalStateException("Host needs to be set");
        }
        if (this.key == null) {
            throw new IllegalStateException("Key needs to be set");
        }
        if (this.multiplier > 30000000) {
            throw new IllegalStateException("Multiplier cannot be greater then 30,000,000");
        }
        if (this.multiplier < 0.00001) {
            throw new IllegalStateException("Multiplier cannot be less then 0.00001");
        }
        if (this.logicalHeight > 256) {
            throw new IllegalStateException("Logical Height cannot be greater then 256");
        }
        if (this.logicalHeight < 0) {
            throw new IllegalStateException("Logical height cannot be less then 0");
        }
        if (this.light > 1.0) {
            throw new IllegalStateException("Light cannot be greater then 1");
        }
        if (this.light < 0.0) {
            throw new IllegalStateException("Light cannot be less then 0");
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public String getHost() {
        return this.host;
    }

    @Override
    public boolean willBecomeZombifiedPiglins() {
        return this.zombiePiglins;
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
        return CUSTOM_JSON_WORLD_TYPE_PROTOCOL_ID;
    }

    @Override
    public boolean isNatural() {
        return this.natural;
    }

    @Override
    public float getAmbientLightLevel() {
        return this.light;
    }

    @Override
    public boolean hasSkylight() {
        return this.hasSkylight;
    }

    @Override
    public boolean isBedsSafe() {
        return this.areBedsAllowed;
    }

    @Override
    public boolean hasRaids() {
        return this.hasRaids;
    }

    @Override
    public int getMinimumHeight() {
        return this.minHeight;
    }

    @Override
    public int getMaximumHeight() {
        return this.maxHeight;
    }

    @Override
    public int getSafeHeight() {
        return this.logicalHeight;
    }

    @Override
    public float getMultiplier() {
        return this.multiplier;
    }

    @Override
    public boolean isUltraWarm() {
        return this.isUltrawarm;
    }

    @Override
    public boolean isLavaSpreadingQuickly() {
        return this.lavaSpreading;
    }

    @Override
    public @NotNull AbsorbKey getBasedUpon() {
        return this.basedUpon;
    }

    @Override
    public @NotNull AbsorbKey getInfiniteBurn() {
        return this.infiBurn;
    }

    @Override
    public boolean isRespawnAnchorUsed() {
        return this.isRespawnAnchorUsed;
    }

    @Override
    public Optional<Long> getFixedTime() {
        return Optional.ofNullable(this.fixedTime);
    }

    @Override
    public GeneratedChunk generateChunk(@NotNull ChunkPart part) {
        throw new RuntimeException("Not implemented yet");
    }
}
