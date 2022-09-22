package org.absorb.net.packet.play.incoming.client.channel.chat.preview;

import org.absorb.net.Client;
import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class IncomingMessagePreviewPacketBuilder implements IncomingPacketBuilder<IncomingMessagePreviewPacket> {

    private String message;
    private int queryId;

    public String getMessage() {
        return this.message;
    }

    public IncomingMessagePreviewPacketBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getQueryId() {
        return this.queryId;
    }

    public IncomingMessagePreviewPacketBuilder setQueryId(int id) {
        this.queryId = id;
        return this;
    }


    @Override
    public @NotNull PacketBuilder<IncomingMessagePreviewPacket> from(@NotNull Client connection,
                                                                     @NotNull ByteBuffer packetBytes) {
        NetEntryData<Integer> query = NetSerializers.INTEGER.read(0, packetBytes);
        NetEntryData<String> message = NetSerializers.STRING.read(query.endingPosition(), packetBytes);

        this.message = message.value();
        this.queryId = query.value();

        return this;
    }

    @Override
    public @NotNull IncomingPacketBuilder<IncomingMessagePreviewPacket> reset() {
        this.queryId = 0;
        this.message = null;
        return this;
    }

    @Override
    public @NotNull IncomingPacketBuilder<IncomingMessagePreviewPacket> copy() {
        return new IncomingMessagePreviewPacketBuilder().setMessage(this.message).setQueryId(this.queryId);
    }

    @Override
    public @NotNull IncomingMessagePreviewPacket build() {
        return new IncomingMessagePreviewPacket(this);
    }

    @Override
    public @NotNull Builder<IncomingMessagePreviewPacket> from(IncomingMessagePreviewPacket value) {
        return new IncomingMessagePreviewPacketBuilder().setMessage(value.getMessage()).setQueryId(value.getQueryId());
    }

    @Override
    public int getId() {
        return IncomingMessagePreviewPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
