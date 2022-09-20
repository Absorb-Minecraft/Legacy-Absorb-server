package org.absorb.net.packet.play.outgoing.client.join;

import me.nullicorn.nedit.NBTOutputStream;
import me.nullicorn.nedit.type.NBTCompound;
import me.nullicorn.nedit.type.NBTList;
import me.nullicorn.nedit.type.TagType;
import org.absorb.entity.living.human.Gamemode;
import org.absorb.files.nbt.compound.NBTCompoundBuilder;
import org.absorb.files.nbt.compound.NBTCompoundEntry;
import org.absorb.files.nbt.compound.NBTCompoundKeys;
import org.absorb.message.type.ChatType;
import org.absorb.net.Client;
import org.absorb.net.data.NetList;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.absorb.register.AbsorbKey;
import org.absorb.world.World;
import org.absorb.world.biome.Biome;
import org.absorb.world.location.Location;
import org.absorb.world.type.PlayerWorldTypeView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.concurrent.LinkedTransferQueue;
import java.util.stream.Collectors;

public class OutgoingJoinPacket implements OutgoingPacket {

    //TODO chat registry

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
    private final @Nullable Location deathLocation;
    private final @NotNull Collection<PlayerWorldTypeView> worldTypes;
    private final @NotNull World currentWorld;
    private final @NotNull Collection<ChatType> chatTypes = new LinkedTransferQueue<>();
    private final @NotNull Collection<Biome> biomes = new TreeSet<>(Comparator.comparing(Biome::getNetworkId));
    public static final int ID = 0x25;


    public OutgoingJoinPacket(@NotNull OutgoingJoinPacketBuilder builder) {
        this.blockViewDistance = builder.getBlockViewDistance();
        this.currentWorld = builder.getCurrentWorld();
        this.biomes.addAll(builder.getBiomes());
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
        this.deathLocation = builder.getDeathLocation();
        if (this.worldTypes == null || this.worldTypes.isEmpty()) {
            throw new IllegalArgumentException("No worldtype specified");
        }
        if (this.currentWorld == null) {
            throw new IllegalArgumentException("Current world must be specified");
        }
        if (this.gameMode == null) {
            throw new IllegalArgumentException("Gamemode must be specified");
        }
    }

    public @NotNull Collection<ChatType> getChatTypes() {
        return this.chatTypes;
    }

