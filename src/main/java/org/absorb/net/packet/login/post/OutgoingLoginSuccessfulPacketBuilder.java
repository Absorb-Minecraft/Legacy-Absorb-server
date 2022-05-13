package org.absorb.net.packet.login.post;

import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;

import java.util.UUID;

public class OutgoingLoginSuccessfulPacketBuilder implements OutgoingPacketBuilder<OutgoingLoginSuccessfulPacket> {

    private UUID uuid;
    private String name;

    public UUID getUuid() {
        return this.uuid;
    }

    public OutgoingLoginSuccessfulPacketBuilder setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public OutgoingLoginSuccessfulPacketBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public OutgoingLoginSuccessfulPacket build() {
        return new OutgoingLoginSuccessfulPacket(this);
    }

    @Override
    public PacketBuilder<OutgoingLoginSuccessfulPacket> reset() {
        return null;
    }

    @Override
    public PacketBuilder<OutgoingLoginSuccessfulPacket> copy() {
        return null;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public PacketState getState() {
        return null;
    }
}
