package org.absorb.command.node.executor;

import org.absorb.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public interface NodeExecutor {

    default boolean canExecute(@NotNull CommandSender sender) {
        return true;
    }

    void execute(@NotNull CommandContext context);
}
