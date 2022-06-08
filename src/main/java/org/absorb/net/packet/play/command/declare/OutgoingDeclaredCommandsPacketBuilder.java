package org.absorb.net.packet.play.command.declare;

import org.absorb.command.node.CommandNode;
import org.absorb.command.node.NameableCommandNode;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class OutgoingDeclaredCommandsPacketBuilder implements OutgoingPacketBuilder<OutgoingDeclareCommandPacket> {

    private final List<CommandNode> nodes = new LinkedList<>();

    public List<CommandNode> getCommands() {
        return this.nodes;
    }

    public OutgoingDeclaredCommandsPacketBuilder addAllCommands(Collection<? extends CommandNode> collection) {
        this.nodes.addAll(collection);
        return this;
    }

    public OutgoingDeclaredCommandsPacketBuilder walkAllCommands(@NotNull CommandNode node) {
        this.nodes.add(node);
        for (NameableCommandNode node1 : node.getChildren()) {
            this.walkAllCommands(node1);
        }
        return this;
    }

    @Override
    public @NotNull OutgoingDeclareCommandPacket build() {
        return new OutgoingDeclareCommandPacket(this);
    }

    @Override
    public PacketBuilder<OutgoingDeclareCommandPacket> reset() {
        this.nodes.clear();
        return this;
    }

    @Override
    public PacketBuilder<OutgoingDeclareCommandPacket> copy() {
        return new OutgoingDeclaredCommandsPacketBuilder().addAllCommands(this.getCommands());
    }

    @Override
    public int getId() {
        return OutgoingDeclareCommandPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
