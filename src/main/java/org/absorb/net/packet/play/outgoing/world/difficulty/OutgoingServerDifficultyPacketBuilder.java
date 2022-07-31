package org.absorb.net.packet.play.outgoing.world.difficulty;

import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.Builder;
import org.absorb.world.Difficulty;
import org.jetbrains.annotations.NotNull;

public class OutgoingServerDifficultyPacketBuilder implements OutgoingPacketBuilder<OutgoingServerDifficultyPacket> {

    private Difficulty difficulty;
    private boolean locked;

    public boolean isLocked() {
        return this.locked;
    }

    public OutgoingServerDifficultyPacketBuilder setLocked(boolean locked) {
        this.locked = locked;
        return this;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public OutgoingServerDifficultyPacketBuilder setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    @Override
    public @NotNull OutgoingServerDifficultyPacket build() {
        return new OutgoingServerDifficultyPacket(this);
    }

    @Override
    public @NotNull Builder<OutgoingServerDifficultyPacket> from(OutgoingServerDifficultyPacket value) {
        this.difficulty = value.getDifficulty();
        this.locked = value.isLocked();
        return this;
    }

    @Override
    public @NotNull PacketBuilder<OutgoingServerDifficultyPacket> reset() {
        this.difficulty = Difficulty.NORMAL;
        return this;
    }

    @Override
    public PacketBuilder<OutgoingServerDifficultyPacket> copy() {
        return new OutgoingServerDifficultyPacketBuilder()
                .setDifficulty(this.getDifficulty())
                .setLocked(this.isLocked());
    }

    @Override
    public int getId() {
        return OutgoingServerDifficultyPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
