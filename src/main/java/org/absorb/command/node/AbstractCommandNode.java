package org.absorb.command.node;

import org.absorb.command.node.executor.NodeExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractCommandNode implements CommandNode {

    protected final @NotNull NodeExecutor executor;
    protected final List<NameableCommandNode> children = new LinkedList<>();
    protected final @Nullable CommandNode redirect;
    protected final @Nullable CommandNode parent;

    public AbstractCommandNode(CommandNodeBuilder<?> builder) {
        this.executor = builder.getExecutor();
        this.redirect = builder.getRedirectTo();
        this.parent = builder.getParent();
        if (this.parent!=null && this instanceof NameableCommandNode thisNameable) {
            this.parent.registerChild(thisNameable);
        }
    }

    public Optional<CommandNode> getParent() {
        return Optional.ofNullable(this.parent);
    }

    @Override
    public List<? extends NameableCommandNode> getChildren() {
        return Collections.unmodifiableList(this.children);
    }

    @Override
    public boolean registerChild(@NotNull NameableCommandNode node) {
        if (this.children.contains(node)) {
            return false;
        }
        return this.children.add(node);
    }

    @Override
    public Optional<NodeExecutor> getExecutor() {
        return Optional.ofNullable(this.executor);
    }

    @Override
    public Optional<CommandNode> getRedirect() {
        return Optional.ofNullable(this.redirect);
    }
}
