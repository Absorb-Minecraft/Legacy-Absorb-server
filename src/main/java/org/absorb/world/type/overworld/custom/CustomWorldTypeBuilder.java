package org.absorb.world.type.overworld.custom;

import org.absorb.register.AbsorbKey;
import org.absorb.utils.Builder;

import java.util.Optional;

public class CustomWorldTypeBuilder implements Builder<CustomWorldType> {

    private String name;
    private String key;
    private String host;
    private boolean zombiePiglins;
    private boolean natural;
    private float light;
    private boolean hasSkylight;
    private boolean areBedsAllowed;
    private boolean hasRaids;
    private int minHeight;
    private int maxHeight;
    private int logicalHeight;
    private float multiplier;
    private boolean isUltrawarm;
    private boolean lavaSpreading;
    private AbsorbKey basedUpon;
    private AbsorbKey infiBurn;
    private boolean isRespawnAnchorUsed;
    private Long fixedTime;
    private int monsterSpawnLightLevel;
    private int monsterSpawnBlockLightLimit;

    public String getName() {
        return this.name;
    }

    public CustomWorldTypeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public CustomWorldTypeBuilder setKey(String key) {
        this.key = key;
        return this;
    }

    public String getHost() {
        return this.host;
    }

    public CustomWorldTypeBuilder setHost(String host) {
        this.host = host;
        return this;
    }

    public boolean isZombiePiglins() {
        return this.zombiePiglins;
    }

    public CustomWorldTypeBuilder setZombiePiglins(boolean zombiePiglins) {
        this.zombiePiglins = zombiePiglins;
        return this;
    }

    public boolean isNatural() {
        return this.natural;
    }

    public CustomWorldTypeBuilder setNatural(boolean natural) {
        this.natural = natural;
        return this;
    }

    public float getLight() {
        return this.light;
    }

    public CustomWorldTypeBuilder setLight(float light) {
        this.light = light;
        return this;
    }

    public boolean isHasSkylight() {
        return this.hasSkylight;
    }

    public CustomWorldTypeBuilder setHasSkylight(boolean hasSkylight) {
        this.hasSkylight = hasSkylight;
        return this;
    }

    public boolean isAreBedsAllowed() {
        return this.areBedsAllowed;
    }

    public CustomWorldTypeBuilder setAreBedsAllowed(boolean areBedsAllowed) {
        this.areBedsAllowed = areBedsAllowed;
        return this;
    }

    public boolean isHasRaids() {
        return this.hasRaids;
    }

    public CustomWorldTypeBuilder setHasRaids(boolean hasRaids) {
        this.hasRaids = hasRaids;
        return this;
    }

    public int getMinHeight() {
        return this.minHeight;
    }

    public CustomWorldTypeBuilder setMinHeight(int minHeight) {
        this.minHeight = minHeight;
        return this;
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public CustomWorldTypeBuilder setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
        return this;
    }

    public int getLogicalHeight() {
        return this.logicalHeight;
    }

    public CustomWorldTypeBuilder setLogicalHeight(int logicalHeight) {
        this.logicalHeight = logicalHeight;
        return this;
    }

    public float getMultiplier() {
        return this.multiplier;
    }

    public CustomWorldTypeBuilder setMultiplier(float multiplier) {
        this.multiplier = multiplier;
        return this;
    }

    public boolean isUltrawarm() {
        return this.isUltrawarm;
    }

    public CustomWorldTypeBuilder setUltrawarm(boolean ultrawarm) {
        this.isUltrawarm = ultrawarm;
        return this;
    }

    public boolean isLavaSpreading() {
        return this.lavaSpreading;
    }

    public CustomWorldTypeBuilder setLavaSpreading(boolean lavaSpreading) {
        this.lavaSpreading = lavaSpreading;
        return this;
    }

    public AbsorbKey getBasedUpon() {
        return this.basedUpon;
    }

    public CustomWorldTypeBuilder setBasedUpon(AbsorbKey basedUpon) {
        this.basedUpon = basedUpon;
        return this;
    }

    public AbsorbKey getInfiBurn() {
        return this.infiBurn;
    }

    public CustomWorldTypeBuilder setInfiBurn(AbsorbKey infiBurn) {
        this.infiBurn = infiBurn;
        return this;
    }

    public boolean isRespawnAnchorUsed() {
        return this.isRespawnAnchorUsed;
    }

    public CustomWorldTypeBuilder setRespawnAnchorUsed(boolean respawnAnchorUsed) {
        this.isRespawnAnchorUsed = respawnAnchorUsed;
        return this;
    }

    @Override
    public CustomWorldType build() {
        return new CustomWorldType(this);
    }

    @Override
    public CustomWorldTypeBuilder reset() {
        this.isRespawnAnchorUsed = true;
        this.infiBurn = null;
        this.basedUpon = null;
        this.lavaSpreading = false;
        this.isUltrawarm = false;
        this.multiplier = 1.0f;
        this.logicalHeight = 255;
        this.maxHeight = 260;
        this.minHeight = 0;
        this.hasRaids = true;
        this.areBedsAllowed = true;
        this.hasSkylight = true;
        this.light = 1.0f;
        this.natural = true;
        this.zombiePiglins = false;
        this.host = null;
        this.key = null;
        this.name = null;
        return this;
    }

    @Override
    public CustomWorldTypeBuilder copy() {
        throw new RuntimeException("Not implemented yet");
    }

    public Optional<Long> getFixedTime() {
        return Optional.ofNullable(this.fixedTime);
    }

    public void setFixedTime(Long l) {
        this.fixedTime = l;
    }

    public int getMonsterSpawnBlockLightLimit() {
        return this.monsterSpawnLightLevel;
    }

    public int getMonsterSpawnLightLevel() {
        return this.monsterSpawnBlockLightLimit;
    }
}
