package org.absorb.net.packet.play.outgoing.world.time;

import org.absorb.net.Client;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class OutgoingTimeUpdatePacket implements OutgoingPacket {

    private final long worldAge;
    private final long timeOfDay;
    public static final int ID = 0x5C;

    public OutgoingTimeUpdatePacket(OutgoingTimeUpdatePacketBuilder builder) {
        this.worldAge = builder.getWorldAge();
        this.timeOfDay = builder.getTimeOfDay();
    }

    public long getWorldAge() {
        return this.worldAge;
    }

    public long getTimeOfDay() {
        return this.timeOfDay;
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
        return new OutgoingTimeUpdatePacketBuilder().setTimeOfDay(this.timeOfDay).setWorldAge(this.worldAge);
    }

    @Override
    public ByteBuffer toBytes(Client stream) {
        return NetUtils.createPacket(ID,
                                     NetSerializers.LONG.write(this.worldAge),
                                     NetSerializers.LONG.write(this.timeOfDay));
    }
}
