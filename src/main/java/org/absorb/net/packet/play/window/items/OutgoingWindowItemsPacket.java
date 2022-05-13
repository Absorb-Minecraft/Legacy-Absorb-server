package org.absorb.net.packet.play.window.items;

import org.absorb.inventory.slot.AbstractSlot;
import org.absorb.inventory.slot.Slot;
import org.absorb.net.Client;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class OutgoingWindowItemsPacket implements OutgoingPacket {

    public static final int ID = 0x14;

    private final SortedSet<AbstractSlot> slots = new TreeSet<>(Comparator.comparing(AbstractSlot::getNetworkId));


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
        return null;
    }

    @Override
    public void send(@NotNull Client stream) {

    }
}
