package org.absorb.net.packet.play.settings.ability;

import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

public class OutgoingAbilityPacketBuilder implements OutgoingPacketBuilder<OutgoingAbilityPacket> {

    private boolean isInvulnerable;
    private boolean isFlying;
    private boolean isFlyingAllowed;
    private boolean isInstantBreak;
    private float flyingSpeed;
    private float fieldOfView;

    public boolean isInvulnerable() {
        return this.isInvulnerable;
    }

    public OutgoingAbilityPacketBuilder setInvulnerable(boolean invulnerable) {
        this.isInvulnerable = invulnerable;
        return this;
    }

    public boolean isFlying() {
        return this.isFlying;
    }

    public OutgoingAbilityPacketBuilder setFlying(boolean flying) {
        this.isFlying = flying;
        return this;
    }

    public boolean isFlyingAllowed() {
        return this.isFlyingAllowed;
    }

    public OutgoingAbilityPacketBuilder setFlyingAllowed(boolean flyingAllowed) {
        this.isFlyingAllowed = flyingAllowed;
        return this;
    }

    public boolean isInstantBreak() {
        return this.isInstantBreak;
    }

    public OutgoingAbilityPacketBuilder setInstantBreak(boolean instantBreak) {
        this.isInstantBreak = instantBreak;
        return this;
    }

    public float getFlyingSpeed() {
        return this.flyingSpeed;
    }

    public OutgoingAbilityPacketBuilder setFlyingSpeed(float flyingSpeed) {
        this.flyingSpeed = flyingSpeed;
        return this;
    }

    public float getFieldOfView() {
        return this.fieldOfView;
    }

    public OutgoingAbilityPacketBuilder setFieldOfView(float fieldOfView) {
        this.fieldOfView = fieldOfView;
        return this;
    }

    @Override
    public @NotNull OutgoingAbilityPacket build() {
        return new OutgoingAbilityPacket(this);
    }

    @Override
    public PacketBuilder<OutgoingAbilityPacket> reset() {
        return null;
    }

    @Override
    public PacketBuilder<OutgoingAbilityPacket> copy() {
        return null;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public @NotNull PacketState getState() {
        return null;
    }
}
