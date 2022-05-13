package org.absorb.net.packet.play.tag.register;

import org.absorb.net.Client;
import org.absorb.net.data.Serializers;
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

    public static final int ID = 0x67;

    private final Collection<Tag<? extends NetworkIdentifiable>> tags = new HashSet<>();

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
    public void send(@NotNull Client stream) {
        ByteArrayOutputStream baOs = new ByteArrayOutputStream();
        ByteBuffer tagsLength = Serializers.VAR_INTEGER.write(this.tags.size());
        try {
            baOs.write(tagsLength.array());
            for (Tag<? extends NetworkIdentifiable> tag : this.tags) {
                baOs.write(Serializers.RESOURCE_KEY.write(tag.getResourceKey()).array());
                baOs.write(Serializers.VAR_INTEGER.write(tag.getRegistered().size()).array());
                for (NetworkIdentifiable netId : tag.getRegistered()) {
                    baOs.write(Serializers.VAR_INTEGER.write(netId.getNetworkId()).array());
                }
            }
            stream.write(ByteBuffer.wrap(baOs.toByteArray()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
