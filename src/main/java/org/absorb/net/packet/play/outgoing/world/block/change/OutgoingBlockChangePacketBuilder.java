package org.absorb.net.packet.play.outgoing.world.block.change;

import org.absorb.block.locatable.LocatableBlock;
import org.absorb.block.state.BlockState;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3i;

public class OutgoingBlockChangePacketBuilder implements OutgoingPacketBuilder<OutgoingBlockChangePacket> {

    private Vector3i position;
    private BlockState state;

    public Vector3i getPosition() {
        return this.position;
    }

    public OutgoingBlockChangePacketBuilder setPosition(Vector3i position) {
        this.position = position;
        return this;
    }

    public BlockState getBlockState() {
        return this.state;
    }

    public OutgoingBlockChangePacketBuilder setBlockState(BlockState state) {
        this.state = state;
        return this;
    }

    public OutgoingBlockChangePacketBuilder setBlock(LocatableBlock block) {
        this.setBlockState(block.getState().getState());
        this.setPosition(block.getLocation().getBlockPosition());
        return this;
    }

    @Override
    public @NotNull OutgoingBlockChangePacket build() {
        return new OutgoingBlockChangePacket(this);
    }

    @Override
    public @NotNull Builder<OutgoingBlockChangePacket> from(OutgoingBlockChangePacket value) {
        this.position = value.getBlockPosition();
        this.state = value.getNewBlockState();
        return this;
    }

    @Override
    public PacketBuilder<OutgoingBlockChangePacket> reset() {
        this.position = null;
        this.state = null;
        return this;
    }

    @Override
    public PacketBuilder<OutgoingBlockChangePacket> copy() {
        return new OutgoingBlockChangePacketBuilder().setBlockState(this.state).setPosition(this.position);
    }

    @Override
    public int getId() {
        return OutgoingBlockChangePacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
