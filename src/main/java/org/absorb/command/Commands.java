package org.absorb.command;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.absorb.AbsorbManagers;
import org.absorb.Main;
import org.absorb.command.node.ArgumentCommandNode;
import org.absorb.command.node.CommandNode;
import org.absorb.command.node.CommandNodeBuilder;
import org.absorb.command.node.LiteralCommandNode;
import org.absorb.command.node.executor.node.result.CommandNodeResult;
import org.absorb.command.node.executor.node.result.ValueNodeResult;
import org.absorb.command.node.parser.StringCommandParser;
import org.absorb.command.node.parser.properties.StringTypeProperty;
import org.absorb.module.Module;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public interface Commands {

    Supplier<LiteralCommandNode> ABSORB = () -> {
        LiteralCommandNode absorbLiteral = new CommandNodeBuilder<LiteralCommandNode>()
                .setName("absorb")
                .setParent(AbsorbManagers.getCommandManager().getRootCommand())
                .build();
        new CommandNodeBuilder<LiteralCommandNode>()
                .setName("info")
                .setParent(absorbLiteral)
                .setExecutable(context -> {
                    CommandSender sender = context.getSender();
                    sender.sendMessage(Component.text("[Absorb version]").color(NamedTextColor.GOLD).append(Component.text(Main.VERSION.toString())));
                    for (Module module : AbsorbManagers.getModuleManager().getModules()) {
                        sender.sendMessage(Component.text("[" + module.getDisplayName() + " version]").color(NamedTextColor.GOLD).append(Component.text(module.getVersion().toString())));
                    }
                })
                .build();

        return absorbLiteral;
    };

    Supplier<LiteralCommandNode> STOP = () -> {
        LiteralCommandNode stopLiteral = new CommandNodeBuilder<LiteralCommandNode>()
                .setName("stop")
                .setParent(AbsorbManagers.getCommandManager().getRootCommand())
                .setExecutable(context -> Main.stop())
                .build();
        new CommandNodeBuilder<ArgumentCommandNode<String>>()
                .setParent(stopLiteral)
                .setExecutable(context -> {
                    CommandNodeResult node = context.getResults().last();
                    if (!(node instanceof ValueNodeResult argumentResult)) {
                        throw new RuntimeException("Something wrong happened");
                    }

                    Main.stop(Component.text(argumentResult.getValue().getValue().toString()));
                })
                .setParser(new StringCommandParser(new StringTypeProperty(StringTypeProperty.StringType.GREEDY)))
                .setName("disconnect message")
                .build();
        return stopLiteral;
    };

    static Collection<CommandNode> getAll() {
        return Arrays.stream(Commands.class.getDeclaredFields())
                .filter(field -> Modifier.isPublic(field.getModifiers()))
                .filter(field -> Modifier.isStatic(field.getModifiers()))
                .filter(field -> Modifier.isFinal(field.getModifiers()))
                .filter(field -> field.getType().isAssignableFrom(Supplier.class))
                .map(field -> {
                    try {
                        Supplier<? extends CommandNode> supplier = (Supplier<? extends CommandNode>) field.get(null);
                        return supplier.get();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        //noinspection ReturnOfNull
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }
}
