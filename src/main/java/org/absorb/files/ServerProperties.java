package org.absorb.files;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ServerProperties {

    private InetAddress ipAddress;
    private int port = 25565;
    private int ticksPerSecond = 20;

    public ServerProperties() throws UnknownHostException {
        ipAddress = InetAddress.getLocalHost();
    }

    public InetAddress getIpAddress() {
        return this.ipAddress;
    }

    public ServerProperties setIpAddress(InetAddress ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public int getPort() {
        return this.port;
    }

    public ServerProperties setPort(int port) {
        this.port = port;
        return this;
    }

    public long getNanoPerTick(){
        return 1000000000L/this.ticksPerSecond;
    }

    public int getTicksPerSecond() {
        return this.ticksPerSecond;
    }

    public ServerProperties setTicksPerSecond(int ticksPerSecond) {
        this.ticksPerSecond = ticksPerSecond;
        return this;
    }
}
