package org.absorb.net.processor.login.pre;

import org.absorb.AbsorbManagers;
import org.absorb.entity.WorldEntity;
import org.absorb.entity.living.human.Gamemodes;
import org.absorb.entity.living.human.Human;
import org.absorb.entity.living.human.effects.HumanEffects;
import org.absorb.entity.living.human.tab.PlayerTab;
import org.absorb.net.Client;
import org.absorb.net.packet.login.post.OutgoingLoginSuccessfulPacketBuilder;
import org.absorb.net.packet.login.pre.IncomingPreLoginPacket;
import org.absorb.net.packet.play.entity.player.tab.add.OutgoingPlayerTabUpdateAddPlayerPacketBuilder;
import org.absorb.net.packet.play.join.OutgoingJoinPacketBuilder;
import org.absorb.net.processor.NetProcess;
import org.absorb.world.AbsorbWorld;
import org.absorb.world.area.AbsorbChunk;
import org.absorb.world.type.PlayerWorldTypeView;
import org.spongepowered.math.vector.Vector3d;

import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PreLoginProcess implements NetProcess<IncomingPreLoginPacket> {
    @Override
    public void onProcess(Client info, IncomingPreLoginPacket packet) {
        info.setUsername(packet.getUsername());
        String name = packet.getUsername();
        UUID uuid = UUID.nameUUIDFromBytes(name.getBytes(StandardCharsets.UTF_8));
        info.setUuid(uuid);

        AbsorbWorld world = AbsorbManagers.getWorldManager().defaultWorld();
        Vector3d spawnAt = new Vector3d(0, 0, 0);
        AbsorbChunk chunk = world.generateChunkAtBlock(spawnAt.floorX(), spawnAt.floorZ());

        Human playerEntity = new Human();
        playerEntity.addEffect(HumanEffects.PERMISSION_LEVEL_ONE);
        WorldEntity worldHuman = world.spawnEntity(playerEntity, spawnAt);
        info.setEntity(worldHuman);

        new OutgoingLoginSuccessfulPacketBuilder().setName(name).setUuid(uuid).build().send(info);

        new OutgoingJoinPacketBuilder()
                .setCurrentWorldType(new PlayerWorldTypeView(world.getWorldData().getType()))
                .setFlatWorld(true)
                .setDebugWorld(true)
                .setRespawnScreen(true)
                .setGameMode(Gamemodes.CREATIVE)
                .setWorldTypes(AbsorbManagers.getRegistryManager().getWorldTypes().stream().map(Supplier::get).map(PlayerWorldTypeView::new).collect(Collectors.toUnmodifiableSet()))
                .setBiomes(AbsorbManagers.getRegistryManager().getBiomes().stream().map(Supplier::get).collect(Collectors.toUnmodifiableSet()))
                .build()
                .send(info);

        /*new OutgoingServerDifficultyPacketBuilder().setDifficulty(world.getWorldData().getDifficulty()).setLocked
        (true).build().sendAsync(info);*/

        /*new OutgoingAbilityPacketBuilder()
                .setFlyingAllowed(true)
                .setFlyingSpeed(0.5f)
                .setInstantBreak(true)
                .setInvulnerable(true)
                .setFieldOfView(70)
                .setFlying(true)
                .build().send(info);

        new OutgoingSwapHotbarPacketBuilder().setNewSlot((byte) 0).build().send(info);

        new OutgoingRegisterRecipePacketBuilder()
                .addRecipes(AbsorbManagers
                        .getRegistryManager()
                        .getRecipes()
                        .parallelStream()
                        .map(Supplier::get)
                        .collect(Collectors.toSet()))
                .build()
                .send(info);

        new OutgoingRegisterTagPacketBuilder()
                .addAll(AbsorbManagers
                        .getRegistryManager()
                        .getBlockTags()
                        .parallelStream()
                        .map(Supplier::get)
                        .collect(Collectors.toSet()))
                .build()
                .send(info);*/

        /*for (EntityEffect<?> effect : playerEntity.getEffects()) {
            new OutgoingEntityStatusUpdatePacketBuilder().setEffect(effect).setEntityId(worldHuman.getInstanceId()).build().send(info);
        }*/

        //new OutgoingPlayerMovementPacketBuilder().setPosition(spawnAt).build().send(info);

        Set<PlayerTab> tabs =
                AbsorbManagers
                        .getNetManager()
                        .getClients()
                        .parallelStream()
                        .filter(client -> !client.isHiddenToList())
                        .map(Client::createTab)
                        .collect(Collectors.toSet());

        new OutgoingPlayerTabUpdateAddPlayerPacketBuilder().addTabs(tabs).build().send(info);

        /*new OutgoingSpawnPositionPacketBuilder().setAngle(0).setLocation(world.getWorldData().getCompassPoint())
        .build().send(info);

        new OutgoingPlayerMovementPacketBuilder().setPosition(spawnAt).build().send(info);*/

        /*ChunkPart part = chunk.getPartWithBlockHeight(2);
        Set<ChunkSection> set = Set.of(part.asSection());

        new OutgoingChunkUpdatePacketBuilder().setChunkPart(part).setTrustLightOnEdge(false).addChunkSections(set)
        .build().send(info);*/

        System.out.println("Next");
    }
}
