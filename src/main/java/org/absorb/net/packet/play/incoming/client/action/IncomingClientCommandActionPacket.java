package org.absorb.net.packet.play.incoming.client.action;

import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.play.entity.player.action.command.CommandActionProcessor;
import org.jetbrains.annotations.NotNull;

public class IncomingClientCommandActionPacket implements IncomingPacket {

    private final @NotNull ClientCommandAction action;


    public static final int ID = 0x06;

    public IncomingClientCommandActionPacket(@NotNull IncomingClientCommandActionPacketBuilder builder) {
        this.action = builder.getCommandAction();
    }

    public @NotNull ClientCommandAction getAction() {
        return this.action;
    }

    @Override
    public @NotNull <P extends IncomingPacket> NetProcess<P> getProcess() {
        return (NetProcess<P>) new CommandActionProcessor();
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
        return new IncomingClientCommandActionPacketBuilder();
    }
}
