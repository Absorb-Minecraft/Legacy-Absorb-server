package org.absorb.command.node;

import org.absorb.command.node.executor.NodeExecutor;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public interface CommandNode {

    byte getNodeTypeId();

    List<? extends NameableCommandNode> getChildren();

    boolean registerChild(@NotNull NameableCommandNode node);

    Optional<NodeExecutor> getExecutor();

    Optional<CommandNode> getRedirect();

}
