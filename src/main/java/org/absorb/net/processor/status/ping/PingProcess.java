package org.absorb.net.processor.status.ping;

import org.absorb.AbsorbManagers;
import org.absorb.net.Client;
import org.absorb.net.packet.status.ping.IncomingPingPacket;
import org.absorb.net.packet.status.pong.OutgoingPongPacketBuilder;
import org.absorb.net.processor.NetProcess;

import java.io.IOException;

public class PingProcess implements NetProcess<IncomingPingPacket> {
    @Override
    public void onProcess(Client info, IncomingPingPacket packet) throws IOException {
        new OutgoingPongPacketBuilder().setPayload(packet.getPayload()).build().writeTo(info);
        AbsorbManagers.getNetManager().unregister(info);
    }
}
