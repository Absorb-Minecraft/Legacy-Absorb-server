package org.absorb.net.packet.play.outgoing.entity.tab.add;

import org.absorb.entity.living.human.tab.PlayerTab;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.packet.play.outgoing.entity.tab.OutgoingPlayerTabUpdatePacket;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;

public class OutgoingPlayerTabUpdateAddPlayerPacketBuilder
        implements OutgoingPacketBuilder<OutgoingPlayerTabUpdateAddPlayerPacket> {

    private final Collection<PlayerTab> tabs = new HashSet<>();

    public Collection<PlayerTab> getTabs() {
        return this.tabs;
    }

    public OutgoingPlayerTabUpdateAddPlayerPacketBuilder addTabs(Collection<? extends PlayerTab> collection) {
        this.tabs.addAll(collection);
        return this;
    }

    @Override
    public @NotNull OutgoingPlayerTabUpdateAddPlayerPacket build() {
        return new OutgoingPlayerTabUpdateAddPlayerPacket(this);
    }

    @Override
    public @NotNull Builder<OutgoingPlayerTabUpdateAddPlayerPacket> from(OutgoingPlayerTabUpdateAddPlayerPacket value) {
        this.tabs.addAll(value.getTabs());
        return this;
    }

    @Override
    public PacketBuilder<OutgoingPlayerTabUpdateAddPlayerPacket> reset() {
        this.tabs.clear();
        return this;
    }

    @Override
    public PacketBuilder<OutgoingPlayerTabUpdateAddPlayerPacket> copy() {
        return new OutgoingPlayerTabUpdateAddPlayerPacketBuilder().addTabs(this.tabs);
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
