package org.absorb.net.packet.play.outgoing.entity.ability;

import org.absorb.entity.Entity;
import org.absorb.entity.living.human.Gamemodes;
import org.absorb.entity.living.human.Human;
import org.absorb.net.Client;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

public class OutgoingAbilityPacketBuilder implements OutgoingPacketBuilder<OutgoingAbilityPacket> {

    private boolean isInvulnerable;
    private boolean isFlying;
    private boolean isFlyingAllowed;
    private boolean isInstantBreak;
    private float flyingSpeed;
    private float fieldOfView;

    public OutgoingAbilityPacketBuilder() {
        reset();
    }

    public OutgoingAbilityPacketBuilder fromClient(@NotNull Client client) {
        this.fromEntity(client.getEntity().getEntity());
        return this;
    }

    public OutgoingAbilityPacketBuilder fromEntity(@NotNull Entity entity) {
        this.isFlying = entity.isFlying();
        if (entity instanceof Human human) {
            this.isFlyingAllowed = human.isFlyingAllowed();
            this.isInstantBreak = human.getGamemode() == Gamemodes.CREATIVE;
        }
        return this;
    }

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
    public @NotNull Builder<OutgoingAbilityPacket> from(OutgoingAbilityPacket value) {
        this.fieldOfView = value.getFieldOfView();
        this.flyingSpeed = value.getFlyingSpeed();
        this.isInstantBreak = value.isInstantBreak();
        this.isFlying = value.isFlying();
        this.isFlyingAllowed = value.isFlyingAllowed();
        this.isInvulnerable = value.isInvulnerable();
        return this;
    }

    @Override
    public @NotNull PacketBuilder<OutgoingAbilityPacket> reset() {
        this.fieldOfView = 0.1f;
        this.isInstantBreak = false;
        this.isInvulnerable = false;
        this.flyingSpeed = 0.05f;
        return this;
    }

    @Override
    public @NotNull PacketBuilder<OutgoingAbilityPacket> copy() {
        return new OutgoingAbilityPacketBuilder()
                .setFlying(this.isFlying)
                .setFlyingAllowed(this.isFlyingAllowed)
                .setFieldOfView(this.fieldOfView)
                .setInstantBreak(this.isInstantBreak);
    }

    @Override
    public int getId() {
        return OutgoingAbilityPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
