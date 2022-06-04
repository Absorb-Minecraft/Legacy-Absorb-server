package org.absorb.command.node.parser.suggestion;

import org.absorb.command.node.parser.CommandParser;
import org.absorb.command.node.parser.ParserResult;
import org.jetbrains.annotations.NotNull;

import java.util.SortedSet;

public interface SuggestionParser<V> extends CommandParser<V> {
    
    SortedSet<String> getSuggestions(@NotNull ParserResult<?> previous);
}
