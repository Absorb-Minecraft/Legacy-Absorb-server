package org.absorb.command.node;

import org.jetbrains.annotations.NotNull;

public interface NameableCommandNode extends CommandNode{

    @NotNull String getName();
}
