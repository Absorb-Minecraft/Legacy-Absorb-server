package org.absorb.command.node;

import org.jetbrains.annotations.NotNull;

public class LiteralCommandNode extends AbstractCommandNode implements NameableCommandNode {

    private final @NotNull String name;

    public LiteralCommandNode(CommandNodeBuilder<LiteralCommandNode> builder) {
        super(builder);
        this.name = builder.getName();
    }

    public @NotNull String getName() {
        return this.name;
    }

    @Override
    public byte getNodeTypeId() {
        return 1;
    }

    @Override
    public int hashCode() {
        return this.parent.hashCode() + this.getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LiteralCommandNode node)) {
            return false;
        }
        return this.name.equals(node.getName()) && this.parent==node.parent;
    }
}
