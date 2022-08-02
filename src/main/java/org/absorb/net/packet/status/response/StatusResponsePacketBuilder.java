package org.absorb.net.packet.status.response;

import net.kyori.adventure.text.Component;
import org.absorb.AbsorbManagers;
import org.absorb.event.events.client.connection.ping.ClientPingEvent;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.Builder;
import org.absorb.version.MCVersion;
import org.jetbrains.annotations.NotNull;

public class StatusResponsePacketBuilder implements OutgoingPacketBuilder<StatusResponsePacket> {

    private String versionName;
    private int versionProtocol;
    private Component description;
    private int maxPlayers;
    private int currentPlayers;

    public String getVersionName() {
        return this.versionName;
    }

    public StatusResponsePacketBuilder setVersionName(String versionName) {
        this.versionName = versionName;
        return this;
    }

    public int getVersionProtocol() {
        return this.versionProtocol;
    }

    public StatusResponsePacketBuilder setVersionProtocol(int versionProtocol) {
        this.versionProtocol = versionProtocol;
        return this;
    }

    public Component getDescription() {
        return this.description;
    }

    public StatusResponsePacketBuilder setDescription(Component description) {
        this.description = description;
        return this;
    }

    public int getMaxPlayers() {
        return this.maxPlayers;
    }

    public StatusResponsePacketBuilder setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        return this;
    }

    public int getCurrentPlayers() {
        return this.currentPlayers;
    }

    public StatusResponsePacketBuilder setCurrentPlayers(int currentPlayers) {
        this.currentPlayers = currentPlayers;
        return this;
    }

    @Override
    public @NotNull StatusResponsePacket build() {
        return new StatusResponsePacket(this);
    }

    @Override
    public @NotNull Builder<StatusResponsePacket> from(StatusResponsePacket value) {
        this.currentPlayers = value.getCurrentPlayers();
        this.description = value.getDescriptionText();
        this.maxPlayers = value.getMaxPlayers();
        this.versionName = value.getNameVersion();
        this.versionProtocol = value.getProtocolVersion();
        return this;
    }

    @Override
    public @NotNull PacketBuilder<StatusResponsePacket> reset() {
        this.currentPlayers = AbsorbManagers.getNetManager().getClients().size();
        this.maxPlayers = this.currentPlayers + 1;
        this.description = Component.text("A reimplementation of the minecraft server");
        this.versionName = "Absorb " + MCVersion.CURRENT.getName();
        this.versionProtocol = 0;
        return this;
    }

    @Override
    public @NotNull PacketBuilder<StatusResponsePacket> copy() {
        return new StatusResponsePacketBuilder()
                .setCurrentPlayers(this.currentPlayers)
                .setMaxPlayers(this.maxPlayers)
                .setDescription(this.description)
                .setVersionName(this.versionName)
                .setVersionProtocol(this.versionProtocol);
    }

    @Override
    public int getId() {
        return StatusResponsePacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.STATUS;
    }

    public StatusResponsePacketBuilder from(@NotNull ClientPingEvent event) {
        this.currentPlayers = event.getCurrentPlayers();
        this.maxPlayers = event.getMaxPlayers();
        this.versionProtocol = event.getProtocolVersion();
        this.versionName = event.getNamedVersion();
        this.description = event.getDescription();
        return this;
    }
}
