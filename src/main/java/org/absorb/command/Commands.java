package org.absorb.command;

import org.absorb.AbsorbManagers;
import org.absorb.Main;
import org.absorb.command.node.CommandNode;
import org.absorb.command.node.CommandNodeBuilder;
import org.absorb.command.node.LiteralCommandNode;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public interface Commands {

    Supplier<LiteralCommandNode> STOP = () -> new CommandNodeBuilder<LiteralCommandNode>()
            .setName("stop")
            .setParent(AbsorbManagers.getCommandManager().getRootCommand())
            .setExecutable(context -> Main.stop())
            .build();

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
