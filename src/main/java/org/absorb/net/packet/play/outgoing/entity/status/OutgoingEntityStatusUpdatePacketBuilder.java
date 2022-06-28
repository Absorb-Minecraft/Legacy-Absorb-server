package org.absorb.net.packet.play.outgoing.entity.status;

import org.absorb.entity.EntityEffect;
import org.absorb.entity.WorldEntity;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

public class OutgoingEntityStatusUpdatePacketBuilder implements OutgoingPacketBuilder<OutgoingEntityStatusUpdatePacket> {

    private int entityId;
    private EntityEffect<?> effect;

    public int getEntityId() {
        return this.entityId;
    }

    public OutgoingEntityStatusUpdatePacketBuilder setEntityId(int entityId) {
        this.entityId = entityId;
        return this;
    }

    public OutgoingEntityStatusUpdatePacketBuilder setEntity(@NotNull WorldEntity entity) {
        this.entityId = entity.getInstanceId();
        return this;
    }

    public EntityEffect<?> getEffect() {
        return this.effect;
    }

    public OutgoingEntityStatusUpdatePacketBuilder setEffect(EntityEffect<?> effect) {
        this.effect = effect;
        return this;
    }

    @Override
    public @NotNull OutgoingEntityStatusUpdatePacket build() {
        return new OutgoingEntityStatusUpdatePacket(this);
    }

    @Override
    public @NotNull PacketBuilder<OutgoingEntityStatusUpdatePacket> reset() {
        this.entityId = 0;
        this.effect = null;
        return this;
    }

    @Override
    public @NotNull PacketBuilder<OutgoingEntityStatusUpdatePacket> copy() {
        return new OutgoingEntityStatusUpdatePacketBuilder().setEntityId(this.getEntityId()).setEffect(this.getEffect());
    }

    @Override
    public int getId() {
        return OutgoingEntityStatusUpdatePacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
