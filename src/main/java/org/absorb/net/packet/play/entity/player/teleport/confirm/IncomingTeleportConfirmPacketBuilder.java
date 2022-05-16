package org.absorb.net.packet.play.entity.player.teleport.confirm;

import org.absorb.net.data.Serializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class IncomingTeleportConfirmPacketBuilder implements IncomingPacketBuilder<IncomingTeleportConfirmPacket> {

    private int teleportId;

    public int getTeleportId() {
        return this.teleportId;
    }

    public IncomingTeleportConfirmPacketBuilder setTeleportId(int teleportId) {
        this.teleportId = teleportId;
        return this;
    }

    @Override
    public PacketBuilder<IncomingTeleportConfirmPacket> from(ByteBuffer packetBytes) {
        this.teleportId = Serializers.VAR_INTEGER.read(0, packetBytes).value();
        return this;
    }

    @Override
    public @NotNull IncomingTeleportConfirmPacket build() {
        return new IncomingTeleportConfirmPacket(this);
    }

    @Override
    public IncomingPacketBuilder<IncomingTeleportConfirmPacket> reset() {
        this.teleportId = 0;
        return this;
    }

    @Override
    public IncomingPacketBuilder<IncomingTeleportConfirmPacket> copy() {
        return new IncomingTeleportConfirmPacketBuilder().setTeleportId(this.teleportId);
    }

    @Override
    public int getId() {
        return IncomingTeleportConfirmPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
