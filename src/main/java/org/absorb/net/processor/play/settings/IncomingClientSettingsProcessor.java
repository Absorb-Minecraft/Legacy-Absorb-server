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
    }
}
