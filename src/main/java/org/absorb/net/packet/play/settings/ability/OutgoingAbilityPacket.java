package org.absorb.net.packet.play.settings.ability;

import org.absorb.net.Client;
import org.absorb.net.data.SerializerUtils;
import org.absorb.net.data.Serializers;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.ByteBuffer;

public class OutgoingAbilityPacket implements OutgoingPacket {

    private static final int ID = 0x32;

    private final boolean isInvulnerable;
    private final boolean isFlying;
    private final boolean isFlyingAllowed;
    private final boolean isInstantBreak;
    private final float flyingSpeed;
    private final float fieldOfView;

    public OutgoingAbilityPacket(@NotNull OutgoingAbilityPacketBuilder builder) {
        this.isInstantBreak = builder.isInstantBreak();
        this.isFlyingAllowed = builder.isFlyingAllowed();
        this.isInvulnerable = builder.isInvulnerable();
        this.isFlying = builder.isFlying();
        this.flyingSpeed = builder.getFlyingSpeed();
        this.fieldOfView = builder.getFieldOfView();
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
    public @NotNull OutgoingAbilityPacketBuilder toBuilder() {
        return new OutgoingAbilityPacketBuilder()
                .setFieldOfView(this.fieldOfView)
                .setFlying(this.isFlying)
                .setFlyingAllowed(this.isFlyingAllowed)
                .setFlyingSpeed(this.flyingSpeed);
    }

    @Override
    public void send(@NotNull Client stream) {
        int total = 0;
        if (this.isInvulnerable) {
            total++;
        }
        if (this.isFlying) {
            total = total + 2;
        }
        if (this.isFlyingAllowed) {
            total = total + 4;
        }
        if (this.isInstantBreak) {
            total = total + 8;
        }
        ByteBuffer abilities = Serializers.BYTE.write((byte) total);
        ByteBuffer flyingSpeed = Serializers.FLOAT.write(this.flyingSpeed);
        ByteBuffer fov = Serializers.FLOAT.write(this.fieldOfView);
        ByteBuffer ret = SerializerUtils.createPacket(ID, abilities, flyingSpeed, fov);
        try {
            stream.write(ret);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