    public @NotNull Optional<Location> getDeathLocation() {
        return Optional.ofNullable(this.deathLocation);
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

    public @NotNull World getCurrentWorld() {
        return this.currentWorld;
    }

    public @NotNull Collection<Biome> getBiomes() {
        return this.biomes;
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
                .setCurrentWorld(this.currentWorld)
                .setRespawnScreen(this.respawnScreen)
                .setDeathLocation(this.deathLocation);
    }

    @Override
    public ByteBuffer toBytes(@NotNull Client stream) {
        ByteBuffer playerEntityId = NetSerializers.INTEGER.write(this.entityId);
        ByteBuffer hardcore = NetSerializers.BOOLEAN.write(this.isHardcore);
        ByteBuffer gamemode = NetSerializers.BYTE.write((byte) this.gameMode.getNetworkId());
        ByteBuffer previousGamemode = NetSerializers.BYTE.write(
                this.previousGamemode == null ? -1 : (byte) this.previousGamemode.getNetworkId());
        //ByteBuffer worldCount = Serializers.VAR_INTEGER.write(this.worldTypes.size());
        List<AbsorbKey> worldTypes = this.worldTypes
                .stream()
                .map(t -> t.getType().getResourceKey())
                .collect(Collectors.toList());
        ByteBuffer worldTypeIds = new NetList<>(NetSerializers.RESOURCE_KEY).write(worldTypes);
        NBTCompoundEntry<NBTList, Collection<PlayerWorldTypeView>> types = NBTCompoundKeys.DIMENSION.withValue(this.worldTypes);
        NBTCompound worldTypeCompoundGroup = new NBTCompoundBuilder()
                .addAll(types, NBTCompoundKeys.COMPOUND_TYPE.withValue("minecraft:dimension_type"))
                .build();
        NBTCompoundEntry<NBTList, Collection<Biome>> biomes = NBTCompoundKeys.BIOMES.withValue(this.biomes);
        NBTCompound biomesCompoundGroup = new NBTCompoundBuilder()
                .addAll(biomes, NBTCompoundKeys.COMPOUND_TYPE.withValue("minecraft:worldgen/biome"))
                .build();

        NBTList chatType = new NBTList(TagType.COMPOUND);
        chatType.addAll(this.chatTypes.stream().map(ChatType::asCompound).toList());

        NBTCompound chatTypes = new NBTCompoundBuilder()
                .addAll(NBTCompoundKeys.COMPOUND_TYPE.withValue("minecraft:chat_type"),
                        NBTCompoundKeys.VALUE_LIST.withValue(chatType))
                .build();

        NBTCompound biomeCodec = new NBTCompoundBuilder()
                .addAll(NBTCompoundKeys.DIMENSION_TYPE.withValue(worldTypeCompoundGroup),
                        NBTCompoundKeys.WORLD_GEN_BIOME.withValue(biomesCompoundGroup),
                        NBTCompoundKeys.CHAT_TYPES.withValue(chatTypes))
                .build();


        ByteBuffer mainWorldTypeId = NetSerializers.RESOURCE_KEY.write(this.currentWorld
                                                                               .getWorldData()
                                                                               .getType()
                                                                               .getResourceKey());
        ByteBuffer mainWorldName = NetSerializers.RESOURCE_KEY.write(this.currentWorld.getKey());
        ByteBuffer seed = NetSerializers.LONG.write(this.seed);
        ByteBuffer maxPlayers = NetSerializers.VAR_INTEGER.write(this.maxPlayers);
        ByteBuffer viewDistance = NetSerializers.VAR_INTEGER.write(this.blockViewDistance);
        ByteBuffer simDistance = NetSerializers.VAR_INTEGER.write(this.entityViewDistance);
        ByteBuffer reducedDebug = NetSerializers.BOOLEAN.write(this.reduceDebug);
        ByteBuffer respawnScreen = NetSerializers.BOOLEAN.write(this.respawnScreen);
        ByteBuffer isDebugWorld = NetSerializers.BOOLEAN.write(this.isDebugWorld);
        ByteBuffer isFlat = NetSerializers.BOOLEAN.write(this.isFlatWorld);
        ByteBuffer hasDeathLocation = NetSerializers.BOOLEAN.write(this.deathLocation != null);
        ByteBuffer deathDimension = ByteBuffer.allocate(0);
        ByteBuffer deathPosition = ByteBuffer.allocate(0);
        if (this.deathLocation != null) {
            deathPosition = NetSerializers.POSITION.write(this.deathLocation.getPosition().toInt());
            deathDimension = NetSerializers.RESOURCE_KEY.write(this.deathLocation.getWorld().getKey());
        }

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            NBTOutputStream nbtOs = new NBTOutputStream(os, false);
            nbtOs.write(playerEntityId.array());
            nbtOs.write(hardcore.array());
            nbtOs.write(gamemode.array());
            nbtOs.write(previousGamemode.array());
            nbtOs.write(worldTypeIds.array());
            nbtOs.writeFully(biomeCodec);
            //nbtOs.writeFully(this.currentWorldType.toTypeNBT());
            nbtOs.write(mainWorldTypeId.array());

            nbtOs.write(mainWorldName.array());

            nbtOs.write(seed.array());
            nbtOs.write(maxPlayers.array());
            nbtOs.write(viewDistance.array());
            nbtOs.write(simDistance.array());
            nbtOs.write(reducedDebug.array());
            nbtOs.write(respawnScreen.array());
            nbtOs.write(isDebugWorld.array());
            nbtOs.write(isFlat.array());
            nbtOs.write(hasDeathLocation.array());
            nbtOs.write(deathDimension.array());
            nbtOs.write(deathPosition.array());
            os.flush();
            return NetUtils.createPacket(ID, ByteBuffer.wrap(os.toByteArray()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
