package org.absorb.net.packet.play.incoming.client.screen.inventory.hotbar.hand.use;

import org.absorb.entity.living.human.Hand;
import org.absorb.net.Client;
import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class IncomingUseItemPacketBuilder implements IncomingPacketBuilder<IncomingUseItemPacket> {

    private int handId;
    private int sequence;

    public int getHandId() {
        return this.handId;
    }

    public IncomingUseItemPacketBuilder setHandId(int handId) {
        this.handId = handId;
        return this;
    }

    public Hand getHand() {
        return Hand.fromNetworkId(this.handId);
    }

    public int getSequence() {
        return this.sequence;
    }

    public IncomingUseItemPacketBuilder setSequence(int sequence) {
        this.sequence = sequence;
        return this;
    }

    @Override
    public @NotNull PacketBuilder<IncomingUseItemPacket> from(@NotNull Client connection,
                                                              @NotNull ByteBuffer packetBytes) {
        NetEntryData<Integer> handBuffer = NetSerializers.VAR_INTEGER.read(0, packetBytes);
        NetEntryData<Integer> sequenceBuffer = NetSerializers.VAR_INTEGER.read(handBuffer.endingPosition(),
                                                                               packetBytes);
        this.handId = handBuffer.value();
        this.sequence = sequenceBuffer.value();
        return this;
    }

    @Override
    public @NotNull IncomingPacketBuilder<IncomingUseItemPacket> reset() {
        this.sequence = 0;
        this.handId = 0;
        return this;
    }

    @Override
    public @NotNull IncomingPacketBuilder<IncomingUseItemPacket> copy() {
        return new IncomingUseItemPacketBuilder().setHandId(this.handId).setSequence(this.sequence);
    }

    @Override
    public @NotNull IncomingUseItemPacket build() {
        return new IncomingUseItemPacket(this);
    }

    @Override
    public int getId() {
        return IncomingUseItemPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
