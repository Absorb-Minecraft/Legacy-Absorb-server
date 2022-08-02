package org.absorb.net.packet.play.incoming.client.channel.command;

import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.play.message.CommandProcessor;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class IncomingCommandPacket implements IncomingPacket {

    private final @NotNull String command;
    private final long timestamp;
    private final long salt;
    private final @NotNull List<Map.Entry<String, byte[]>> arguments = new LinkedList<>();
    private final boolean signedPreview;
    public static final int ID = 0x03;

    public IncomingCommandPacket(IncomingCommandPacketBuilder packet) {
        this.salt = packet.getSalt();
        this.command = packet.getCommand();
        this.timestamp = packet.getTimestamp();
        this.signedPreview = packet.isSignedPreview();
    }

    public @NotNull String getCommand() {
        return this.command;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public long getSalt() {
        return this.salt;
    }

    public @NotNull List<Map.Entry<String, byte[]>> getArguments() {
        return this.arguments;
    }

    public boolean isSignedPreview() {
        return this.signedPreview;
    }

    @Override
    public @NotNull <P extends IncomingPacket> NetProcess<P> getProcess() {
        return (NetProcess<P>) new CommandProcessor();
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
        return new IncomingCommandPacketBuilder()
                .setCommand(this.command)
                .setSignedPreview(this.signedPreview)
                .setSalt(this.salt)
                .setTimestamp(this.timestamp)
                .setArguments(this.arguments);
    }
}
