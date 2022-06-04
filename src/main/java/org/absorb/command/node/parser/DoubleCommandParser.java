package org.absorb.command.node.parser;

import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

public class DoubleCommandParser implements CommandParser<Double> {
    @Override
    public @NotNull ParserResult<Double> parse(@NotNull ParserResult<?> previous) throws Exception {
        ParserResult<String> resultAsString = previous.getNextWord().orElseThrow(() -> new Exception("Could not find " +
                "any text for double"));
        try {
            return resultAsString.createFrom(resultAsString.getTaken(), Double.parseDouble(resultAsString.getValue()));
        } catch (NumberFormatException e) {
            throw new Exception(e);
        }
    }

    @Override
    public @NotNull String getName() {
        return "Double";
    }

    @Override
    public @NotNull String getKey() {
        return "double";
    }

    @Override
    public @NotNull String getHost() {
        return Identifiable.BRIGADIER_HOST;
    }
}
