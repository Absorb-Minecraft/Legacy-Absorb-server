package org.absorb.net.packet.play.incoming.client.query.entity;

import org.absorb.entity.WorldEntity;
import org.absorb.net.Client;
import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.play.entity.EntityQueryProcessor;
import org.jetbrains.annotations.NotNull;

public class IncomingEntityQueryPacket implements IncomingPacket {

    private final int generatedId;

    private final int entityId;

    public static final int ID = 0x0F;

    public IncomingEntityQueryPacket(IncomingEntityQueryPacketBuilder builder) {
        this.entityId = builder.getEntityId();
        this.generatedId = builder.getGeneratedId();
    }

    public int getEntityId() {
        return this.entityId;
    }

    public WorldEntity getEntity(Client client) {
        return client
                .getEntity()
                .getWorld()
                .getEntities()
                .stream()
                .filter(entity -> entity.getInstanceId() == this.entityId)
                .findAny()
                .orElseThrow(() -> new IllegalStateException("Entity id has expired"));
    }

    public int getGeneratedId() {
        return this.generatedId;
    }

    @Override
    public @NotNull <P extends IncomingPacket> NetProcess<P> getProcess() {
        return (NetProcess<P>) new EntityQueryProcessor();
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
    public @NotNull PacketBuilder<? extends Packet> toBuilder() {
        return new IncomingEntityQueryPacketBuilder().setEntityId(this.entityId).setGeneratedId(this.generatedId);
    }
}
