package org.absorb.net.packet.play.outgoing.client.join;

import org.absorb.entity.living.human.Gamemode;
import org.absorb.entity.living.human.Gamemodes;
import org.absorb.message.type.ChatType;
import org.absorb.utils.Builder;
import org.absorb.world.World;
import org.absorb.world.biome.Biome;
import org.absorb.world.location.Location;
import org.absorb.world.type.PlayerWorldTypeView;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;

public class OutgoingJoinPacketBuilder implements Builder<OutgoingJoinPacket> {

    private int entityId;
    private long seed;
    private boolean isHardcore;
    private Gamemode gameMode;
    private Gamemode previousGamemode;
    private int maxPlayers;
    private int entityViewDistance;
    private boolean reduceDebug;
    private boolean respawnScreen;
    private int blockViewDistance;
    private boolean isDebugWorld;
    private boolean isFlatWorld;
    private Collection<PlayerWorldTypeView> worldTypes;
    private Collection<ChatType> chatTypes;

    private World currentWorld;
    private Collection<Biome> biomes;
    private Location deathLocation;

    public OutgoingJoinPacketBuilder() {
        this.reset();
    }

    public Location getDeathLocation() {
        return this.deathLocation;
    }

    public OutgoingJoinPacketBuilder setDeathLocation(Location deathLocation) {
        this.deathLocation = deathLocation;
        return this;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public OutgoingJoinPacketBuilder setEntityId(int entityId) {
        this.entityId = entityId;
        return this;
    }

    public long getSeed() {
        return this.seed;
    }

    public OutgoingJoinPacketBuilder setSeed(long seed) {
        this.seed = seed;
        return this;
    }

    public boolean isHardcore() {
        return this.isHardcore;
    }

    public OutgoingJoinPacketBuilder setHardcore(boolean hardcore) {
        this.isHardcore = hardcore;
        return this;
    }

    public Gamemode getGameMode() {
        return this.gameMode;
    }

    public OutgoingJoinPacketBuilder setGameMode(Gamemode gameMode) {
        this.gameMode = gameMode;
        return this;
    }

    public Gamemode getPreviousGamemode() {
        return this.previousGamemode;
    }

    public OutgoingJoinPacketBuilder setPreviousGamemode(Gamemode previousGamemode) {
        this.previousGamemode = previousGamemode;
        return this;
    }

    public int getMaxPlayers() {
        return this.maxPlayers;
    }

    public OutgoingJoinPacketBuilder setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        return this;
    }

    public int getEntityViewDistance() {
        return this.entityViewDistance;
    }

    public OutgoingJoinPacketBuilder setEntityViewDistance(int entityViewDistance) {
        this.entityViewDistance = entityViewDistance;
        return this;
    }

    public boolean isReduceDebug() {
        return this.reduceDebug;
    }

    public OutgoingJoinPacketBuilder setReduceDebug(boolean reduceDebug) {
        this.reduceDebug = reduceDebug;
        return this;
    }

    public boolean isRespawnScreen() {
        return this.respawnScreen;
    }

    public OutgoingJoinPacketBuilder setRespawnScreen(boolean respawnScreen) {
        this.respawnScreen = respawnScreen;
        return this;
    }

    public int getBlockViewDistance() {
        return this.blockViewDistance;
    }

    public OutgoingJoinPacketBuilder setBlockViewDistance(int blockViewDistance) {
        this.blockViewDistance = blockViewDistance;
        return this;
    }

    public boolean isDebugWorld() {
        return this.isDebugWorld;
    }

    public OutgoingJoinPacketBuilder setDebugWorld(boolean debugWorld) {
        this.isDebugWorld = debugWorld;
        return this;
    }

    public boolean isFlatWorld() {
        return this.isFlatWorld;
    }

    public OutgoingJoinPacketBuilder setFlatWorld(boolean flatWorld) {
        this.isFlatWorld = flatWorld;
        return this;
    }

    public Collection<PlayerWorldTypeView> getWorldTypes() {
        return this.worldTypes;
    }

    public OutgoingJoinPacketBuilder setWorldTypes(Collection<PlayerWorldTypeView> worldTypes) {
        this.worldTypes = worldTypes;
        return this;
    }

    public Collection<ChatType> getChatTypes() {
        return this.chatTypes;
    }

    public OutgoingJoinPacketBuilder setChatTypes(Collection<ChatType> chatTypes) {
        this.chatTypes = chatTypes;
        return this;
    }

    public World getCurrentWorld() {
        return this.currentWorld;
    }

    public OutgoingJoinPacketBuilder setCurrentWorld(World currentWorld) {
        this.currentWorld = currentWorld;
        return this;
    }

    public Collection<Biome> getBiomes() {
        return this.biomes;
    }

    public OutgoingJoinPacketBuilder setBiomes(Collection<Biome> biomes) {
        this.biomes = biomes;
        return this;
    }

    @Override
    public @NotNull OutgoingJoinPacket build() {
        return new OutgoingJoinPacket(this);
    }

    @Override
    public @NotNull OutgoingJoinPacketBuilder reset() {
        this.blockViewDistance = 10;
        this.entityViewDistance = 10;
        this.maxPlayers = 20;
        this.seed = 0;
        this.entityId = 0;
        this.isDebugWorld = true;
        this.isFlatWorld = true;
        this.reduceDebug = false;
        this.isHardcore = false;
        this.respawnScreen = true;
        this.gameMode = Gamemodes.CREATIVE;
        this.worldTypes = Collections.emptyList();
        this.biomes = Collections.emptyList();
        this.chatTypes = Collections.emptyList();
        this.currentWorld = null;
        this.deathLocation = null;
        return this;
    }

    @Override
    public @NotNull OutgoingJoinPacketBuilder copy() {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public @NotNull Builder<OutgoingJoinPacket> from(OutgoingJoinPacket value) {
        this.biomes = value.getBiomes();
        this.currentWorld = value.getCurrentWorld();
        this.entityId = value.getId();
        this.deathLocation = value.getDeathLocation().orElse(null);
        this.gameMode = value.getGameMode();
        this.blockViewDistance = value.getBlockViewDistance();
        this.entityViewDistance = value.getEntityViewDistance();
        this.isDebugWorld = value.isDebugWorld();
        this.isFlatWorld = value.isFlatWorld();
        this.isHardcore = value.isHardcore();
        this.maxPlayers = value.getMaxPlayers();
        this.previousGamemode = value.getPreviousGamemode().orElse(null);
        this.reduceDebug = value.isReduceDebug();
        this.respawnScreen = value.isRespawnScreen();
        this.seed = value.getSeed();
        this.worldTypes.addAll(value.getWorldTypes());
        this.chatTypes.addAll(value.getChatTypes());
        return this;
    }
}
