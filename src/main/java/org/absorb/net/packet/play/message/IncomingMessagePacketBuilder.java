package org.absorb.net.packet.play.message;

import org.absorb.net.data.Serializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class IncomingMessagePacketBuilder implements IncomingPacketBuilder<IncomingMessagePacket> {

    private String message;

    public String getMessage() {
        return this.message;
    }

    public IncomingMessagePacketBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public PacketBuilder<IncomingMessagePacket> from(ByteBuffer packetBytes) {
        this.message = Serializers.STRING.read(0, packetBytes).value();
        return this;
    }

    @Override
    public @NotNull IncomingMessagePacket build() {
        return new IncomingMessagePacket(this);
    }

    @Override
    public IncomingPacketBuilder<IncomingMessagePacket> reset() {
        this.message = null;
        return this;
    }

    @Override
    public IncomingPacketBuilder<IncomingMessagePacket> copy() {
        return new IncomingMessagePacketBuilder().setMessage(this.message);
    }

    @Override
    public int getId() {
        return IncomingMessagePacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
