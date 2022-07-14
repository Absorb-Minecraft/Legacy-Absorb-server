package org.absorb.net.packet.play.outgoing.world.block.change;

import org.absorb.block.state.BlockState;
import org.absorb.net.Client;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3i;

import java.nio.ByteBuffer;

public class OutgoingBlockChangePacket implements OutgoingPacket {

    private final Vector3i blockPosition;
    private final BlockState newBlock;
    public static final int ID = 0x09;

    public OutgoingBlockChangePacket(OutgoingBlockChangePacketBuilder builder) {
        this.blockPosition = builder.getPosition();
        this.newBlock = builder.getBlockState();
    }

    public Vector3i getBlockPosition() {
        return this.blockPosition;
    }

    public BlockState getNewBlockState() {
        return this.newBlock;
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
        return new OutgoingBlockChangePacketBuilder().setPosition(this.blockPosition).setBlockState(this.newBlock);
    }

    @Override
    public ByteBuffer toBytes(Client stream) {
        ByteBuffer positionBuffer = NetSerializers.POSITION.write(this.blockPosition);
        ByteBuffer blockBuffer = NetSerializers.VAR_INTEGER.write(this.newBlock.getNetworkId());

        return NetUtils.createPacket(ID, positionBuffer, blockBuffer);
    }
}
