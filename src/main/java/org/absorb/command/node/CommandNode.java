package org.absorb.command.node;

import org.absorb.command.CommandSender;
import org.absorb.command.node.executor.NodeExecutor;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public interface CommandNode {

    byte getNodeTypeId();

    int getDepth();

    List<? extends NameableCommandNode> getChildren();

    default List<? extends NameableCommandNode> getChildren(@NotNull CommandSender sender) {
        return this.getChildren().parallelStream().filter(child -> child.canUse(sender)).toList();
    }

    boolean registerChild(@NotNull NameableCommandNode node);

    Optional<NodeExecutor> getExecutor();

    Optional<CommandNode> getRedirect();

    default boolean canUse(@NotNull CommandSender sender) {
        if (this.getExecutor().isPresent()) {
            if (this.getExecutor().get().canExecute(sender)) {
                return true;
            }
        }
        return !this.getChildren(sender).isEmpty();
    }

}
