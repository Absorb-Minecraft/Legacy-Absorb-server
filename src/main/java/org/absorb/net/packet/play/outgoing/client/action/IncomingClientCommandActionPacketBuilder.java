package org.absorb.net.packet.play.outgoing.client.action;

import org.absorb.net.Client;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class IncomingClientCommandActionPacketBuilder
        implements IncomingPacketBuilder<IncomingClientCommandActionPacket> {

    private ClientCommandAction commandAction;

    public ClientCommandAction getCommandAction() {
        return this.commandAction;
    }

    public IncomingClientCommandActionPacketBuilder setCommandAction(ClientCommandAction commandAction) {
        this.commandAction = commandAction;
        return this;
    }

    @Override
    public @NotNull PacketBuilder<IncomingClientCommandActionPacket> from(@NotNull Client connection,
                                                                          @NotNull ByteBuffer packetBytes) {
        int actionId = NetSerializers.VAR_INTEGER.read(0, packetBytes).value();
        this.commandAction = ClientCommandAction.getValue(actionId);
        return this;
    }

    @Override
    public @NotNull IncomingPacketBuilder<IncomingClientCommandActionPacket> reset() {
        this.commandAction = null;
        return this;
    }

    @Override
    public @NotNull IncomingPacketBuilder<IncomingClientCommandActionPacket> copy() {
        return new IncomingClientCommandActionPacketBuilder().setCommandAction(this.commandAction);
    }

    @Override
    public @NotNull IncomingClientCommandActionPacket build() {
        return new IncomingClientCommandActionPacket(this);
    }

    @Override
    public int getId() {
        return IncomingClientCommandActionPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
