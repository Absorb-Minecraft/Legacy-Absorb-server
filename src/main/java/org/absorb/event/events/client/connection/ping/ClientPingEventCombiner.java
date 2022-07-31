package org.absorb.event.events.client.connection.ping;

import net.kyori.adventure.text.Component;
import org.absorb.event.cause.EventCause;
import org.absorb.event.combine.EventCombine;
import org.absorb.net.Client;
import org.absorb.threaded.ThreadedDataPoint;
import org.jetbrains.annotations.NotNull;

public class ClientPingEventCombiner implements EventCombine<ClientPingEvent> {

    private final Client client;
    private final @NotNull EventCause willCause;
    private final @NotNull EventCause hasCaused;
    private @NotNull ThreadedDataPoint<Integer, Integer> protocolVersion;
    private @NotNull ThreadedDataPoint<String, String> nameVersion;
    private @NotNull ThreadedDataPoint<Component, Component> descriptionText;
    private @NotNull ThreadedDataPoint<Integer, Integer> currentPlayers;
    private @NotNull ThreadedDataPoint<Integer, Integer> maxPlayers;

    public ClientPingEventCombiner(@NotNull ClientPingEvent event) {
        this.client = event.getClient();
        this.willCause = event.willCause();
        this.hasCaused = event.hasCaused();
        this.currentPlayers = event.currentPlayers;
        this.maxPlayers = event.maxPlayers;
        this.descriptionText = event.descriptionText;
        this.nameVersion = event.nameVersion;
        this.protocolVersion = event.protocolVersion;
    }


    @Override
    public synchronized void apply(ClientPingEvent event) {
        if (!this.protocolVersion.isNewer(event.protocolVersion)) {
            this.protocolVersion = event.protocolVersion;
        }
        if (!this.nameVersion.isNewer(event.nameVersion)) {
            this.nameVersion = event.nameVersion;
        }
        if (!this.descriptionText.isNewer(event.descriptionText)) {
            this.descriptionText = event.descriptionText;
        }
        if (!this.maxPlayers.isNewer(event.maxPlayers)) {
            this.maxPlayers = event.maxPlayers;
        }
        if (!this.currentPlayers.isNewer(event.currentPlayers)) {
            this.currentPlayers = event.currentPlayers;
        }
    }

    @Override
    public ClientPingEvent build() {
        return new ClientPingEventBuilder()
                .setClient(this.client)
                .setCaused(this.hasCaused)
                .setWillCause(this.willCause)
                .setCurrentPlayers(this.currentPlayers.getValue())
                .setProtocolVersion(this.protocolVersion.getValue())
                .setMaxPlayers(this.maxPlayers.getValue())
                .setDescription(this.descriptionText.getValue())
                .setName(this.nameVersion.getValue())
                .build();
    }
}
