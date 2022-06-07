package org.absorb.command;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.absorb.AbsorbManagers;
import org.absorb.command.node.*;
import org.absorb.command.node.executor.CommandContext;
import org.absorb.command.node.executor.NodeExecutor;
import org.absorb.command.node.executor.node.result.CommandNodeResult;
import org.absorb.command.node.executor.node.result.UnvaluedNodeResult;
import org.absorb.command.node.executor.node.result.ValueNodeResult;
import org.absorb.command.node.parser.ParserResult;
import org.absorb.command.node.parser.suggestion.SuggestionParser;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommandManager {

    private final RootCommandNode rootCommandNode = new CommandNodeBuilder<RootCommandNode>().build();

    public RootCommandNode getRootCommand() {
        return this.rootCommandNode;
    }

    public void execute(@NotNull CommandSender sender, @NotNull String rawCommand) {
        SortedSet<CommandNodeResult> possible = this.getPossibleCommand(sender, rawCommand);
        if (possible.isEmpty()) {
            return;
        }
        CommandContext context = new CommandContext(sender, possible);
        CommandNode executorNode = possible.last().getNode();
        Optional<NodeExecutor> opExecutor = executorNode.getExecutor();
        if (opExecutor.isEmpty()) {
            AbsorbManagers.getConsole().sendMessage(Component.text("Could not find command of: " + rawCommand).color(TextColor.color(255, 0, 0)));
            return;
        }
        NodeExecutor executor = opExecutor.get();
        if (!executor.canExecute(sender)) {
            AbsorbManagers.getConsole().sendMessage(Component.text("You cannot use this command").color(TextColor.color(255,
                    0, 0)));
            return;
        }
        executor.execute(context);
    }

    public SortedSet<String> getTabComplete(@NotNull CommandSender sender, @NotNull String rawCommand) {
        SortedSet<CommandNodeResult> possible = this.getPossibleCommand(sender, rawCommand);
        if (possible.isEmpty()) {
            return Collections.emptyNavigableSet();
        }
        CommandNodeResult last = possible.last();
        return last
                .getNode()
                .getChildren()
                .parallelStream()
                .flatMap(node -> {
                    if (node instanceof LiteralCommandNode literalCommandNode) {
                        return Collections.singleton(literalCommandNode.getName()).parallelStream();
                    }
                    if (node instanceof ArgumentCommandNode<?> argumentNode) {
                        if (argumentNode.getParser() instanceof SuggestionParser<?> suggestion) {
                            return suggestion.getSuggestions(new ParserResult<>(last.getRawCommand(),
                                    last.getConsumedCharacters(), null)).parallelStream();
                        }
                    }
                    return Stream.empty();

                })
                .collect(Collectors.toCollection(TreeSet::new));
    }

    private <T> void addTo(Collection<? super CommandNodeResult> set, ArgumentCommandNode<?> node, ParserResult<?> result) {
        ParserResult<T> castResult = (ParserResult<T>) result;
        ArgumentCommandNode<T> castNode = (ArgumentCommandNode<T>) node;
        set.add(new ValueNodeResult<>(castNode, set.size(), castResult));
    }

    private SortedSet<CommandNodeResult> getPossibleCommand(@NotNull CommandSender sender, @NotNull String rawCommand) {
        SortedSet<CommandNodeResult> set = new TreeSet<>(Comparator.comparing(CommandNodeResult::getIndex));
        CommandNode currentNode = this.rootCommandNode;
        set.add(new UnvaluedNodeResult(currentNode, 0, rawCommand, 0));
        if (rawCommand.isBlank()) {
            return set;
        }
        ParserResult<?> result = new ParserResult<>(rawCommand, 0, null);
        while (!currentNode.getChildren().isEmpty() || result.getTaken()==rawCommand.length()) {
            final ParserResult<?> finalResult = result;
            Optional<? extends ArgumentCommandNode<?>> opNode =
                    currentNode
                            .getChildren()
                            .parallelStream()
                            .filter(node -> node instanceof ArgumentCommandNode<?>)
                            .map(node -> (ArgumentCommandNode<?>) node)
                            .filter(node -> {
                                try {
                                    node.getParser().parse(finalResult);
                                    return true;
                                } catch (Exception e) {
                                    return false;
                                }
                            })
                            .findAny();
            if (opNode.isPresent()) {
                try {
                    result = opNode.get().getParser().parse(result);
                    currentNode = opNode.get();

                    this.addTo(set, opNode.get(), result);
                } catch (Exception e) {
                    throw new RuntimeException("Previously checked and passed, now checked and failed", e);
                }
                continue;
            }
            Optional<LiteralCommandNode> opLiteral =
                    currentNode
                            .getChildren()
                            .parallelStream()
                            .filter(node -> node instanceof LiteralCommandNode)
                            .map(node -> (LiteralCommandNode) node)
                            .filter(node -> finalResult.getNextWord().map(word -> word.getValue().equals(node.getName())).orElse(false))
                            .findAny();
            if (opLiteral.isPresent()) {
                currentNode = opLiteral.get();
                result = result.appendFrom(opLiteral.get().getName().length(), null);
                set.add(new UnvaluedNodeResult(opLiteral.get(), set.size(), rawCommand, result.getTaken()));
                continue;
            }
            break;
        }
        return set;
    }
}
