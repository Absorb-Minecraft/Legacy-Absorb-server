package org.absorb.command.node;

import org.absorb.command.node.executor.NodeExecutor;
import org.absorb.command.node.parser.CommandParser;
import org.absorb.command.node.parser.properties.CommandParserProperty;
import org.absorb.command.node.parser.suggestion.SuggestionTypes;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

public class CommandNodeBuilder<N extends CommandNode> implements Builder<N> {

    private String name;
    private CommandNode parent;
    private CommandNode redirectTo;
    private CommandParser<?> parser;
    private CommandParserProperty<?> property;
    private SuggestionTypes suggestionType;
    private NodeExecutor executor;

    public String getName() {
        return this.name;
    }

    public CommandNodeBuilder<N> setName(String name) {
        this.name = name;
        return this;
    }

    public CommandNode getParent() {
        return this.parent;
    }

    public CommandNodeBuilder<N> setParent(CommandNode parent) {
        this.parent = parent;
        return this;
    }

    public CommandNode getRedirectTo() {
        return this.redirectTo;
    }

    public CommandNodeBuilder<N> setRedirectTo(CommandNode redirectTo) {
        this.redirectTo = redirectTo;
        return this;
    }

    public CommandParser<?> getParser() {
        return this.parser;
    }

    public CommandNodeBuilder<N> setParser(CommandParser<?> parser) {
        this.parser = parser;
        return this;
    }

    public CommandParserProperty<?> getProperty() {
        return this.property;
    }

    public CommandNodeBuilder<N> setProperty(CommandParserProperty<?> property) {
        this.property = property;
        return this;
    }

    public SuggestionTypes getSuggestionType() {
        return this.suggestionType;
    }

    public CommandNodeBuilder<N> setSuggestionType(SuggestionTypes suggestionType) {
        this.suggestionType = suggestionType;
        return this;
    }

    public NodeExecutor getExecutor() {
        return this.executor;
    }

    public CommandNodeBuilder<N> setExecutable(NodeExecutor executor) {
        this.executor = executor;
        return this;
    }

    private @NotNull RootCommandNode buildRoot() {
        if (this.name!=null) {
            throw new IllegalArgumentException("Root command argument cannot have a name. Set parent if another type");
        }
        if (this.redirectTo!=null) {
            throw new IllegalArgumentException("Root command argument cannot have a redirect. Set parent if another " +
                    "type");
        }
        if (this.parser!=null) {
            throw new IllegalArgumentException("Root command argument cannot have a parser. Set parent if another " +
                    "type");
        }
        if (this.property!=null) {
            throw new IllegalArgumentException("Root command argument cannot have a property. Set parent if another " +
                    "type");
        }
        if (this.suggestionType!=null) {
            throw new IllegalArgumentException("Root command argument cannot have a suggestion type. Set parent if " +
                    "another type");
        }
        if (this.executor!=null) {
            throw new IllegalArgumentException("Root command argument cannot have a executor. Set parent if another " +
                    "type");
        }
        return new RootCommandNode((CommandNodeBuilder<RootCommandNode>) this);
    }

    private @NotNull LiteralCommandNode buildLiteral() {
        return new LiteralCommandNode((CommandNodeBuilder<LiteralCommandNode>) this);
    }

    private @NotNull <T> ArgumentCommandNode<?> buildArgument() {
        return new ArgumentCommandNode<>((CommandNodeBuilder<ArgumentCommandNode<T>>)this);
    }

    @Override
    public @NotNull N build() {
        AbstractCommandNode node = null;
        if (this.parent==null) {
            node = this.buildRoot();
        }
        if (this.name==null && node == null) {
            throw new IllegalArgumentException("Name is required for Literal or Argument Nodes");
        }
        if (this.parser!=null && node == null) {
            node = this.buildArgument();
        }else if(node == null) {
            node = this.buildLiteral();
        }
        if(node instanceof NameableCommandNode ret) {
            node.getParent().ifPresent(parent -> parent.registerChild(ret));
        }
        return (N)node;
    }

    @Override
    public @NotNull CommandNodeBuilder<N> reset() {
        this.executor = null;
        this.suggestionType = null;
        this.parser = null;
        this.property = null;
        this.redirectTo = null;
        this.parent = null;
        this.name = null;
        return this;
    }

    @Override
    public @NotNull CommandNodeBuilder<N> copy() {
        return new CommandNodeBuilder<N>().setExecutable(this.executor).setName(this.name).setParent(this.parent).setParser(this.parser).setRedirectTo(this.redirectTo).setSuggestionType(this.suggestionType).setProperty(this.property);
    }
}
