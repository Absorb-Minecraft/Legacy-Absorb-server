package org.absorb.net.packet.play.outgoing.client.screen.open;

import org.absorb.entity.living.human.Hand;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

public class OutgoingOpenBookPacketBuilder implements OutgoingPacketBuilder<OutgoingOpenBookPacket> {

    private Hand hand;

    public Hand getHand() {
        return this.hand;
    }

    public OutgoingOpenBookPacketBuilder setHand(Hand hand) {
        this.hand = hand;
        return this;
    }

    @Override
    public @NotNull OutgoingOpenBookPacket build() {
        return new OutgoingOpenBookPacket(this);
    }

    @Override
    public PacketBuilder<OutgoingOpenBookPacket> reset() {
        this.hand = null;
        return this;
    }

    @Override
    public PacketBuilder<OutgoingOpenBookPacket> copy() {
        return new OutgoingOpenBookPacketBuilder().setHand(this.hand);
    }

    @Override
    public int getId() {
        return OutgoingOpenBookPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
