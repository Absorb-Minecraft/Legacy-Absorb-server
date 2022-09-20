package org.absorb.net.packet.play.outgoing.client.tag.register;

import org.absorb.net.Client;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.NetworkIdentifiable;
import org.absorb.utils.tag.Tag;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashSet;

public class OutgoingRegisterTagPacket implements OutgoingPacket {

    private final Collection<Tag<? extends NetworkIdentifiable>> tags = new HashSet<>();
    public static final int ID = 0x6B;

    public OutgoingRegisterTagPacket(OutgoingRegisterTagPacketBuilder builder) {
        this.tags.addAll(builder.getTags());
    }

    public Collection<Tag<? extends NetworkIdentifiable>> getTags() {
        return this.tags;
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
    public @NotNull OutgoingPacketBuilder<? extends Packet> toBuilder() {
        return new OutgoingRegisterTagPacketBuilder().addAll(this.tags);
    }

    @Override
    public ByteBuffer toBytes(@NotNull Client stream) {
        ByteArrayOutputStream baOs = new ByteArrayOutputStream();
        ByteBuffer tagsLength = NetSerializers.VAR_INTEGER.write(this.tags.size());
        try {
            baOs.write(tagsLength.array());
            for (Tag<? extends NetworkIdentifiable> tag : this.tags) {
                baOs.write(NetSerializers.RESOURCE_KEY.write(tag.getResourceKey()).array());
                baOs.write(NetSerializers.VAR_INTEGER.write(tag.getRegistered().size()).array());
                for (NetworkIdentifiable netId : tag.getRegistered()) {
                    baOs.write(NetSerializers.VAR_INTEGER.write(netId.getNetworkId()).array());
                }
            }
            return NetUtils.createPacket(ID, ByteBuffer.wrap(baOs.toByteArray()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
