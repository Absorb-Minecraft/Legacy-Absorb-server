package org.absorb.command.node.executor;

import org.absorb.command.CommandSender;
import org.absorb.command.node.executor.node.result.CommandNodeResult;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CommandContext {

    private final SortedSet<CommandNodeResult> result =
            new TreeSet<>(Comparator.comparing(CommandNodeResult::getIndex));
    private final CommandSender sender;

    public CommandContext(CommandSender sender, Collection<CommandNodeResult> result) {
        this.sender = sender;
        this.result.addAll(result);
    }

    public @NotNull CommandSender getSender() {
        return this.sender;
    }

    public SortedSet<CommandNodeResult> getResults() {
        return Collections.unmodifiableSortedSet(this.result);
    }


}
