package org.absorb.command.node.parser;

import org.absorb.command.node.parser.properties.CommandParserProperty;
import org.absorb.command.node.parser.properties.StringTypeProperty;
import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class StringCommandParser implements CommandParser<String> {

    private final StringTypeProperty type;

    public StringCommandParser(@NotNull StringTypeProperty type) {
        this.type = type;
    }

    @Override
    public @NotNull ParserResult<String> parse(@NotNull ParserResult<?> previous) throws Exception {
        switch (this.type.getType()) {
            case SINGLE -> {
                return previous.getNextWord().orElseThrow(() -> new Exception("No more arguments"));
            }
            case GREEDY -> {
                return previous.createFrom(previous.getOriginalText().length(), previous.getLeftText());
            }
            case QUOTED -> {
                return previous.getNextQuote().orElseThrow(() -> new Exception("No more arguments"));
            }
            default -> throw new RuntimeException("Unknown String Type");
        }
    }

    @Override
    public Optional<CommandParserProperty<String>> getProperty() {
        return Optional.of(this.type);
    }

    @Override
    public @NotNull String getName() {
        return "String";
    }

    @Override
    public @NotNull String getKey() {
        return "string";
    }

    @Override
    public @NotNull String getHost() {
        return Identifiable.BRIGADIER_HOST;
    }
}
