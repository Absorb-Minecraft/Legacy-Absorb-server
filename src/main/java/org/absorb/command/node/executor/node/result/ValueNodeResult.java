package org.absorb.command.node.executor.node.result;

import org.absorb.command.node.ArgumentCommandNode;
import org.absorb.command.node.parser.ParserResult;

public class ValueNodeResult<A> implements CommandNodeResult {

    private final ArgumentCommandNode<A> node;
    private final int index;
    private final ParserResult<A> value;

    public ValueNodeResult(ArgumentCommandNode<A> node, int index, ParserResult<A> value) {
        this.index = index;
        this.value = value;
        this.node = node;
    }

    @Override
    public ArgumentCommandNode<A> getNode() {
        return this.node;
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    public String getRawCommand() {
        return this.value.getOriginalText();
    }

    @Override
    public int getConsumedCharacters() {
        return this.value.getTaken();
    }

    public ParserResult<A> getValue() {
        return this.value;
    }
}
