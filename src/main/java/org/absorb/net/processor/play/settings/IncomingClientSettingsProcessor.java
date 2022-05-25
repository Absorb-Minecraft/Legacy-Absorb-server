package org.absorb.net.processor.play.settings;

import org.absorb.AbsorbManagers;
import org.absorb.entity.living.human.tab.PlayerTab;
import org.absorb.net.Client;
import org.absorb.net.PlayingState;
import org.absorb.net.packet.play.chunk.OutgoingChunkUpdatePacketBuilder;
import org.absorb.net.packet.play.entity.player.compass.OutgoingSpawnPositionPacketBuilder;
import org.absorb.net.packet.play.entity.player.inventory.OutgoingSwapHotbarPacketBuilder;
import org.absorb.net.packet.play.entity.player.movement.outgoing.OutgoingPlayerMovementPacketBuilder;
import org.absorb.net.packet.play.entity.player.tab.add.OutgoingPlayerTabUpdateAddPlayerPacketBuilder;
import org.absorb.net.packet.play.settings.client.IncomingClientSettingsPacket;
import org.absorb.net.processor.NetProcess;
import org.absorb.world.area.AbsorbChunk;
import org.absorb.world.area.ChunkPart;
import org.absorb.world.area.ChunkSection;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class IncomingClientSettingsProcessor implements NetProcess<IncomingClientSettingsPacket> {
    @Override
    public void onProcess(Client connection, IncomingClientSettingsPacket packet) throws IOException {
        connection.setChatMode(packet.getChatMode());
        connection.setColouredChatMessages(packet.isChatColorEnabled());
        connection.setLocale(packet.getLocale());
        connection.setHiddenToList(packet.isShowOnList());
        connection.setViewDistance(packet.getViewDistance());


        /*new OutgoingSwapHotbarPacketBuilder().setNewSlot(connection.getInventory().getHotbar().getSelected()).build
        ().writeTo(connection);*/
        int id = connection.newTeleportId();
        /*connection.registerTeleportId(id);
        new OutgoingPlayerMovementPacketBuilder().setPosition(connection.getLocation()).setTeleportId(id).build().writeTo(connection);*/

        Set<PlayerTab> tabs =
                AbsorbManagers
                        .getNetManager()
                        .getClients()
                        .parallelStream()
                        .filter(client -> !client.isHiddenToList())
                        .map(Client::createTab)
                        .collect(Collectors.toSet());

        new OutgoingPlayerTabUpdateAddPlayerPacketBuilder().addTabs(tabs).build().writeTo(connection);

        new OutgoingSpawnPositionPacketBuilder().setAngle(0).setLocation(connection.getEntity().getWorld().getWorldData().getCompassPoint())
                .build().writeTo(connection);

        AbsorbChunk chunk = connection.getEntity().getWorld().generateChunkAtBlock(connection.getLocation().floorX(),
        connection.getLocation().floorZ());
        ChunkPart part = chunk.getPartWithBlockHeight(2);
        Set<ChunkSection> set = Set.of(part.asSection());

        /*new OutgoingChunkUpdatePacketBuilder().setChunkPart(part).setTrustLightOnEdge(false).addChunkSections(set)
        .build().writeToAsync(connection);*/

        connection.setPlayingState(PlayingState.LOGIN_PRE_DATA);

        id = connection.newTeleportId();
        connection.registerTeleportId(id);
        new OutgoingPlayerMovementPacketBuilder().setPosition(connection.getLocation()).setTeleportId(id).build().writeTo(connection);
    }
}
