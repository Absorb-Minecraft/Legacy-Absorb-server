package org.absorb.net.packet.play.outgoing.world.chunk.position;

import org.absorb.net.packet.OnWiki;
import org.absorb.net.packet.PacketState;
import org.absorb.net.packet.WikiUtils;
import org.absorb.net.packet.play.incoming.client.ability.IncomingChangeAbilityPacket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@OnWiki(urlTitle = "Set_Center_Chunk", state = PacketState.PLAY)
public class OutgoingUpdateViewPacketTest {
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
        Assertions.assertEquals(wikiEntry.getId(), IncomingChangeAbilityPacket.ID);
    }
}
