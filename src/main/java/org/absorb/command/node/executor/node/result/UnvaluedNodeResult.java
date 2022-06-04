package org.absorb.command.node.executor.node.result;

import org.absorb.command.node.CommandNode;

public class UnvaluedNodeResult implements CommandNodeResult {

    private final CommandNode node;
    private final int index;
    private final String originalRawCommand;
    private final int usedCharacters;

    public UnvaluedNodeResult(CommandNode node, int index, String rawCommand, int usedCharacters) {
        this.index = index;
        this.node = node;
        this.originalRawCommand = rawCommand;
        this.usedCharacters = usedCharacters;
    }

    @Override
    public CommandNode getNode() {
        return this.node;
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    public String getRawCommand() {
        return this.originalRawCommand;
    }

    @Override
    public int getConsumedCharacters() {
        return this.usedCharacters;
    }
}
