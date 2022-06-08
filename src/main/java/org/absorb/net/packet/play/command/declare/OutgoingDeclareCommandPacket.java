package org.absorb.net.packet.play.command.declare;

import org.absorb.command.CommandSender;
import org.absorb.command.node.*;
import org.absorb.command.node.parser.CommandParser;
import org.absorb.command.node.parser.properties.CommandParserProperty;
import org.absorb.command.node.parser.suggestion.SuggestionTypes;
import org.absorb.net.Client;
import org.absorb.net.data.ListSerializer;
import org.absorb.net.data.SerializerUtils;
import org.absorb.net.data.Serializers;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class OutgoingDeclareCommandPacket implements OutgoingPacket {

    public static final int ID = 0x12;

    private final @NotNull Collection<CommandNode> nodes = new LinkedList<>();

    public OutgoingDeclareCommandPacket(@NotNull OutgoingDeclaredCommandsPacketBuilder builder) {
        this.nodes.addAll(builder.getCommands());
    }

    private List<CommandNode> optimise(@NotNull CommandSender sender) {
        return this.nodes.parallelStream().filter(node -> node.canUse(sender)).toList();
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
        ByteBuffer sizeBuffer = Serializers.VAR_INTEGER.write(list.size());
        List<ByteBuffer> mappedNodes = list.stream().map(node -> (AbstractCommandNode) node).map(node -> {
            byte flags = node.getFlags();
            List<Integer> children =
                    node
                            .getChildren(stream)
                            .parallelStream()
                            .map(list::indexOf)
                            .toList();
            ByteBuffer flagBuffer = Serializers.BYTE.write(flags);
            ByteBuffer childrenBuffer = new ListSerializer<>(Serializers.VAR_INTEGER).write(children);
            ByteBuffer redirectBuffer = ByteBuffer.allocate(0);
            ByteBuffer nameBuffer = ByteBuffer.allocate(0);
            ByteBuffer parserBuffer = ByteBuffer.allocate(0);
            ByteBuffer propertiesBuffer = ByteBuffer.allocate(0);
            ByteBuffer suggestionsBuffer = ByteBuffer.allocate(0);
            if (node.getRedirect().isPresent()) {
                redirectBuffer = Serializers.VAR_INTEGER.write(list.indexOf(node.getRedirect().get()));
            }
            if(node instanceof NameableCommandNode nNode){
                nameBuffer = Serializers.STRING.write(nNode.getName());
            }
            if (node instanceof ArgumentCommandNode<?> cNode) {
                @NotNull CommandParser<?> parser = cNode.getParser();
                parserBuffer = Serializers.RESOURCE_KEY.write(parser.getResourceKey());
                if (parser.getProperty().isPresent()) {
                    CommandParserProperty<?> property = parser.getProperty().get();
                    propertiesBuffer = property.write();
                }
                Optional<SuggestionTypes> opType = cNode.getSuggestionType();
                if (opType.isPresent()) {
                    suggestionsBuffer = Serializers.RESOURCE_KEY.write(opType.get().getResourceKey());
                }
            }
            return SerializerUtils.collect(List.of(flagBuffer, childrenBuffer, redirectBuffer, nameBuffer,
                    parserBuffer, propertiesBuffer, suggestionsBuffer));
        }).toList();
        ByteBuffer nodesBuffer = SerializerUtils.collect(mappedNodes);
        ByteBuffer rootIndexBuffer = Serializers.VAR_INTEGER.write(rootIndex);
        return SerializerUtils.createPacket(ID, sizeBuffer, nodesBuffer, rootIndexBuffer);
    }
}
