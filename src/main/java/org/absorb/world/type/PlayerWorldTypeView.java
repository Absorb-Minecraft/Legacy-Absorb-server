package org.absorb.world.type;

import me.nullicorn.nedit.type.NBTCompound;
import org.absorb.AbsorbManagers;
import org.absorb.files.nbt.compound.NBTCompoundBuilder;
import org.absorb.files.nbt.compound.NBTCompoundEntry;
import org.absorb.files.nbt.compound.NBTCompoundGroupable;
import org.absorb.files.nbt.compound.NBTCompoundKeys;
import org.absorb.register.AbsorbKey;
import org.absorb.register.registry.Registry;
import org.absorb.world.type.overworld.custom.CustomWorldType;
import org.absorb.world.type.overworld.custom.CustomWorldTypeBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class PlayerWorldTypeView implements NBTCompoundGroupable {

    private final WorldType type;
    private Long playerTime;

    public PlayerWorldTypeView(@NotNull WorldType type) {
        this.type = type;
    }


    public WorldType getType() {
        return this.type;
    }

    public Long getPlayerTime() {
        return this.playerTime;
    }

    public PlayerWorldTypeView setPlayerTime(Long playerTime) {
        this.playerTime = playerTime;
        return this;
    }

    @Override
    public NBTCompound toNBT() {
        Set<NBTCompoundEntry<?, ?>> values = new HashSet<>();
        Set<NBTCompoundEntry<?, ?>> ret = new HashSet<>();
        ret.add(NBTCompoundKeys.NAME.withValue(this.type.getResourceKey()));
        ret.add(NBTCompoundKeys.ID.withValue(this.type.getNetworkId()));
        values.add(NBTCompoundKeys.PIGLIN_SAFE.withValue(this.type.willBecomeZombifiedPiglins()));
        values.add(NBTCompoundKeys.NATURAL.withValue(this.type.isNatural()));
        values.add(NBTCompoundKeys.AMBIENT_LIGHT.withValue(this.type.getAmbientLightLevel()));
        if(this.playerTime == null && this.type.getFixedTime().isPresent()){
            values.add(NBTCompoundKeys.FIXED_TIME.withValue(this.type.getFixedTime().get()));
        }
        if (this.playerTime!=null) {
            values.add(NBTCompoundKeys.FIXED_TIME.withValue(this.playerTime));
        }
        values.add(NBTCompoundKeys.INFINIBURN.withValue("#" + this.getType().getInfiniteBurn().asFormatted()));
        values.add(NBTCompoundKeys.RESPAWN_ANCHOR_WORKS.withValue(this.type.isRespawnAnchorUsed()));
        values.add(NBTCompoundKeys.HAS_SKYLIGHT.withValue(this.type.hasSkylight()));
        values.add(NBTCompoundKeys.BED_WORKS.withValue(this.type.isBedsSafe()));
        values.add(NBTCompoundKeys.DIMENSION_EFFECTS.withValue(this.type.getBasedUpon()));
        values.add(NBTCompoundKeys.HAS_RAIDS.withValue(this.type.hasRaids()));
        values.add(NBTCompoundKeys.MIN_Y.withValue(this.type.getMinimumHeight()));
        values.add(NBTCompoundKeys.HEIGHT.withValue(this.type.getMaximumHeight()));
        values.add(NBTCompoundKeys.LOGICAL_HEIGHT.withValue(this.type.getSafeHeight()));
        values.add(NBTCompoundKeys.COORDINATE_SCALE.withValue((double) this.type.getMultiplier()));
        values.add(NBTCompoundKeys.ULTRAWARM.withValue(this.type.isUltraWarm()));
        values.add(NBTCompoundKeys.HAS_CEILING.withValue(this.type.isLavaSpreadingQuickly()));

        NBTCompound group = new NBTCompoundBuilder().addAll(values).build();
        ret.add(NBTCompoundKeys.ELEMENT.withValue(group));
        return new NBTCompoundBuilder().addAll(ret).build();
    }

    public static PlayerWorldTypeView of(@NotNull NBTCompound group) {
        int networkId = NBTCompoundKeys.ID.getValue(group).orElseThrow(() -> new IllegalArgumentException("No 'id' in" +
                " root"));
        AbsorbKey key = NBTCompoundKeys.NAME.getValue(group).orElseThrow(() -> new IllegalArgumentException("No " +
                "'name' in root"));
        NBTCompound main = NBTCompoundKeys.ELEMENT.getValue(group).orElseThrow(() -> new IllegalArgumentException(
                "No 'Element' in " +
                        "root"));
        Optional<Long> opTime = NBTCompoundKeys.FIXED_TIME.getValue(main);
        if (networkId!=CustomWorldType.CUSTOM_JSON_WORLD_TYPE_PROTOCOL_ID) {
            Registry<WorldType> worldTypeRegistry = AbsorbManagers.getRegistryManager().getWorldType(key);
            PlayerWorldTypeView playerWorldTypeView = new PlayerWorldTypeView(worldTypeRegistry.get());
            opTime.ifPresent(playerWorldTypeView::setPlayerTime);
            return playerWorldTypeView;
        }
        boolean piglinSafe = NBTCompoundKeys.PIGLIN_SAFE.getValue(main).orElseThrow(() -> new IllegalArgumentException("No " +
                "'piglin_safe' in element"));
        boolean natural = NBTCompoundKeys.NATURAL.getValue(main).orElseThrow(() -> new IllegalArgumentException(
                "No 'natural' in element"));
        float light =
                NBTCompoundKeys.AMBIENT_LIGHT.getValue(main).orElseThrow(() -> new IllegalArgumentException(
                        "No 'ambient_light' in element"));
        String infiniteBurn =
                NBTCompoundKeys.INFINIBURN.getValue(main).orElseThrow(() -> new IllegalArgumentException("no " +
                        "'infiniburn' in element"));
        boolean respawn = NBTCompoundKeys.RESPAWN_ANCHOR_WORKS.getValue(main).orElseThrow(() -> new IllegalArgumentException("no " +
                "'respawn_anchor_works' in element"));
        boolean hasSkylight =
                NBTCompoundKeys.HAS_SKYLIGHT.getValue(main).orElseThrow(() -> new IllegalArgumentException("no " +
                        "'has_skylight' in element"));
        boolean isBedAllowed = NBTCompoundKeys.BED_WORKS.getValue(main).orElseThrow(() -> new IllegalArgumentException("no " +
                "'bed_works' in element"));
        AbsorbKey basedOn = NBTCompoundKeys.DIMENSION_EFFECTS.getValue(main).orElseThrow(() -> new IllegalArgumentException("no " +
                "'effects' in element"));
        boolean hasRaids = NBTCompoundKeys.HAS_RAIDS.getValue(main).orElseThrow(() -> new IllegalArgumentException(
                "no 'has_raids' in element"));
        int minHeight = NBTCompoundKeys.MIN_Y.getValue(main).orElseThrow(() -> new IllegalArgumentException("no" +
                " min_y' in element"));
        int maxHeight = NBTCompoundKeys.HEIGHT.getValue(main).orElseThrow(() -> new IllegalArgumentException(
                "no 'height' in element"));
        int logicalHeight = NBTCompoundKeys.LOGICAL_HEIGHT.getValue(main).orElseThrow(() -> new IllegalArgumentException("no " +
                "'logical_height' in element"));
        double scale = NBTCompoundKeys.COORDINATE_SCALE.getValue(main).orElseThrow(() -> new IllegalArgumentException(
                "no " +
                        "'coordinate_scale' in element"));
        boolean ultrawarm = NBTCompoundKeys.ULTRAWARM.getValue(main).orElseThrow(() -> new IllegalArgumentException(
                "no 'ultrawarm' in element"));
        boolean hasCeiling = NBTCompoundKeys.HAS_CEILING.getValue(main).orElseThrow(() -> new IllegalArgumentException("no " +
                "'has_ceiling' in element"));
        CustomWorldTypeBuilder builder =
                new CustomWorldTypeBuilder()
                        .setHasSkylight(hasSkylight)
                        .setHasRaids(hasRaids)
                        .setAreBedsAllowed(isBedAllowed)
                        .setBasedUpon(basedOn)
                        .setKey(key.value())
                        .setName(key.value())
                        .setHost(key.host())
                        .setMaxHeight(maxHeight)
                        .setMinHeight(minHeight)
                        .setLogicalHeight(logicalHeight)
                        .setUltrawarm(ultrawarm)
                        .setLavaSpreading(hasCeiling)
                        .setMultiplier((float) scale)
                        .setRespawnAnchorUsed(respawn)
                        .setLight(light)
                        .setNatural(natural)
                        .setZombiePiglins(piglinSafe);
        PlayerWorldTypeView view = new PlayerWorldTypeView(builder.build());
        opTime.ifPresent(view::setPlayerTime);
        return view;
    }
}
