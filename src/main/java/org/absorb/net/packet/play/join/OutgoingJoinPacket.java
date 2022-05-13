package org.absorb.net.packet.play.join;

import me.nullicorn.nedit.NBTOutputStream;
import me.nullicorn.nedit.type.NBTCompound;
import me.nullicorn.nedit.type.NBTList;
import org.absorb.entity.living.human.Gamemode;
import org.absorb.files.nbt.compound.NBTCompoundBuilder;
import org.absorb.files.nbt.compound.NBTCompoundEntry;
import org.absorb.files.nbt.compound.NBTCompoundKeys;
import org.absorb.net.Client;
import org.absorb.net.data.ListSerializer;
import org.absorb.net.data.SerializerUtils;
import org.absorb.net.data.Serializers;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.absorb.register.AbsorbKey;
import org.absorb.world.biome.Biome;
import org.absorb.world.type.PlayerWorldTypeView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OutgoingJoinPacket implements OutgoingPacket {

    public static final int ID = 0x26;

    private final int entityId;
    private final long seed;
    private final boolean isHardcore;
    private final @NotNull Gamemode gameMode;
    private final @Nullable Gamemode previousGamemode;
    private final int maxPlayers;
    private final int blockViewDistance;
    private final int entityViewDistance;
    private final boolean reduceDebug;
    private final boolean respawnScreen;
    private final boolean isDebugWorld;
    private final boolean isFlatWorld;
    private final @NotNull Collection<PlayerWorldTypeView> worldTypes;
    private final @NotNull PlayerWorldTypeView currentWorldType;
    private final @NotNull Collection<Biome> biomes;


    public OutgoingJoinPacket(@NotNull OutgoingJoinPacketBuilder builder) {
        this.blockViewDistance = builder.getBlockViewDistance();
        this.currentWorldType = builder.getCurrentWorldType();
        this.biomes = builder.getBiomes();
        this.entityId = builder.getEntityId();
        this.entityViewDistance = builder.getEntityViewDistance();
        this.gameMode = builder.getGameMode();
        this.isDebugWorld = builder.isDebugWorld();
        this.isFlatWorld = builder.isFlatWorld();
        this.isHardcore = builder.isHardcore();
        this.maxPlayers = builder.getMaxPlayers();
        this.previousGamemode = builder.getPreviousGamemode();
        this.reduceDebug = builder.isReduceDebug();
        this.respawnScreen = builder.isRespawnScreen();
        this.seed = builder.getSeed();
        this.worldTypes = builder.getWorldTypes();
        if (this.worldTypes==null || this.worldTypes.isEmpty()) {
            throw new IllegalArgumentException("No worldtype specified");
        }
        if (this.currentWorldType==null) {
            throw new IllegalArgumentException("Current worldType must be specified");
        }
        if (this.gameMode==null) {
            throw new IllegalArgumentException("Gamemode must be specified");
        }
    }

    public int getEntityId() {
        return this.entityId;
    }

    public long getSeed() {
        return this.seed;
    }

    public boolean isHardcore() {
        return this.isHardcore;
    }

    public @NotNull Gamemode getGameMode() {
        return this.gameMode;
    }

    public Optional<Gamemode> getPreviousGamemode() {
        return Optional.ofNullable(this.previousGamemode);
    }

    public int getMaxPlayers() {
        return this.maxPlayers;
    }

    public int getBlockViewDistance() {
        return this.blockViewDistance;
    }

    public int getEntityViewDistance() {
        return this.entityViewDistance;
    }

    public boolean isReduceDebug() {
        return this.reduceDebug;
    }

    public boolean isRespawnScreen() {
        return this.respawnScreen;
    }

    public boolean isDebugWorld() {
        return this.isDebugWorld;
    }

    public boolean isFlatWorld() {
        return this.isFlatWorld;
    }

    public @NotNull Collection<PlayerWorldTypeView> getWorldTypes() {
        return this.worldTypes;
    }

    public @NotNull PlayerWorldTypeView getCurrentWorldType() {
        return this.currentWorldType;
    }

    public @NotNull Collection<Biome> getBiomes() {
        return this.biomes;
    }

    @Override
    public void send(@NotNull Client stream) {
        ByteBuffer playerEntityId = Serializers.INTEGER.write(this.entityId);
        ByteBuffer hardcore = Serializers.BOOLEAN.write(this.isHardcore);
        ByteBuffer gamemode = Serializers.BYTE.write((byte) this.gameMode.getNetworkId());
        ByteBuffer previousGamemode = Serializers.BYTE.write(this.previousGamemode==null ? -1:
                (byte) this.previousGamemode.getNetworkId());
        //ByteBuffer worldCount = Serializers.VAR_INTEGER.write(this.worldTypes.size());
        List<AbsorbKey> worldTypes = this
                .worldTypes
                .stream()
                .map(t -> t.getType().getResourceKey())
                .collect(Collectors.toList());
        ByteBuffer worldTypeIds =
                new ListSerializer<>(Serializers.RESOURCE_KEY)
                        .write(worldTypes);
        NBTCompoundEntry<NBTList, Collection<PlayerWorldTypeView>> types =
                NBTCompoundKeys.DIMENSION.withValue(this.worldTypes);
        NBTCompound worldTypeCompoundGroup = new NBTCompoundBuilder()
                .addAll(types, NBTCompoundKeys.COMPOUND_TYPE.withValue("minecraft:dimension_type"))
                .build();
        NBTCompoundEntry<NBTList, Collection<Biome>> biomes = NBTCompoundKeys.BIOMES.withValue(this.biomes);
        NBTCompound biomesCompoundGroup = new NBTCompoundBuilder()
                .addAll(biomes,
                        NBTCompoundKeys.COMPOUND_TYPE.withValue(
                                "minecraft:worldgen/biome"))
                .build();
        NBTCompound biomeCodec =
                new NBTCompoundBuilder()
                        .addAll(NBTCompoundKeys.DIMENSION_TYPE.withValue(worldTypeCompoundGroup),
                                NBTCompoundKeys.WORLD_GEN_BIOME.withValue(biomesCompoundGroup))
                        .build();


        ByteBuffer mainWorldTypeId = Serializers.RESOURCE_KEY.write(this.currentWorldType.getType().getResourceKey());
        ByteBuffer seed = Serializers.LONG.write(this.seed);
        ByteBuffer maxPlayers = Serializers.VAR_INTEGER.write(this.maxPlayers);
        ByteBuffer viewDistance = Serializers.VAR_INTEGER.write(this.blockViewDistance);
        ByteBuffer simDistance = Serializers.VAR_INTEGER.write(this.entityViewDistance);
        ByteBuffer reducedDebug = Serializers.BOOLEAN.write(this.reduceDebug);
        ByteBuffer respawnScreen = Serializers.BOOLEAN.write(this.respawnScreen);
        ByteBuffer isDebugWorld = Serializers.BOOLEAN.write(this.isDebugWorld);
        ByteBuffer isFlat = Serializers.BOOLEAN.write(this.isFlatWorld);


        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            NBTOutputStream nbtOs = new NBTOutputStream(os, false);
            nbtOs.write(playerEntityId.array());
            nbtOs.write(hardcore.array());
            nbtOs.write(gamemode.array());
            nbtOs.write(previousGamemode.array());
            nbtOs.write(worldTypeIds.array());
            nbtOs.writeFully(biomeCodec);
            nbtOs.writeFully(this.currentWorldType.toNBT());
            nbtOs.write(mainWorldTypeId.array());
            nbtOs.write(seed.array());
            nbtOs.write(maxPlayers.array());
            nbtOs.write(viewDistance.array());
            nbtOs.write(simDistance.array());
            nbtOs.write(reducedDebug.array());
            nbtOs.write(respawnScreen.array());
            nbtOs.write(isDebugWorld.array());
            nbtOs.write(isFlat.array());
            os.flush();
            ByteBuffer buffer = SerializerUtils.createPacket(ID, ByteBuffer.wrap(os.toByteArray()));
            stream.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }

    @Override
    public @NotNull OutgoingPacketBuilder<? extends Packet> toBuilder() {
        return (OutgoingPacketBuilder<? extends Packet>) new OutgoingJoinPacketBuilder()
                .setBlockViewDistance(this.blockViewDistance)
                .setEntityViewDistance(this.entityViewDistance)
                .setEntityId(this.entityId)
                .setDebugWorld(this.isDebugWorld)
                .setFlatWorld(this.isFlatWorld)
                .setGameMode(this.gameMode)
                .setBiomes(this.biomes)
                .setCurrentWorldType(this.currentWorldType)
                .setRespawnScreen(this.respawnScreen);
    }
}
