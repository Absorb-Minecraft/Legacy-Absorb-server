package org.absorb.net.packet.status.pong;

import org.absorb.net.Client;
import org.absorb.net.data.SerializerUtils;
import org.absorb.net.data.Serializers;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.ByteBuffer;

public class OutgoingPongPacket implements OutgoingPacket {

    public static final int ID = 0x01;

    private final long payload;

    public OutgoingPongPacket(OutgoingPongPacketBuilder builder) {
        this.payload = builder.getPayload();
    }

    @Override
    public void send(Client stream) {
        ByteBuffer bytes = Serializers.LONG.write(this.payload);
        ByteBuffer result = SerializerUtils.createPacket(ID, bytes);
        try {

            stream.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.STATUS;
    }

    @Override
    public @NotNull OutgoingPongPacketBuilder toBuilder() {
        return new OutgoingPongPacketBuilder().setPayload(this.payload);
    }
}
