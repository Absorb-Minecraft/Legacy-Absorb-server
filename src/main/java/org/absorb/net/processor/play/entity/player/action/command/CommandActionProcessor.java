package org.absorb.net.processor.play.entity.player.action.command;

import org.absorb.net.Client;
import org.absorb.net.packet.play.outgoing.client.action.IncomingClientCommandActionPacket;
import org.absorb.net.processor.NetProcess;

import java.io.IOException;

public class CommandActionProcessor implements NetProcess<IncomingClientCommandActionPacket> {
    @Override
    public void onProcess(Client connection, IncomingClientCommandActionPacket packet) throws IOException {
        
    }
}
