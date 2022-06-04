package org.absorb.message.channel.defaults;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.absorb.AbsorbManagers;
import org.absorb.message.MessagePosition;
import org.absorb.message.channel.ChatChannel;
import org.absorb.net.Client;
import org.absorb.net.PlayingState;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.stream.Collectors;

public class DefaultChatChannel implements ChatChannel {
    @Override
    public @NotNull Component format(@NotNull Client client, @NotNull Component component) {
        Component prefixStart = Component.text("[").color(TextColor.color(100, 100, 100));
        Component clientName = Component.text(client.getUsername()).color(TextColor.color(255, 255, 255));
        Component prefixEnd = Component.text("] ").color(TextColor.color(100, 100, 100));
        return prefixStart.append(clientName).append(prefixEnd).append(component);
    }

    @Override
    public Collection<Client> getClients() {
        return AbsorbManagers.getNetManager().getClients().parallelStream().filter(client -> client.getPlayingState()==PlayingState.PLAYING).collect(Collectors.toSet());
    }

    @Override
    public @NotNull MessagePosition getDefaultPosition() {
        return MessagePosition.CHAT;
    }

    @Override
    public @NotNull Component format(@NotNull Client client, @NotNull String component) {
        return this.format(client, Component.text(component).color(TextColor.color(240,240,255)));
    }
}
