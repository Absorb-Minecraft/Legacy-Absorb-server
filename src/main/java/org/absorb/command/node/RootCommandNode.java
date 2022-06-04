package org.absorb.command.node;

public class RootCommandNode extends AbstractCommandNode {

    public RootCommandNode(CommandNodeBuilder<RootCommandNode> builder) {
        super(builder);
    }

    @Override
    public byte getNodeTypeId() {
        return 0;
    }
}
