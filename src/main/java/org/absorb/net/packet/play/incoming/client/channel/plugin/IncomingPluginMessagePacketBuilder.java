package org.absorb.net.packet.play.incoming.client.channel.plugin;

import org.absorb.net.Client;
import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.register.AbsorbKey;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class IncomingPluginMessagePacketBuilder implements IncomingPacketBuilder<IncomingPluginMessagePacket> {

    private AbsorbKey channel;
    private byte[] data;

    public IncomingPluginMessagePacketBuilder() {
        reset();
    }

    public AbsorbKey getChannel() {
        return this.channel;
    }

    public IncomingPluginMessagePacketBuilder setChannel(AbsorbKey channel) {
        this.channel = channel;
        return this;
    }

    public byte[] getData() {
        return this.data;
    }

    public IncomingPluginMessagePacketBuilder setData(byte... data) {
        this.data = data;
        return this;
    }

    @Override
    public int getId() {
        return IncomingPluginMessagePacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }

    @Override
    public PacketBuilder<IncomingPluginMessagePacket> from(Client client, ByteBuffer packetBytes) {
        NetEntryData<AbsorbKey> channelBuffer = NetSerializers.RESOURCE_KEY.read(0, packetBytes);
        this.channel = channelBuffer.value();
        return this;
    }

    @Override
    public IncomingPacketBuilder<IncomingPluginMessagePacket> reset() {
        this.channel = null;
        this.data = new byte[0];
        return this;
    }

    @Override
    public IncomingPacketBuilder<IncomingPluginMessagePacket> copy() {
        return new IncomingPluginMessagePacketBuilder().setChannel(this.channel).setData(this.data);
    }

    @Override
    public @NotNull IncomingPluginMessagePacket build() {
        return new IncomingPluginMessagePacket(this);
    }
}
