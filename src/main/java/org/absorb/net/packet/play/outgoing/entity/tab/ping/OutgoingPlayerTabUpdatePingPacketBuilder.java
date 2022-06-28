package org.absorb.net.packet.play.outgoing.entity.tab.ping;

import org.absorb.entity.living.human.Gamemode;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.packet.play.outgoing.entity.tab.OutgoingPlayerTabUpdatePacket;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OutgoingPlayerTabUpdatePingPacketBuilder implements OutgoingPacketBuilder<OutgoingPlayerTabUpdatePingPacket> {

    private final Map<UUID, Gamemode> gamemodeToUpdate = new HashMap<>();

    public Map<UUID, Gamemode> getUpdates() {
        return Collections.unmodifiableMap(this.gamemodeToUpdate);
    }

    public OutgoingPlayerTabUpdatePingPacketBuilder addUpdates(Map<UUID, ? extends Gamemode> map) {
        this.gamemodeToUpdate.putAll(map);
        return this;
    }

    @Override
    public @NotNull OutgoingPlayerTabUpdatePingPacket build() {
        return new OutgoingPlayerTabUpdatePingPacket(this);
    }

    @Override
    public @NotNull PacketBuilder<OutgoingPlayerTabUpdatePingPacket> reset() {
        this.gamemodeToUpdate.clear();
        return this;
    }

    @Override
    public @NotNull PacketBuilder<OutgoingPlayerTabUpdatePingPacket> copy() {
        return new OutgoingPlayerTabUpdatePingPacketBuilder().addUpdates(this.gamemodeToUpdate);
    }

    @Override
    public int getId() {
        return OutgoingPlayerTabUpdatePacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
