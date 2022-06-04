package org.absorb.command;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface CommandSender {

    void sendMessage(@Nullable UUID uuid, @NotNull Component component);

    default void sendMessage(Component component) {
        this.sendMessage(null, component);
    }
}
