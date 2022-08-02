package org.absorb.net.packet.play.incoming.client.screen.book.edit;

import org.absorb.net.Client;
import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IncomingEditBookPacketBuilder implements IncomingPacketBuilder<IncomingEditBookPacket> {

    private final List<String> entries = new ArrayList<>();
    private int slotIndex;
    private @Nullable String title;

    public int getSlotIndex() {
        return this.slotIndex;
    }

    public IncomingEditBookPacketBuilder setSlotIndex(int slotIndex) {
        this.slotIndex = slotIndex;
        return this;
    }

    public List<String> getEntries() {
        return this.entries;
    }

    public IncomingEditBookPacketBuilder addEntries(Collection<String> collection) {
        this.entries.addAll(collection);
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public IncomingEditBookPacketBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public @NotNull PacketBuilder<IncomingEditBookPacket> from(@NotNull Client connection,
                                                               @NotNull ByteBuffer packetBytes) {
        NetEntryData<Integer> slotEntry = NetSerializers.VAR_INTEGER.read(0, packetBytes);
        NetEntryData<List<String>> entriesEntry = NetSerializers
                .array(NetSerializers.STRING)
                .read(slotEntry.endingPosition(), packetBytes);
        NetEntryData<Boolean> hasTitleEntry = NetSerializers.BOOLEAN.read(entriesEntry.endingPosition(), packetBytes);

        this.slotIndex = slotEntry.value();
        this.entries.addAll(entriesEntry.value());

        if (hasTitleEntry.value()) {
            this.title = NetSerializers.STRING.read(hasTitleEntry.endingPosition(), packetBytes).value();
        }
        return this;
    }

    @Override
    public @NotNull IncomingPacketBuilder<IncomingEditBookPacket> reset() {
        this.title = null;
        this.slotIndex = 0;
        this.entries.clear();
        return this;
    }

    @Override
    public @NotNull IncomingPacketBuilder<IncomingEditBookPacket> copy() {
        return new IncomingEditBookPacketBuilder()
                .setTitle(this.title)
                .setSlotIndex(this.slotIndex)
                .addEntries(this.entries);
    }

    @Override
    public @NotNull IncomingEditBookPacket build() {
        return new IncomingEditBookPacket(this);
    }

    @Override
    public @NotNull Builder<IncomingEditBookPacket> from(IncomingEditBookPacket value) {
        this.title = value.getTitle().orElse(null);
        this.slotIndex = value.getSlotIndex();
        this.entries.addAll(value.getEntries());
        return this;
    }

    @Override
    public int getId() {
        return IncomingEditBookPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
