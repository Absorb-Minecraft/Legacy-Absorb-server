package org.absorb.net.packet.play.outgoing.world.time;

import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.Builder;
import org.absorb.world.WorldData;
import org.jetbrains.annotations.NotNull;

public class OutgoingTimeUpdatePacketBuilder implements OutgoingPacketBuilder<OutgoingTimeUpdatePacket> {

    private long worldAge;
    private long timeOfDay;

    public long getWorldAge() {
        return this.worldAge;
    }

    public OutgoingTimeUpdatePacketBuilder setWorldAge(long worldAge) {
        this.worldAge = worldAge;
        return this;
    }

    public OutgoingTimeUpdatePacketBuilder setWorld(WorldData data) {
        this.timeOfDay = data.getWorldTime();
        this.worldAge = data.getWorldAge();
        return this;
    }

    public long getTimeOfDay() {
        return this.timeOfDay;
    }

    public OutgoingTimeUpdatePacketBuilder setTimeOfDay(long timeOfDay) {
        this.timeOfDay = timeOfDay;
        return this;
    }

    @Override
    public @NotNull OutgoingTimeUpdatePacket build() {
        return new OutgoingTimeUpdatePacket(this);
    }

    @Override
    public @NotNull Builder<OutgoingTimeUpdatePacket> from(OutgoingTimeUpdatePacket value) {
        this.timeOfDay = value.getTimeOfDay();
        this.worldAge = value.getWorldAge();
        return this;
    }

    @Override
    public PacketBuilder<OutgoingTimeUpdatePacket> reset() {
        this.timeOfDay = 0;
        this.worldAge = 0;
        return this;
    }

    @Override
    public PacketBuilder<OutgoingTimeUpdatePacket> copy() {
        return new OutgoingTimeUpdatePacketBuilder().setTimeOfDay(this.timeOfDay).setWorldAge(this.worldAge);
    }

    @Override
    public int getId() {
        return OutgoingTimeUpdatePacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
