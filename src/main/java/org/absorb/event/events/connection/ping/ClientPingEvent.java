package org.absorb.event.events.connection.ping;

import net.kyori.adventure.text.Component;
import org.absorb.event.Event;
import org.absorb.event.cause.EventCause;
import org.absorb.event.combine.AwaitingEvent;
import org.absorb.event.combine.EventCombine;
import org.absorb.event.events.ClientEvent;
import org.absorb.net.Client;
import org.absorb.threaded.SimpleDataPoint;
import org.absorb.threaded.ThreadedDataPoint;
import org.absorb.version.MCVersion;
import org.jetbrains.annotations.NotNull;

public class ClientPingEvent implements ClientEvent, AwaitingEvent {

    private final Client client;

    @NotNull ThreadedDataPoint<Integer, Integer> protocolVersion;
    @NotNull ThreadedDataPoint<String, String> nameVersion;
    @NotNull ThreadedDataPoint<Component, Component> descriptionText;
    @NotNull ThreadedDataPoint<Integer, Integer> currentPlayers;
    @NotNull ThreadedDataPoint<Integer, Integer> maxPlayers;

    private final @NotNull EventCause willCause;
    private final @NotNull EventCause hasCaused;

    public ClientPingEvent(@NotNull ClientPingEventBuilder builder) {
        this.client = builder.getClient();
        this.willCause = builder.getWillCause();
        this.hasCaused = builder.getCaused();
        this.setProtocolVersion(builder.getProtocolVersion());
        this.setDescription(builder.getDescription());
        this.setCurrentPlayers(builder.getCurrentPlayers());
        this.setMaxPlayers(builder.getMaxPlayers());
        this.setNamedVersion(builder.getName());
    }

    public int getProtocolVersion() {
        return this.protocolVersion.getValue();
    }

    public @NotNull String getNamedVersion() {
        return this.nameVersion.getValue();
    }

    public @NotNull Component getDescription() {
        return this.descriptionText.getValue();
    }

    public int getCurrentPlayers() {
        return this.currentPlayers.getValue();
    }

    public int getMaxPlayers() {
        return this.maxPlayers.getValue();
    }

    public ClientPingEvent setProtocolVersion(@NotNull MCVersion version) {
        return this.setProtocolVersion(version.protocolVersion());
    }

    public ClientPingEvent setProtocolVersion(int version) {
        this.protocolVersion = new SimpleDataPoint<>(version);
        return this;
    }

    public ClientPingEvent setNamedVersion(@NotNull String name) {
        this.nameVersion = new SimpleDataPoint<>(name);
        return this;
    }

    public ClientPingEvent setDescription(@NotNull Component component) {
        this.descriptionText = new SimpleDataPoint<>(component);
        return this;
    }

    public ClientPingEvent setCurrentPlayers(int players) {
        this.currentPlayers = new SimpleDataPoint<>(players);
        return this;
    }

    public ClientPingEvent setMaxPlayers(int players) {
        this.maxPlayers = new SimpleDataPoint<>(players);
        return this;
    }

    @Override
    public @NotNull EventCause willCause() {
        return this.willCause;
    }

    @Override
    public @NotNull EventCause hasCaused() {
        return this.hasCaused;
    }

    @Override
    public Event copy() {
        return new ClientPingEventBuilder()
                .setClient(this.client)
                .setCaused(this.hasCaused)
                .setWillCause(this.willCause)
                .setCurrentPlayers(this.getCurrentPlayers())
                .setDescription(this.getDescription())
                .setMaxPlayers(this.getMaxPlayers())
                .setProtocolVersion(this.getProtocolVersion())
                .setName(this.getNamedVersion())
                .build();
    }

    @Override
    public Client getClient() {
        return this.client;
    }

    @Override
    public EventCombine<?> getCombiner() {
        return new ClientPingEventCombiner(this);
    }
}
