package org.absorb.net.packet.play.incoming.client.inventory.hotbar.selected;

import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.play.entity.player.inventory.hotbar.position.HotbarPositionChangeProcessor;
import org.jetbrains.annotations.NotNull;

public class IncomingHotbarChangePacket implements IncomingPacket {

    private final short newPosition;
    public static final int ID = 0x27;

    public IncomingHotbarChangePacket(IncomingHotbarChangePacketBuilder builder) {
        this.newPosition = builder.getNewPosition();
    }

    public short getNewPosition() {
        return this.newPosition;
    }

    @Override
    public @NotNull <P extends IncomingPacket> NetProcess<P> getProcess() {
        return (NetProcess<P>) new HotbarPositionChangeProcessor();
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
        return new IncomingHotbarChangePacketBuilder().setNewPosition(this.newPosition);
    }
}
