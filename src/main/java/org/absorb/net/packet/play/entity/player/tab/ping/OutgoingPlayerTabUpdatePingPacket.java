package org.absorb.net.packet.play.entity.player.tab.ping;

import org.absorb.entity.living.human.Gamemode;
import org.absorb.net.Client;
import org.absorb.net.data.SerializerUtils;
import org.absorb.net.data.Serializers;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.play.entity.player.tab.OutgoingPlayerTabUpdatePacket;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OutgoingPlayerTabUpdatePingPacket implements OutgoingPlayerTabUpdatePacket {

    private final Map<UUID, Gamemode> toUpdate = new HashMap<>();

    public OutgoingPlayerTabUpdatePingPacket(@NotNull OutgoingPlayerTabUpdatePingPacketBuilder builder) {
        this.toUpdate.putAll(builder.getUpdates());
    }

    @Override
    public @NotNull OutgoingPacketBuilder<? extends Packet> toBuilder() {
        return new OutgoingPlayerTabUpdatePingPacketBuilder().addUpdates(this.toUpdate);
    }

    @Override
    public ByteBuffer toBytes(@NotNull Client stream) {
        ByteArrayOutputStream baOs = new ByteArrayOutputStream();
        try {
            baOs.write(Serializers.VAR_INTEGER.write(2).array());
            baOs.write(Serializers.VAR_INTEGER.write(this.toUpdate.size()).array());
            for (Map.Entry<UUID, Gamemode> entry : this.toUpdate.entrySet()) {
                baOs.write(Serializers.UUID.write(entry.getKey()).array());
                baOs.write(Serializers.VAR_INTEGER.write(entry.getValue().getNetworkId()).array());
            }
            baOs.flush();
            return SerializerUtils.createPacket(ID, ByteBuffer.wrap(baOs.toByteArray()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
