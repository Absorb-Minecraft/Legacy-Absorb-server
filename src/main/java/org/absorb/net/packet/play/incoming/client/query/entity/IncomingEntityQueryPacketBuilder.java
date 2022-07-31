package org.absorb.net.packet.play.incoming.client.query.entity;

import org.absorb.net.Client;
import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class IncomingEntityQueryPacketBuilder implements IncomingPacketBuilder<IncomingEntityQueryPacket> {

    private int generatedId;

    private int entityId;

    public int getGeneratedId() {
        return this.generatedId;
    }

    public IncomingEntityQueryPacketBuilder setGeneratedId(int generatedId) {
        this.generatedId = generatedId;
        return this;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public IncomingEntityQueryPacketBuilder setEntityId(int entityId) {
        this.entityId = entityId;
        return this;
    }

    @Override
    public @NotNull PacketBuilder<IncomingEntityQueryPacket> from(@NotNull Client connection,
                                                                  @NotNull ByteBuffer packetBytes) {
        NetEntryData<Integer> generatedId = NetSerializers.VAR_INTEGER.read(0, packetBytes);
        NetEntryData<Integer> entityId = NetSerializers.VAR_INTEGER.read(generatedId.endingPosition(), packetBytes);

        this.entityId = entityId.value();
        this.generatedId = generatedId.value();
        return this;
    }

    @Override
    public @NotNull IncomingPacketBuilder<IncomingEntityQueryPacket> reset() {
        this.generatedId = 0;
        this.entityId = 0;
        return this;
    }

    @Override
    public @NotNull IncomingPacketBuilder<IncomingEntityQueryPacket> copy() {
        return new IncomingEntityQueryPacketBuilder().setEntityId(this.entityId).setGeneratedId(this.generatedId);
    }

    @Override
    public @NotNull IncomingEntityQueryPacket build() {
        return new IncomingEntityQueryPacket(this);
    }

    @Override
    public @NotNull Builder<IncomingEntityQueryPacket> from(IncomingEntityQueryPacket value) {
        this.entityId = value.getEntityId();
        this.generatedId = value.getGeneratedId();
        return this;
    }

    @Override
    public int getId() {
        return IncomingEntityQueryPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
