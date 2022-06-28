package org.absorb.net.packet.login.success;

import org.absorb.entity.living.human.tab.PlayerTabProperty;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

public class OutgoingLoginSuccessfulPacketBuilder implements OutgoingPacketBuilder<OutgoingLoginSuccessfulPacket> {

    private UUID uuid;
    private String name;
    private Collection<PlayerTabProperty> properties = new HashSet<>();

    public OutgoingLoginSuccessfulPacketBuilder addProperties(Collection<PlayerTabProperty> properties) {
        this.properties.addAll(properties);
        return this;
    }

    public Collection<PlayerTabProperty> getProperties() {
        return this.properties;
    }

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
        this.uuid = null;
        this.name = null;
        this.properties.clear();
        return this;
    }

    @Override
    public PacketBuilder<OutgoingLoginSuccessfulPacket> copy() {
        return new OutgoingLoginSuccessfulPacketBuilder().setName(this.name).setUuid(this.uuid).addProperties(this.properties);
    }

    @Override
    public int getId() {
        return OutgoingLoginSuccessfulPacket.ID;
    }

    @Override
    public PacketState getState() {
        return PacketState.LOGIN;
    }
}
