package org.absorb.event.events.client.connection.ping;

import net.kyori.adventure.text.Component;
import org.absorb.AbsorbManagers;
import org.absorb.event.cause.EventCause;
import org.absorb.net.Client;
import org.absorb.utils.Builder;
import org.absorb.version.MCVersion;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;

public class ClientPingEventBuilder implements Builder<ClientPingEvent> {

    private Client client;
    private int protocolVersion;
    private String name;
    private Component description;
    private int currentPlayers;
    private int maxPlayers;
    private EventCause caused;
    private EventCause willCause;

    public ClientPingEventBuilder() {
        this.reset();
    }

    public EventCause getCaused() {
        if (this.caused == null) {
            return new EventCause(Collections.emptyList());
        }
        return this.caused;
    }

    public ClientPingEventBuilder setCaused(EventCause caused) {
        this.caused = caused;
        return this;
    }

    public EventCause getWillCause() {
        if (this.willCause == null) {
            return new EventCause(Collections.emptyList());
        }
        return this.willCause;
    }

    public ClientPingEventBuilder setWillCause(EventCause willCause) {
        this.willCause = willCause;
        return this;
    }

    public Client getClient() {
        return this.client;
    }

    public ClientPingEventBuilder setClient(Client client) {
        this.client = client;
        return this;
    }

    public int getProtocolVersion() {
        return this.protocolVersion;
    }

    public ClientPingEventBuilder setProtocolVersion(int protocolVersion) {
        this.protocolVersion = protocolVersion;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public ClientPingEventBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Component getDescription() {
        return this.description;
    }

    public ClientPingEventBuilder setDescription(Component description) {
        this.description = description;
        return this;
    }

    public int getCurrentPlayers() {
        return this.currentPlayers;
    }

    public ClientPingEventBuilder setCurrentPlayers(int currentPlayers) {
        this.currentPlayers = currentPlayers;
        return this;
    }

    public int getMaxPlayers() {
        return this.maxPlayers;
    }

    public ClientPingEventBuilder setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        return this;
    }

    @Override
    public @NotNull ClientPingEvent build() {
        return new ClientPingEvent(this);
    }

    @Override
    public @NotNull Builder<ClientPingEvent> reset() {
        this.willCause = null;
        this.caused = null;
        this.client = null;
        this.currentPlayers = AbsorbManagers.getNetManager().getClients().size() - 1;
        this.maxPlayers = this.currentPlayers + 1;
        this.description = Component.empty();
        this.name = "Absorb " + MCVersion.CURRENT.getName();
        this.protocolVersion = MCVersion.CURRENT.protocolVersion();
        return this;
    }

    @Override
    public @NotNull Builder<ClientPingEvent> copy() {
        return new ClientPingEventBuilder()
                .setClient(this.client)
                .setName(this.name)
                .setDescription(this.description)
                .setMaxPlayers(this.maxPlayers)
                .setCurrentPlayers(this.currentPlayers)
                .setProtocolVersion(this.protocolVersion)
                .setWillCause(this.willCause)
                .setCaused(this.caused);
    }

    @Override
    public @NotNull Builder<ClientPingEvent> from(ClientPingEvent value) {
        this.caused = value.hasCaused();
        this.client = value.getClient();
        this.name = value.getNamedVersion();
        this.description = value.getDescription();
        this.currentPlayers = value.getCurrentPlayers();
        this.maxPlayers = value.getMaxPlayers();
        this.willCause = value.willCause();
        this.protocolVersion = value.getProtocolVersion();
        return this;
    }
}
