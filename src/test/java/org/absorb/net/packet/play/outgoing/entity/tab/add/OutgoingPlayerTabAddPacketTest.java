package org.absorb.net.packet.play.outgoing.entity.tab.add;

import org.absorb.entity.living.human.Gamemode;
import org.absorb.entity.living.human.Gamemodes;
import org.absorb.entity.living.human.tab.PlayerTab;
import org.absorb.entity.living.human.tab.PlayerTabBuilder;
import org.absorb.net.Client;
import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.OnWiki;
import org.absorb.net.packet.PacketState;
import org.absorb.net.packet.WikiUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;

@OnWiki(state = PacketState.PLAY, urlTitle = "Player_Info")
public class OutgoingPlayerTabAddPacketTest {

    /**
     * This checks if the packet id is the latest on the wiki. If it isn't then this packet needs updating.
     * <p>
     * Packet Id's are normally the first to be changed and therefore typically a good lightweight point of call for
     * when the protocol has changed and where.
     * <p>
     * This will be skipped if there is a connection issue to the file page, however if the title url has changed, it
     * will not be skipped. This accounts for when the Wiki changes the title name
     */
    @Test
    public void testPacketId() {
        WikiUtils.WikiEntry wikiEntry;
        try {
            wikiEntry = WikiUtils.getEntry(this);
        } catch (RuntimeException e) {
            Assertions.fail(e);
            return;
        } catch (IOException e) {
            Assumptions.assumeFalse(true, "Cannot connect to Minecraft protocol Wiki");
            return;
        }
        Assertions.assertEquals(wikiEntry.getId(), OutgoingPlayerTabUpdateAddPlayerPacket.ID);
    }

    @Test
    public void testCanReadWritten() {
        UUID uuid = UUID.randomUUID();
        String name = "Test";
        int ping = 100;
        Gamemode mode = Gamemodes.CREATIVE;
        Client client;
        try {
            client = new Client(new Socket());
        } catch (IOException e) {
            e.printStackTrace();
            Assertions.fail();
            return;
        }

        PlayerTab tab = new PlayerTabBuilder().setName(name).setPing(ping).setGameMode(mode).setUuid(uuid).build();

        OutgoingPlayerTabUpdateAddPlayerPacket tabPacket = new OutgoingPlayerTabUpdateAddPlayerPacketBuilder()
                .addTabs(Collections.singleton(tab))
                .build();

        ByteBuffer buffer = tabPacket.toBytes(client);

        //assert

        NetEntryData<Integer> lengthBuffer = NetSerializers.VAR_INTEGER.read(0, buffer);
        NetEntryData<Integer> idBuffer = NetSerializers.VAR_INTEGER.read(lengthBuffer.endingPosition(), buffer);
        NetEntryData<Integer> actionBuffer = NetSerializers.VAR_INTEGER.read(idBuffer.endingPosition(), buffer);
        NetEntryData<Integer> sizeBuffer = NetSerializers.VAR_INTEGER.read(actionBuffer.endingPosition(), buffer);
        NetEntryData<UUID> uuidBuffer = NetSerializers.UUID.read(sizeBuffer.endingPosition(), buffer);
        NetEntryData<String> nameBuffer = NetSerializers.STRING.read(uuidBuffer.endingPosition(), buffer);
        NetEntryData<Integer> propertiesSizeBuffer = NetSerializers.VAR_INTEGER.read(nameBuffer.endingPosition(),
                                                                                     buffer);
        NetEntryData<Integer> gamemodeBuffer = NetSerializers.VAR_INTEGER.read(propertiesSizeBuffer.endingPosition(),
                                                                               buffer);
        NetEntryData<Integer> pingBuffer = NetSerializers.VAR_INTEGER.read(gamemodeBuffer.endingPosition(), buffer);
        NetEntryData<Boolean> hasDisplayNameBuffer = NetSerializers.BOOLEAN.read(pingBuffer.endingPosition(), buffer);

        //assertion
        int currentLength = Arrays.copyOfRange(buffer.array(),
                                               lengthBuffer.endingPosition(),
                                               buffer.array().length).length;
        Assertions.assertEquals(currentLength, lengthBuffer.value());
        Assertions.assertEquals(uuid, uuidBuffer.value());
        Assertions.assertEquals(name, nameBuffer.value());
        Assertions.assertEquals(ping, pingBuffer.value());
        Assertions.assertEquals(mode.getNetworkId(), gamemodeBuffer.value());
        Assertions.assertFalse(hasDisplayNameBuffer.value());
    }
}
