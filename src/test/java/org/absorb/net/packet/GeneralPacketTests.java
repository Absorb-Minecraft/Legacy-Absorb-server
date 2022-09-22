package org.absorb.net.packet;

import org.absorb.net.NetManager;
import org.absorb.net.handler.NetHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;

public class GeneralPacketTests {

    @Test
    public void testNoDupedIds() {
        var handler = new NetHandler(null);
        var manager = new NetManager(handler);

        Collection<IncomingPacketBuilder<? extends IncomingPacket>> builders = manager.getAllIncomingPacketBuilders();
        for (IncomingPacketBuilder<?> testValue1 : builders) {
            for (IncomingPacketBuilder<?> testValue2 : builders) {
                if (testValue2 == testValue1) {
                    continue;
                }
                if (testValue2.getId() != testValue1.getId()) {
                    continue;
                }
                if (testValue2.getState() != testValue1.getState()) {
                    continue;
                }
                Assertions.fail("Both " + testValue1.getClass().getSimpleName() + " and " + testValue2
                        .getClass()
                        .getSimpleName() + " have the same state and id");
            }
        }
    }
}
