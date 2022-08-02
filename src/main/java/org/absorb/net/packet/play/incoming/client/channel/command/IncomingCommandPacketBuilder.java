package org.absorb.net.packet.play.incoming.client.channel.command;

import org.absorb.net.Client;
import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;
import java.util.*;

public class IncomingCommandPacketBuilder implements IncomingPacketBuilder<IncomingCommandPacket> {

    private final @NotNull List<Map.Entry<String, byte[]>> arguments = new LinkedList<>();
    private String command;
    private long timestamp;
    private long salt;
    private boolean signedPreview;

    public IncomingCommandPacketBuilder setArguments(Map<String, byte[]> map) {
        return this.setArguments(map.entrySet());
    }


    public IncomingCommandPacketBuilder setArguments(Collection<? extends Map.Entry<String, byte[]>> list) {
        this.arguments.clear();
        this.arguments.addAll(list);
        return this;
    }

    public IncomingCommandPacketBuilder addArgument(@NotNull String name, byte... sign) {
        this.removeArgument(name);
        this.arguments.add(new AbstractMap.SimpleImmutableEntry<>(name, sign));
        return this;
    }

    public IncomingCommandPacketBuilder removeArgument(@NotNull String name) {
        Collection<Map.Entry<String, byte[]>> collection = this.arguments
                .parallelStream()
                .filter(entry -> entry.getKey().equalsIgnoreCase(name))
                .toList();
        this.arguments.removeAll(collection);
        return this;
    }

    public String getCommand() {
        return this.command;
    }

    public IncomingCommandPacketBuilder setCommand(String command) {
        this.command = command;
        return this;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public IncomingCommandPacketBuilder setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public long getSalt() {
        return this.salt;
    }

    public IncomingCommandPacketBuilder setSalt(long salt) {
        this.salt = salt;
        return this;
    }

    public boolean isSignedPreview() {
        return this.signedPreview;
    }

    public IncomingCommandPacketBuilder setSignedPreview(boolean signedPreview) {
        this.signedPreview = signedPreview;
        return this;
    }

    @Override
    public @NotNull PacketBuilder<IncomingCommandPacket> from(@NotNull Client client, @NotNull ByteBuffer packetBytes) {
        NetEntryData<String> commandEntry = NetSerializers.STRING.read(0, packetBytes);
        NetEntryData<Long> timestampEntry = NetSerializers.LONG.read(commandEntry.endingPosition(), packetBytes);
        NetEntryData<Long> saltEntry = NetSerializers.LONG.read(timestampEntry.endingPosition(), packetBytes);
        NetEntryData<Integer> argumentSize = NetSerializers.VAR_INTEGER.read(saltEntry.endingPosition(), packetBytes);
        int previous = argumentSize.endingPosition();
        Collection<Map.Entry<String, byte[]>> list = new LinkedList<>();
        for (int i = 0; i < argumentSize.value(); i++) {
            NetEntryData<String> name = NetSerializers.STRING.read(previous, packetBytes);
            NetEntryData<Integer> signLength = NetSerializers.VAR_INTEGER.read(name.endingPosition(), packetBytes);
            NetEntryData<byte[]> sign = NetSerializers
                    .byteArray(signLength.value())
                    .read(signLength.endingPosition(), packetBytes);
            list.add(new AbstractMap.SimpleImmutableEntry<>(name.value(), sign.value()));
            previous = sign.endingPosition();
        }
        NetEntryData<Boolean> isPreview = NetSerializers.BOOLEAN.read(previous, packetBytes);

        this.command = commandEntry.value();
        this.salt = saltEntry.value();
        this.timestamp = timestampEntry.value();
        this.arguments.addAll(list);
        this.signedPreview = isPreview.value();

        return this;
    }

    @Override
    public @NotNull IncomingPacketBuilder<IncomingCommandPacket> reset() {
        this.arguments.clear();
        this.command = null;
        this.salt = 0;
        this.timestamp = 0;
        this.signedPreview = false;
        return this;
    }

    @Override
    public @NotNull IncomingPacketBuilder<IncomingCommandPacket> copy() {
        return new IncomingCommandPacketBuilder()
                .setCommand(this.command)
                .setSalt(this.salt)
                .setTimestamp(this.timestamp)
                .setSignedPreview(this.signedPreview)
                .setArguments(this.arguments);
    }

    @Override
    public @NotNull IncomingCommandPacket build() {
        return new IncomingCommandPacket(this);
    }

    @Override
    public @NotNull Builder<IncomingCommandPacket> from(IncomingCommandPacket value) {
        this.signedPreview = value.isSignedPreview();
        this.arguments.addAll(value.getArguments());
        this.command = value.getCommand();
        this.salt = value.getSalt();
        this.timestamp = value.getTimestamp();
        return this;
    }

    @Override
    public int getId() {
        return IncomingCommandPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
