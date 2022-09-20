package org.absorb.net.packet.play.outgoing.client.channel.chat.system;

import net.kyori.adventure.text.Component;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

public class OutgoingSystemChatMessagePacketBuilder implements OutgoingPacketBuilder<OutgoingSystemChatMessagePacket> {

    private Component message;
    private boolean overlay;

    public Component getMessage() {
        return this.message;
    }

    public OutgoingSystemChatMessagePacketBuilder setMessage(Component message) {
        this.message = message;
        return this;
    }

    public boolean hasOverlay() {
        return this.overlay;
    }

    public OutgoingSystemChatMessagePacketBuilder setOverlay(boolean overlay) {
        this.overlay = overlay;
        return this;
    }

    @Override
    public @NotNull OutgoingSystemChatMessagePacket build() {
        return new OutgoingSystemChatMessagePacket(this);
    }

    @Override
    public @NotNull Builder<OutgoingSystemChatMessagePacket> from(OutgoingSystemChatMessagePacket value) {
        this.message = value.getMessage();
        this.overlay = value.hasOverlay();
        return this;
    }

    @Override
    public PacketBuilder<OutgoingSystemChatMessagePacket> reset() {
        this.message = null;
        this.overlay = false;
        return this;
    }

    @Override
    public PacketBuilder<OutgoingSystemChatMessagePacket> copy() {
        return new OutgoingSystemChatMessagePacketBuilder().setMessage(this.message).setOverlay(this.overlay);
    }

    @Override
    public int getId() {
        return OutgoingSystemChatMessagePacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
