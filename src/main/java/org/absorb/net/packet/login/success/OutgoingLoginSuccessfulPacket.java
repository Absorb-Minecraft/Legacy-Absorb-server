package org.absorb.net.packet.login.success;

import org.absorb.entity.living.human.tab.PlayerTabProperty;
import org.absorb.net.Client;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;
import java.util.stream.Collectors;

public class OutgoingLoginSuccessfulPacket implements OutgoingPacket {

    public static final int ID = 0x02;

    private final UUID uuid;
    private final String username;
    private final Collection<PlayerTabProperty> properties = new HashSet<>();

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
        this.properties.addAll(builder.getProperties());
    }

    @Override
    public ByteBuffer toBytes(Client stream) {
        ByteBuffer uuidBuffer = NetSerializers.UUID.write(this.uuid);
        ByteBuffer nameBuffer = NetSerializers.STRING.write(this.username);
        ByteBuffer propertiesSizeBuffer = NetSerializers.VAR_INTEGER.write(this.properties.size());
        ByteBuffer propertiesBuffer = NetUtils.collect(this.properties.parallelStream().map(ptp -> {
            ByteBuffer name = NetSerializers.STRING.write(ptp.getName());
            ByteBuffer value = NetSerializers.STRING.write(ptp.getValue());
            ByteBuffer isSign = NetSerializers.BOOLEAN.write(ptp.getSignature().isPresent());
            if (ptp.getSignature().isPresent()) {
                return NetUtils.collect(name, value, isSign);
            }
            return NetUtils.collect(name, value, isSign, NetSerializers.STRING.write(ptp.getSignature().get()));
        }).collect(Collectors.toList()));
        return NetUtils.createPacket(ID, uuidBuffer, nameBuffer, propertiesSizeBuffer, propertiesBuffer);
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
