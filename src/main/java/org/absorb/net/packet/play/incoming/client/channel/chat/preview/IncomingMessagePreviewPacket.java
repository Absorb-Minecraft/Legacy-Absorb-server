package org.absorb.net.packet.play.incoming.client.channel.chat.preview;

import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.jetbrains.annotations.NotNull;

public class IncomingMessagePreviewPacket implements IncomingPacket {

    private final int queryId;

    private final String message;

    public static final int ID = 0x06;

    public IncomingMessagePreviewPacket(@NotNull IncomingMessagePreviewPacketBuilder builder) {
        this.message = builder.getMessage();
        this.queryId = builder.getQueryId();
        if (this.message == null) {
            throw new IllegalArgumentException("Message must be specified");
        }
    }

    public String getMessage() {
        return this.message;
    }

    public int getQueryId() {
        return this.queryId;
    }

    @Override
    public @NotNull <P extends IncomingPacket> NetProcess<P> getProcess() {
        return null;
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
        return new IncomingMessagePreviewPacketBuilder().setMessage(this.message).setQueryId(this.queryId);
    }
}
