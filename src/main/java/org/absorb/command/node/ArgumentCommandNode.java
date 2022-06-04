package org.absorb.command.node;

import org.absorb.command.node.parser.CommandParser;
import org.absorb.command.node.parser.properties.CommandParserProperty;
import org.absorb.command.node.parser.suggestion.SuggestionTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ArgumentCommandNode<A> extends AbstractCommandNode implements NameableCommandNode {

    private final @NotNull String name;
    private final @NotNull CommandParser<A> parser;
    private final @Nullable CommandParserProperty<? super A> property;
    private final @Nullable SuggestionTypes suggestionType;

    public ArgumentCommandNode(CommandNodeBuilder<ArgumentCommandNode<A>> builder) {
        super(builder);
        this.name = builder.getName();
        this.parser = (CommandParser<A>) builder.getParser();
        this.property = (CommandParserProperty<? super A>) builder.getProperty();
        this.suggestionType = builder.getSuggestionType();
    }


    public @NotNull String getName() {
        return this.name;
    }

    public @NotNull CommandParser<A> getParser() {
        return this.parser;
    }

    public Optional<CommandParserProperty<? super A>> getProperty() {
        return Optional.ofNullable(this.property);
    }

    public @NotNull Optional<SuggestionTypes> getSuggestionType() {
        return Optional.ofNullable(this.suggestionType);
    }

    @Override
    public byte getNodeTypeId() {
        return 2;
    }

    public int hashCode() {
        return this.parent.hashCode() + this.getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ArgumentCommandNode node)) {
            return false;
        }
        return this.name.equals(node.getName()) && this.parent==node.parent;
    }
}
