package org.absorb.command.node.parser;

import org.absorb.command.node.parser.properties.CommandParserProperty;
import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public interface CommandParser<V> extends Identifiable {

    @NotNull ParserResult<V> parse(@NotNull ParserResult<?> previous) throws Exception;

    Optional<CommandParserProperty<V>> getProperty();

}
