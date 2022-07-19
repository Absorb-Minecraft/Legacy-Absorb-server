package org.absorb.net.packet.play.incoming.client.screen.book.edit;

import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.play.entity.player.screen.book.edit.EditBookProcessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class IncomingEditBookPacket implements IncomingPacket {

    private final int slotIndex;
    private final List<String> entries = new ArrayList<>();
    private final @Nullable String title;
    public static final int ID = 0x0d;

    public IncomingEditBookPacket(IncomingEditBookPacketBuilder builder) {
        this.entries.addAll(builder.getEntries());
        this.title = builder.getTitle();
        this.slotIndex = builder.getSlotIndex();
    }

    public int getSlotIndex() {
        return this.slotIndex;
    }

    public List<String> getEntries() {
        return Collections.unmodifiableList(this.entries);
    }

    public Optional<String> getTitle() {
        return Optional.ofNullable(this.title);
    }

    @Override
    public @NotNull <P extends IncomingPacket> NetProcess<P> getProcess() {
        return (NetProcess<P>) new EditBookProcessor();
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
        return new IncomingEditBookPacketBuilder()
                .setTitle(this.title)
                .setSlotIndex(this.slotIndex)
                .addEntries(this.entries);
    }
}
