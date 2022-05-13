package org.absorb.net.processor;

import org.absorb.net.Client;
import org.absorb.net.packet.IncomingPacket;

public interface NetProcess<P extends IncomingPacket> {

    void onProcess(Client connection, P packet);
}
