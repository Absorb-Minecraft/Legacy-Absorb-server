package org.absorb.net.packet.login.post;

import org.absorb.net.Client;
import org.absorb.net.data.SerializerUtils;
import org.absorb.net.data.Serializers;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.UUID;

public class OutgoingLoginSuccessfulPacket implements OutgoingPacket {

    public static final int ID = 0x02;

    private final UUID uuid;
    private final String username;

    public OutgoingLoginSuccessfulPacket(OutgoingLoginSuccessfulPacketBuilder builder) {
        if (builder.getUuid()==null) {
            throw new IllegalStateException("UUID must be specified");
        }
        if (builder.getName()==null) {
            throw new IllegalStateException("Name must be specified");
        }
        if (builder.getName().length() > 16) {
            throw new IllegalStateException("Name must be less or equal to 16 characters");
        }
        this.username = builder.getName();
        this.uuid = builder.getUuid();
    }

    @Override
    public void send(Client stream) {
        ByteBuffer uuidBuffer = Serializers.UUID.write(this.uuid);
        ByteBuffer nameBuffer = Serializers.STRING.write(this.username);
        ByteBuffer ret = SerializerUtils.createPacket(ID, uuidBuffer, nameBuffer);
        try {
            stream.write(ret);
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
        return PacketState.LOGIN;
    }

    @Override
    public OutgoingLoginSuccessfulPacketBuilder toBuilder() {
        throw new RuntimeException("Not implemented");
    }
}
