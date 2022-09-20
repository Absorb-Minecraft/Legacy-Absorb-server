package org.absorb.net.processor.login.pre;

import net.kyori.adventure.text.Component;
import org.absorb.AbsorbManagers;
import org.absorb.entity.WorldEntity;
import org.absorb.entity.living.human.Gamemodes;
import org.absorb.entity.living.human.Human;
import org.absorb.entity.living.human.effects.HumanEffects;
import org.absorb.entity.living.human.tab.PlayerTab;
import org.absorb.message.type.ChatTypes;
import org.absorb.net.Client;
import org.absorb.net.PlayingState;
import org.absorb.net.packet.PacketState;
import org.absorb.net.packet.login.start.IncomingLoginStartPacket;
import org.absorb.net.packet.login.success.OutgoingLoginSuccessfulPacketBuilder;
import org.absorb.net.packet.play.outgoing.client.channel.command.declare.OutgoingDeclaredCommandsPacketBuilder;
import org.absorb.net.packet.play.outgoing.client.compass.OutgoingSpawnPositionPacketBuilder;
import org.absorb.net.packet.play.outgoing.client.join.OutgoingJoinPacketBuilder;
import org.absorb.net.packet.play.outgoing.client.movement.OutgoingPlayerMovementPacketBuilder;
import org.absorb.net.packet.play.outgoing.entity.tab.add.OutgoingPlayerTabUpdateAddPlayerPacketBuilder;
import org.absorb.net.packet.play.outgoing.world.difficulty.OutgoingServerDifficultyPacketBuilder;
import org.absorb.net.processor.NetProcess;
import org.absorb.world.World;
import org.absorb.world.type.PlayerWorldTypeView;
import org.spongepowered.math.vector.Vector3d;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PreLoginProcess implements NetProcess<IncomingLoginStartPacket> {
    @Override
    public void onProcess(Client info, IncomingLoginStartPacket packet) throws IOException {
        info.setUsername(packet.getUsername());
        String name = packet.getUsername();
        if (name.isBlank()) {
            info.disconnect(Component.text("Invalid username"));
            return;
        }
        UUID uuid = UUID.nameUUIDFromBytes(name.getBytes(StandardCharsets.UTF_8));
        info.setUuid(uuid);

        World world = AbsorbManagers.getWorldManager().defaultWorld();
        Vector3d spawnAt = new Vector3d(0, 0, 0);
        world.generateChunkAtBlock(spawnAt.floorX(), spawnAt.floorZ());

        Human playerEntity = new Human();
        playerEntity.addEffect(HumanEffects.PERMISSION_LEVEL_ONE);
        WorldEntity worldHuman = world.spawnEntity(playerEntity, spawnAt);
        info.setEntity(worldHuman);

        info.setState(PacketState.PLAY);
        info.setPlayingState(PlayingState.LOGIN_PRE_DATA);
        new OutgoingLoginSuccessfulPacketBuilder().setName(name).setUuid(uuid).build().writeTo(info);

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }

        new OutgoingJoinPacketBuilder()
                .setCurrentWorld(world)
                .setFlatWorld(true)
                .setDebugWorld(true)
                .setRespawnScreen(true)
                .setGameMode(Gamemodes.CREATIVE)
                .setChatTypes(List.of(ChatTypes.CHAT))
                .setWorldTypes(AbsorbManagers
                                       .getRegistryManager()
                                       .getWorldTypes()
                                       .stream()
                                       .map(Supplier::get)
                                       .map(PlayerWorldTypeView::new)
                                       .collect(Collectors.toUnmodifiableSet()))
                .setBiomes(AbsorbManagers
                                   .getRegistryManager()
                                   .getBiomes()
                                   .stream()
                                   .map(Supplier::get)
                                   .collect(Collectors.toUnmodifiableSet()))
                .build()
                .writeTo(info);

        new OutgoingDeclaredCommandsPacketBuilder()
                .walkAllCommands(AbsorbManagers.getCommandManager().getRootCommand())
                .build()
                .writeToAsync(info);

        /*new OutgoingAbilityPacketBuilder()
                .setFlyingAllowed(true)
                .setFlyingSpeed(0.05f)
                .setInstantBreak(true)
                .setInvulnerable(true)
                .setFieldOfView(0.1f)
                .setFlying(true)
                .build()
                .writeTo(info);*/

        new OutgoingServerDifficultyPacketBuilder()
                .setDifficulty(world.getWorldData().getDifficulty())
                .setLocked(true)
                .build()
                .writeTo(info);

        //new OutgoingSwapHotbarPacketBuilder().setNewSlot((byte) 3).build().writeTo(info);

        /*new OutgoingRegisterRecipePacketBuilder()
                .addRecipes(AbsorbManagers
                        .getRegistryManager()
                        .getRecipes()
                        .parallelStream()
                        .map(Supplier::get)
                        .collect(Collectors.toSet()))
                .build()
                .writeTo(info);

        new OutgoingRegisterTagPacketBuilder()
                .addAll(AbsorbManagers
                        .getRegistryManager()
                        .getBlockTags()
                        .parallelStream()
                        .map(Supplier::get)
                        .collect(Collectors.toSet()))
                .build()
                .writeTo(info);*/

        /*for (EntityEffect<?> effect : playerEntity.getEffects()) {
            new OutgoingEntityStatusUpdatePacketBuilder()
                    .setEffect(effect)
                    .setEntityId(worldHuman.getInstanceId())
                    .build()
                    .writeTo(info);
        }*/

        /*new OutgoingSwapHotbarPacketBuilder().setNewSlot(connection.getInventory().getHotbar().getSelected()).build
        ().writeTo(connection);*/
        int id = info.newTeleportId();
        info.registerTeleportId(id);
        new OutgoingPlayerMovementPacketBuilder().setPosition(spawnAt).setTeleportId(id).build().writeTo(info);

        Set<PlayerTab> tabs = AbsorbManagers
                .getNetManager()
                .getClients()
                .parallelStream()
                .filter(client -> !client.isHiddenToList())
                .map(Client::createTab)
                .collect(Collectors.toSet());

        new OutgoingPlayerTabUpdateAddPlayerPacketBuilder().addTabs(tabs).build().writeTo(info);

        new OutgoingSpawnPositionPacketBuilder()
                .setAngle(0)
                .setLocation(worldHuman.getWorld().getWorldData().getCompassPoint())
                .build()
                .writeTo(info);

        new Thread(info::updateChunks).start();

        //new OutgoingUpdateViewPacketBuilder().setChunk(chunk).build().writeToAsync(info);


        //new OutgoingAbilityPacketBuilder().fromClient(info).build().writeTo(info);

        id = info.newTeleportId();
        info.registerTeleportId(id);
        new OutgoingPlayerMovementPacketBuilder().setPosition(spawnAt).setTeleportId(id).build().writeTo(info);

    }
}
