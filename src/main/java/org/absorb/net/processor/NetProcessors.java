package org.absorb.net.processor;

import org.absorb.net.processor.login.handshake.HandshakeProcess;
import org.absorb.net.processor.login.pre.PreLoginProcess;
import org.absorb.net.processor.status.ping.PingProcess;
import org.absorb.net.processor.status.request.StatusRequestProcess;

public class NetProcessors {

    public static final HandshakeProcess HANDSHAKE = new HandshakeProcess();
    public static final PreLoginProcess PRE_LOGIN = new PreLoginProcess();
    public static final StatusRequestProcess STATUS = new StatusRequestProcess();
    public static final PingProcess PING = new PingProcess();
}
