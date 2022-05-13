package org.absorb.net.packet.play.entity.player.tab;

import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

public interface OutgoingPlayerTabUpdatePacket extends OutgoingPacket {

    int ID = 0x36;

    @Override
    default int getId() {
        return ID;
    }

    @Override
    default @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
