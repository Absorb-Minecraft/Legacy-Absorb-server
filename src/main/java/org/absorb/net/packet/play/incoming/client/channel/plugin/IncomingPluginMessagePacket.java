package org.absorb.net.packet.play.incoming.client.channel.plugin;

import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.register.AbsorbKey;
import org.jetbrains.annotations.NotNull;

public class IncomingPluginMessagePacket implements IncomingPacket {

    public static final int ID = 0x0C;

    private final @NotNull AbsorbKey channel;
    private final byte[] data;

    public IncomingPluginMessagePacket(@NotNull IncomingPluginMessagePacketBuilder builder) {
        this.channel = builder.getChannel();
        this.data = builder.getData();
    }


    @Override
    public @NotNull <P extends IncomingPacket> NetProcess<P> getProcess() {
        return (connection, packet) -> {

        };
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
        return new IncomingPluginMessagePacketBuilder().setChannel(this.channel).setData(this.data);
    }
}
