package org.absorb.command.node.parser;

import org.absorb.command.node.parser.properties.CommandParserProperty;
import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class BooleanCommandParser implements CommandParser<Boolean> {
    @Override
    public @NotNull String getName() {
        return "Boolean";
    }

    @Override
    public @NotNull String getKey() {
        return "bool";
    }

    @Override
    public @NotNull String getHost() {
        return Identifiable.BRIGADIER_HOST;
    }

    @Override
    public @NotNull ParserResult<Boolean> parse(@NotNull ParserResult<?> previous) throws Exception {
        ParserResult<String> asStringResult = previous.getNextWord().orElseThrow(() -> new Exception("Cannot find any" +
                " text"));

        if (asStringResult.getValue().equals("true")) {
            return previous.createFrom(asStringResult.getTaken(), true);
        }
        if (asStringResult.getValue().equals("false")) {
            return previous.createFrom(asStringResult.getTaken(), false);
        }
        throw new Exception(asStringResult.getValue() + " is not true or false");
    }

    @Override
    public Optional<CommandParserProperty<Boolean>> getProperty() {
        return Optional.empty();
    }
}
