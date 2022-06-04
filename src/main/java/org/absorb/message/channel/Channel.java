package org.absorb.message.channel;

import net.kyori.adventure.text.Component;
import org.absorb.message.MessagePosition;
import org.absorb.net.Client;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface Channel {

    @NotNull Component format(@NotNull Client client, @NotNull Component component);

    Collection<Client> getClients();

    @NotNull MessagePosition getDefaultPosition();

    default Collection<Client> getClients(@NotNull Client client) {
        return this.getClients();
    }

    default @NotNull Component format(@NotNull Client client, @NotNull String component) {
        return this.format(client, Component.text(component));
    }
}
