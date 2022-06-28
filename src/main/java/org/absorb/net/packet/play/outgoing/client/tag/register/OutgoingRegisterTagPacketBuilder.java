package org.absorb.net.packet.play.outgoing.client.tag.register;

import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.NetworkIdentifiable;
import org.absorb.utils.tag.Tag;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;

public class OutgoingRegisterTagPacketBuilder implements OutgoingPacketBuilder<OutgoingRegisterTagPacket> {

    private final Collection<Tag<? extends NetworkIdentifiable>> tags = new HashSet<>();

    public @NotNull Collection<Tag<? extends NetworkIdentifiable>> getTags() {
        return this.tags;
    }

    public OutgoingRegisterTagPacketBuilder addAll(Collection<? extends Tag<? extends NetworkIdentifiable>> collection) {
        this.tags.addAll(collection);
        return this;
    }

    @Override
    public @NotNull OutgoingRegisterTagPacket build() {
        return new OutgoingRegisterTagPacket(this);
    }

    @Override
    public @NotNull OutgoingRegisterTagPacketBuilder reset() {
        this.tags.clear();
        return this;
    }

    @Override
    public @NotNull PacketBuilder<OutgoingRegisterTagPacket> copy() {
        return new OutgoingRegisterTagPacketBuilder().addAll(this.tags);
    }

    @Override
    public int getId() {
        return OutgoingRegisterTagPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
