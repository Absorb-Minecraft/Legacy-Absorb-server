package org.absorb.command.node.parser;

import org.absorb.command.node.parser.properties.CommandParserProperty;
import org.absorb.utils.NetworkIdentifiable;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public interface CommandParser<V> extends NetworkIdentifiable {

    @NotNull ParserResult<V> parse(@NotNull ParserResult<?> previous) throws Exception;

    Optional<CommandParserProperty<V>> getProperty();

}
