package org.absorb.command.node.parser;

import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

public interface CommandParser<V> extends Identifiable {

    @NotNull ParserResult<V> parse(@NotNull ParserResult<?> previous) throws Exception;
}
