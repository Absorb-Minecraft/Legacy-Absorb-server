package org.absorb.net.packet.play.incoming.client.channel.chat;

import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.play.message.MessageProcessor;
import org.jetbrains.annotations.NotNull;

public class IncomingMessagePacket implements IncomingPacket {

    private final String message;
    private final long timestamp;
    private final byte[] sign;
    private final boolean preview;
    private final long salt;
    public static final int ID = 0x05;

    public IncomingMessagePacket(IncomingMessagePacketBuilder builder) {
        this.message = builder.getMessage();
        this.timestamp = builder.getTimestamp();
        this.preview = builder.isPreview();
        this.salt = builder.getSalt();

        this.sign = builder.getSignature();
        if (this.message == null) {
            throw new RuntimeException("Message must be set");
        }
    }

    public long getSalt() {
        return this.salt;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public byte[] getSignature() {
        return this.sign;
    }

    public boolean isPreview() {
        return this.preview;
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
