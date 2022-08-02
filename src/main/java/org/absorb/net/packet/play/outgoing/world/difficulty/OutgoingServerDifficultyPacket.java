package org.absorb.net.packet.play.outgoing.world.difficulty;

import org.absorb.net.Client;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.absorb.world.Difficulty;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class OutgoingServerDifficultyPacket implements OutgoingPacket {

    private final @NotNull Difficulty difficulty;
    private final boolean locked;

    public static final int ID = 0x0B;

    public OutgoingServerDifficultyPacket(@NotNull OutgoingServerDifficultyPacketBuilder builder) {
        this.difficulty = builder.getDifficulty();
        this.locked = builder.isLocked();
    }

    public boolean isLocked() {
        return this.locked;
    }

    public @NotNull Difficulty getDifficulty() {
        return this.difficulty;
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.STATUS;
    }

    @Override
    public @NotNull OutgoingPacketBuilder<? extends Packet> toBuilder() {
        return new OutgoingServerDifficultyPacketBuilder().setDifficulty(this.difficulty);
    }

    @Override
    public ByteBuffer toBytes(@NotNull Client stream) {
        ByteBuffer diff = NetSerializers.BYTE.write(this.difficulty.getNetworkId());
        ByteBuffer locked = NetSerializers.BOOLEAN.write(this.locked);

        return NetUtils.createPacket(ID, diff, locked);
    }
}
