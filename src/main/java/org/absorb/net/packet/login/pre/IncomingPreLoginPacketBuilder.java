package org.absorb.net.packet.login.pre;

import org.absorb.net.data.Serializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;

import java.nio.ByteBuffer;

public class IncomingPreLoginPacketBuilder implements IncomingPacketBuilder<IncomingPreLoginPacket> {

    private String username;

    public IncomingPreLoginPacketBuilder() {
        this.reset();
    }

    public String getUsername() {
        return this.username;
    }

    public IncomingPreLoginPacketBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public PacketBuilder<IncomingPreLoginPacket> from(ByteBuffer packetBytes) {
        this.username = Serializers.STRING.read(0, packetBytes).value();
        return this;
    }

    @Override
    public IncomingPreLoginPacket build() {
        return new IncomingPreLoginPacket(this);
    }

    @Override
    public IncomingPreLoginPacketBuilder reset() {
        this.username = null;
        return this;
    }

    @Override
    public IncomingPreLoginPacketBuilder copy() {
        return new IncomingPreLoginPacketBuilder().setUsername(this.username);
    }

    @Override
    public int getId() {
        return IncomingPreLoginPacket.ID;
    }

    @Override
    public PacketState getState() {
        return PacketState.LOGIN;
    }
}
