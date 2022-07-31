package org.absorb.net.packet.play.outgoing.client.disconnect;

import net.kyori.adventure.text.Component;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

public class OutgoingCloseConnectionPacketBuilder implements OutgoingPacketBuilder<OutgoingCloseConnectionPacket> {

    private Component message;
    private boolean usePlay;

    public OutgoingCloseConnectionPacketBuilder() {
        this.reset();
    }

    public boolean isUsingPlay() {
        return this.usePlay;
    }

    public OutgoingCloseConnectionPacketBuilder setUsingPlay(boolean usePlay) {
        this.usePlay = usePlay;
        return this;
    }

    public Component getMessage() {
        return this.message;
    }

    public OutgoingCloseConnectionPacketBuilder setMessage(Component message) {
        this.message = message;
        return this;
    }

    @Override
    public @NotNull OutgoingCloseConnectionPacket build() {
        return new OutgoingCloseConnectionPacket(this);
    }

    @Override
    public @NotNull Builder<OutgoingCloseConnectionPacket> from(OutgoingCloseConnectionPacket value) {
        this.message = value.getMessage();
        this.usePlay = value.isUsingPlayId();
        return this;
    }

    @Override
    public @NotNull PacketBuilder<OutgoingCloseConnectionPacket> reset() {
        this.message = null;
        return this;
    }

    @Override
    public @NotNull PacketBuilder<OutgoingCloseConnectionPacket> copy() {
        return new OutgoingCloseConnectionPacketBuilder().setMessage(this.message);
    }

    @Override
    public int getId() {
        if (usePlay) {
            return OutgoingCloseConnectionPacket.PLAY_ID;
        }
        return OutgoingCloseConnectionPacket.LOGIN_ID;
    }

    @Override
    public @NotNull PacketState getState() {
        if (this.usePlay) {
            return PacketState.PLAY;
        }
        return PacketState.LOGIN;
    }
}
