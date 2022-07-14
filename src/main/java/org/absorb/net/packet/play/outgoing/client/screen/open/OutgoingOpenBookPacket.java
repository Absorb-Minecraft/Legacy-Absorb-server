package org.absorb.net.packet.play.outgoing.client.screen.open;

import org.absorb.entity.living.human.Hand;
import org.absorb.net.Client;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class OutgoingOpenBookPacket implements OutgoingPacket {

    private final Hand hand;
    public static final int ID = 0x2A;

    public OutgoingOpenBookPacket(OutgoingOpenBookPacketBuilder builder) {
        this.hand = builder.getHand();
    }

    public Hand getHand() {
        return this.hand;
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }

    @Override
    public @NotNull OutgoingPacketBuilder<? extends Packet> toBuilder() {
        return new OutgoingOpenBookPacketBuilder().setHand(this.hand);
    }

    @Override
    public ByteBuffer toBytes(Client stream) {
        return NetUtils.createPacket(ID, NetSerializers.VAR_INTEGER.write(this.hand.getNetworkId()));
    }
}
