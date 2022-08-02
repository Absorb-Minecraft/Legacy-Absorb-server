package org.absorb.net.packet.play.outgoing.client.channel.command.declare;

import org.absorb.command.CommandSender;
import org.absorb.command.node.*;
import org.absorb.command.node.parser.CommandParser;
import org.absorb.command.node.parser.properties.CommandParserProperty;
import org.absorb.command.node.parser.suggestion.SuggestionTypes;
import org.absorb.net.Client;
import org.absorb.net.data.NetList;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;
import java.util.*;

public class OutgoingDeclareCommandPacket implements OutgoingPacket {

    private final @NotNull Collection<CommandNode> nodes = new LinkedList<>();
    public static final int ID = 0x0F;

    public OutgoingDeclareCommandPacket(@NotNull OutgoingDeclaredCommandsPacketBuilder builder) {
        this.nodes.addAll(builder.getCommands());
    }

    public Collection<CommandNode> getNodes() {
        return Collections.unmodifiableCollection(this.nodes);
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
    public @NotNull OutgoingPacketBuilder<? extends Packet> toBuilder() {
        return new OutgoingDeclaredCommandsPacketBuilder().addAllCommands(this.nodes);
    }

    @Override
    public ByteBuffer toBytes(Client stream) {
        List<CommandNode> list = this.optimise(stream);
        Optional<CommandNode> opNode = list.parallelStream().filter(node -> node instanceof RootCommandNode).findAny();
        if (opNode.isEmpty()) {
            throw new IllegalStateException("No Root command node was supplied");
        }
        int rootIndex = list.indexOf(opNode.get());
        ByteBuffer sizeBuffer = NetSerializers.VAR_INTEGER.write(list.size());
        List<ByteBuffer> mappedNodes = list.stream().map(node -> (AbstractCommandNode) node).map(node -> {
            byte flags = node.getFlags();
            List<Integer> children = node.getChildren(stream).parallelStream().map(list::indexOf).toList();
            ByteBuffer flagBuffer = NetSerializers.BYTE.write(flags);
            ByteBuffer childrenBuffer = new NetList<>(NetSerializers.VAR_INTEGER).write(children);
            ByteBuffer redirectBuffer = ByteBuffer.allocate(0);
            ByteBuffer nameBuffer = ByteBuffer.allocate(0);
            ByteBuffer parserBuffer = ByteBuffer.allocate(0);
            ByteBuffer propertiesBuffer = ByteBuffer.allocate(0);
            ByteBuffer suggestionsBuffer = ByteBuffer.allocate(0);
            if (node.getRedirect().isPresent()) {
                redirectBuffer = NetSerializers.VAR_INTEGER.write(list.indexOf(node.getRedirect().get()));
            }
            if (node instanceof NameableCommandNode nNode) {
                nameBuffer = NetSerializers.STRING.write(nNode.getName());
            }
            if (node instanceof ArgumentCommandNode<?> cNode) {
                @NotNull CommandParser<?> parser = cNode.getParser();
                parserBuffer = NetSerializers.VAR_INTEGER.write(parser.getNetworkId());
                if (parser.getProperty().isPresent()) {
                    CommandParserProperty<?> property = parser.getProperty().get();
                    propertiesBuffer = property.write();
                }
                Optional<SuggestionTypes> opType = cNode.getSuggestionType();
                if (opType.isPresent()) {
                    suggestionsBuffer = NetSerializers.RESOURCE_KEY.write(opType.get().getResourceKey());
                }
            }
            return NetUtils.collect(List.of(flagBuffer,
                                            childrenBuffer,
                                            redirectBuffer,
                                            nameBuffer,
                                            parserBuffer,
                                            propertiesBuffer,
                                            suggestionsBuffer));
        }).toList();
        ByteBuffer nodesBuffer = NetUtils.collect(mappedNodes);
        ByteBuffer rootIndexBuffer = NetSerializers.VAR_INTEGER.write(rootIndex);
        return NetUtils.createPacket(ID, sizeBuffer, nodesBuffer, rootIndexBuffer);
    }

    private List<CommandNode> optimise(@NotNull CommandSender sender) {
        return this.nodes.parallelStream().filter(node -> node.canUse(sender)).toList();
    }
}
