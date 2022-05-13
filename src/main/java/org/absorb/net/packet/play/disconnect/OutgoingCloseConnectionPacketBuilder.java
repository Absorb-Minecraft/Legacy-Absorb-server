package org.absorb.net.packet.play.disconnect;

import net.kyori.adventure.text.Component;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

public class OutgoingCloseConnectionPacketBuilder implements OutgoingPacketBuilder<CloseConnectionPacket> {

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
    public @NotNull CloseConnectionPacket build() {
        return new CloseConnectionPacket(this);
    }

    @Override
    public @NotNull PacketBuilder<CloseConnectionPacket> reset() {
        this.message = null;
        return this;
    }

    @Override
    public @NotNull PacketBuilder<CloseConnectionPacket> copy() {
        return new OutgoingCloseConnectionPacketBuilder().setMessage(this.message);
    }

    @Override
    public int getId() {
        if (usePlay) {
            return CloseConnectionPacket.PLAY_ID;
        }
        return CloseConnectionPacket.LOGIN_ID;
    }

    @Override
    public @NotNull PacketState getState() {
        if (this.usePlay) {
            return PacketState.PLAY;
        }
        return PacketState.LOGIN;
    }
}
