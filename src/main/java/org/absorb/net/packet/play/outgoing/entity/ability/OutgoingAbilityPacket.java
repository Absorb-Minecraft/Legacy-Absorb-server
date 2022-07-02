package org.absorb.net.packet.play.outgoing.entity.ability;

import org.absorb.net.Client;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class OutgoingAbilityPacket implements OutgoingPacket {

    private final boolean isInvulnerable;
    private final boolean isFlying;
    private final boolean isFlyingAllowed;
    private final boolean isInstantBreak;
    private final float flyingSpeed;
    private final float fieldOfView;
    public static final int ID = 0x2F;

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
    public ByteBuffer toBytes(@NotNull Client stream) {
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
        ByteBuffer abilities = NetSerializers.BYTE.write((byte) total);
        ByteBuffer flyingSpeed = NetSerializers.FLOAT.write(this.flyingSpeed);
        ByteBuffer fov = NetSerializers.FLOAT.write(this.fieldOfView);

        System.out.println("Total: " + total);
        System.out.println("Flying Speed: " + this.flyingSpeed);
        System.out.println("FOV: " + this.fieldOfView);
        return NetUtils.createPacket(ID, abilities, flyingSpeed, fov);

    }
}
