package org.absorb.net.packet.play.message;

import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.play.message.MessageProcessor;
import org.jetbrains.annotations.NotNull;

public class IncomingMessagePacket implements IncomingPacket {

    public static final int ID = 0x03;

    private final String message;

    public IncomingMessagePacket(IncomingMessagePacketBuilder builder) {
        this.message = builder.getMessage();
        if (this.message==null) {
            throw new RuntimeException("Message must be set");
        }
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public @NotNull <P extends IncomingPacket> NetProcess<P> getProcess() {
        return (NetProcess<P>) new MessageProcessor();
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }

    @Override
    public @NotNull PacketBuilder<? extends Packet> toBuilder() {
        return new IncomingMessagePacketBuilder().setMessage(this.message);
    }
}
