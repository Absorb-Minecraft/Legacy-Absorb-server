package org.absorb.command.node.parser;

import org.absorb.command.node.parser.properties.CommandParserProperty;
import org.absorb.command.node.parser.properties.MinMaxParserProperty;
import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class DoubleCommandParser implements CommandParser<Double> {

    private final @Nullable MinMaxParserProperty<Double> parser;

    public DoubleCommandParser() {
        this(null);
    }

    public DoubleCommandParser(@Nullable MinMaxParserProperty<Double> parser) {
        this.parser = parser;
    }


    @Override
    public @NotNull ParserResult<Double> parse(@NotNull ParserResult<?> previous) throws Exception {
        ParserResult<String> resultAsString = previous.getNextWord().orElseThrow(() -> new Exception("Could not find " +
                "any text for double"));
        double result = Double.parseDouble(resultAsString.getValue());
        if (this.parser!=null) {
            if (!this.parser.getMaximum().map(value -> value <= result).orElse(true)) {
                throw new Exception("Value is too high");
            }
            if (!this.parser.getMinimum().map(value -> value >= result).orElse(true)) {
                throw new Exception("Value is too low");
            }
        }
        try {
            return resultAsString.createFrom(resultAsString.getTaken(), result);
        } catch (NumberFormatException e) {
            throw new Exception(e);
        }
    }

    @Override
    public Optional<CommandParserProperty<Double>> getProperty() {
        return Optional.empty();
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
