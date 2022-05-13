package org.absorb.net.packet;

import org.absorb.net.processor.NetProcess;
import org.jetbrains.annotations.NotNull;

public interface IncomingPacket extends Packet {

    <P extends IncomingPacket> @NotNull NetProcess<P> getProcess();

}
