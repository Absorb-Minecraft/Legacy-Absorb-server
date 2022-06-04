package org.absorb.command.node.executor.node.result;

import org.absorb.command.node.CommandNode;

public interface CommandNodeResult {

    CommandNode getNode();

    int getIndex();

    String getRawCommand();

    int getConsumedCharacters();


}
