package org.absorb.net.packet.play.entity.player.teleport.confirm;

import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.play.teleport.confirm.TeleportConfirmProcessor;
import org.jetbrains.annotations.NotNull;

public class IncomingTeleportConfirmPacket implements IncomingPacket {

    public static final int ID = 0x00;

    private final int teleportId;

    public IncomingTeleportConfirmPacket(IncomingTeleportConfirmPacketBuilder builder) {
        this.teleportId = builder.getTeleportId();
    }

    public int getTeleportId() {
        return this.teleportId;
    }

    @Override
    public @NotNull <P extends IncomingPacket> NetProcess<P> getProcess() {
        return (NetProcess<P>) new TeleportConfirmProcessor();
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
        return new IncomingTeleportConfirmPacketBuilder().setTeleportId(this.teleportId);
    }
}
