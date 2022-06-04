package org.absorb.net.processor.login.pre;

import net.kyori.adventure.text.Component;
import org.absorb.AbsorbManagers;
import org.absorb.entity.EntityEffect;
import org.absorb.entity.WorldEntity;
import org.absorb.entity.living.human.Gamemodes;
import org.absorb.entity.living.human.Human;
import org.absorb.entity.living.human.effects.HumanEffects;
import org.absorb.entity.living.human.tab.PlayerTab;
import org.absorb.net.Client;
import org.absorb.net.PlayingState;
import org.absorb.net.packet.PacketState;
import org.absorb.net.packet.login.post.OutgoingLoginSuccessfulPacketBuilder;
import org.absorb.net.packet.login.pre.IncomingPreLoginPacket;
import org.absorb.net.packet.play.difficulty.OutgoingServerDifficultyPacketBuilder;
import org.absorb.net.packet.play.entity.player.compass.OutgoingSpawnPositionPacketBuilder;
import org.absorb.net.packet.play.entity.player.movement.outgoing.OutgoingPlayerMovementPacketBuilder;
import org.absorb.net.packet.play.entity.player.tab.add.OutgoingPlayerTabUpdateAddPlayerPacketBuilder;
import org.absorb.net.packet.play.entity.status.OutgoingEntityStatusUpdatePacketBuilder;
import org.absorb.net.packet.play.join.OutgoingJoinPacketBuilder;
import org.absorb.net.packet.play.settings.ability.OutgoingAbilityPacketBuilder;
import org.absorb.net.processor.NetProcess;
import org.absorb.world.AbsorbWorld;
import org.absorb.world.area.AbsorbChunk;
import org.absorb.world.type.PlayerWorldTypeView;
import org.spongepowered.math.vector.Vector3d;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PreLoginProcess implements NetProcess<IncomingPreLoginPacket> {
    @Override
    public void onProcess(Client info, IncomingPreLoginPacket packet) throws IOException {
        info.setUsername(packet.getUsername());
        String name = packet.getUsername();
        if (name.isBlank()) {
            info.disconnect(Component.text("Invalid username"));
            return;
        }
        UUID uuid = UUID.nameUUIDFromBytes(name.getBytes(StandardCharsets.UTF_8));
        info.setUuid(uuid);

        AbsorbWorld world = AbsorbManagers.getWorldManager().defaultWorld();
        Vector3d spawnAt = new Vector3d(0, 0, 0);
        world.generateChunkAtBlock(spawnAt.floorX(), spawnAt.floorZ());

        Human playerEntity = new Human();
        playerEntity.addEffect(HumanEffects.PERMISSION_LEVEL_ONE);
        WorldEntity worldHuman = world.spawnEntity(playerEntity, spawnAt);
        info.setEntity(worldHuman);

        info.setState(PacketState.PLAY);
        new OutgoingLoginSuccessfulPacketBuilder().setName(name).setUuid(uuid).build().writeTo(info);

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }

        new OutgoingJoinPacketBuilder()
                .setCurrentWorldType(new PlayerWorldTypeView(world.getWorldData().getType()))
                .setFlatWorld(true)
                .setDebugWorld(true)
                .setRespawnScreen(true)
                .setGameMode(Gamemodes.CREATIVE)
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

        /*new OutgoingAbilityPacketBuilder()
                .setFlyingAllowed(true)
                .setFlyingSpeed(0.5f)
                .setInstantBreak(true)
                .setInvulnerable(true)
                .setFieldOfView(70)
                .setFlying(true)
                .build()
                .writeTo(info);*/

        new OutgoingServerDifficultyPacketBuilder()
                .setDifficulty(world.getWorldData().getDifficulty())
                .setLocked(true)
                .build()
                .writeTo(info);

        /*new OutgoingSwapHotbarPacketBuilder().setNewSlot((byte) 0).build().writeTo(info);

        new OutgoingRegisterRecipePacketBuilder()
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

        for (EntityEffect<?> effect : playerEntity.getEffects()) {
            new OutgoingEntityStatusUpdatePacketBuilder().setEffect(effect).setEntityId(worldHuman.getInstanceId()).build().writeTo(info);
        }
    }
}
