package org.absorb.command.node.parser;

import org.absorb.command.node.parser.properties.CommandParserProperty;
import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Supplier;

public class ResourceCommandParser<R extends Identifiable> implements CommandParser<R> {

    Supplier<Collection<R>> getter;

    public ResourceCommandParser(Supplier<Collection<R>> getter){
        this.getter = getter;
    }

    @Override
    public @NotNull ParserResult<R> parse(@NotNull ParserResult<?> previous) throws Exception {
        ParserResult<String> resultAsString = previous.getNextWord().orElseThrow(() -> new Exception("Cannot find resource key"));
        R resourceResult =
                this.getter.get().parallelStream().filter(resource -> resource.getResourceKey().asFormatted().equals(resultAsString.getValue())).findAny().orElseThrow(() -> new Exception("Cannot find acceptable resource key"));
        return previous.createFrom(resultAsString.getTaken(), resourceResult);
    }

    @Override
    public Optional<CommandParserProperty<R>> getProperty() {
        return Optional.empty();
    }

    @Override
    public @NotNull String getName() {
        return "Resource";
    }

    @Override
    public @NotNull String getKey() {
        return "resource";
    }

    @Override
    public @NotNull String getHost() {
        return Identifiable.MINECRAFT_HOST;
    }
}
