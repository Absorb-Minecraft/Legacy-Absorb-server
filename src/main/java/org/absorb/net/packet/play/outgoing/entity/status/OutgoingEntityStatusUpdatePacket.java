package org.absorb.net.packet.play.outgoing.entity.status;

import org.absorb.entity.EntityEffect;
import org.absorb.net.Client;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class OutgoingEntityStatusUpdatePacket implements OutgoingPacket {

    private final EntityEffect<?> effect;
    private final int entityId;
    public static final int ID = 0x1B; //TODO -> UPDATE THIS

    public OutgoingEntityStatusUpdatePacket(@NotNull OutgoingEntityStatusUpdatePacketBuilder builder) {
        this.effect = builder.getEffect();
        this.entityId = builder.getEntityId();
    }

    public EntityEffect<?> getEffect() {
        return this.effect;
    }

    public int getEntityId() {
        return this.entityId;
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
        return new OutgoingEntityStatusUpdatePacketBuilder().setEntityId(this.entityId).setEffect(this.effect);
    }

    @Override
    public ByteBuffer toBytes(@NotNull Client stream) {
        ByteBuffer entityId = NetSerializers.INTEGER.write(this.entityId);
        ByteBuffer effect = NetSerializers.BYTE.write(this.effect.getStatusCode());
        return NetUtils.createPacket(ID, entityId, effect);
    }
}
