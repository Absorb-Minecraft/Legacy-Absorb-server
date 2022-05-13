package org.absorb.net.packet.login.pre;

import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.NetProcessors;
import org.jetbrains.annotations.NotNull;

public class IncomingPreLoginPacket implements IncomingPacket {

    public static final int ID = 0x00;

    private final String username;

    public IncomingPreLoginPacket(IncomingPreLoginPacketBuilder builder) {
        this.username = builder.getUsername();
    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.LOGIN;
    }

    @Override
    public @NotNull PacketBuilder<? extends Packet> toBuilder() {
        return new IncomingPreLoginPacketBuilder().setUsername(this.username);
    }

    @Override
    public @NotNull <P extends IncomingPacket> NetProcess<P> getProcess() {
        return (NetProcess<P>) NetProcessors.PRE_LOGIN;
    }
}
