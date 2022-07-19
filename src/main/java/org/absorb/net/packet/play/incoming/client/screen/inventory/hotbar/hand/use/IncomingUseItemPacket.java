package org.absorb.net.packet.play.incoming.client.screen.inventory.hotbar.hand.use;

import org.absorb.entity.living.human.Hand;
import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.play.entity.player.screen.inventory.hotbar.hand.use.UseItemProcessor;
import org.jetbrains.annotations.NotNull;

public class IncomingUseItemPacket implements IncomingPacket {

    private final Hand hand;
    private final int sequence;
    public static final int ID = 0x31;

    public IncomingUseItemPacket(IncomingUseItemPacketBuilder builder) {
        this.hand = builder.getHand();
        this.sequence = builder.getSequence();
    }

    public Hand getHand() {
        return this.hand;
    }

    public int getSequence() {
        return this.sequence;
    }

    @Override
    public @NotNull <P extends IncomingPacket> NetProcess<P> getProcess() {
        return (NetProcess<P>) new UseItemProcessor();
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
    public @NotNull PacketBuilder<? extends Packet> toBuilder() {
        return new IncomingUseItemPacketBuilder().setSequence(this.sequence).setHandId(this.hand.getNetworkId());
    }
}
