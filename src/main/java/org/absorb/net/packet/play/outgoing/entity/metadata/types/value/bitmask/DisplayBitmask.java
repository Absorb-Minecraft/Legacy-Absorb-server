package org.absorb.net.packet.play.outgoing.entity.metadata.types.value.bitmask;

import org.absorb.net.data.Bitmaskable;

public class DisplayBitmask implements Bitmaskable {

    private boolean onFire;
    private boolean crouching;
    private boolean sprinting;
    private boolean swimming;
    private boolean invisible;
    private boolean glowing;
    private boolean flyingElytra;

    public boolean isOnFire() {
        return this.onFire;
    }

    public DisplayBitmask setOnFire(boolean onFire) {
        this.onFire = onFire;
        return this;
    }

    public boolean isCrouching() {
        return this.crouching;
    }

    public DisplayBitmask setCrouching(boolean crouching) {
        this.crouching = crouching;
        return this;
    }

    public boolean isSprinting() {
        return this.sprinting;
    }

    public DisplayBitmask setSprinting(boolean sprinting) {
        this.sprinting = sprinting;
        return this;
    }

    public boolean isSwimming() {
        return this.swimming;
    }

    public DisplayBitmask setSwimming(boolean swimming) {
        this.swimming = swimming;
        return this;
    }

    public boolean isInvisible() {
        return this.invisible;
    }

    public DisplayBitmask setInvisible(boolean invisible) {
        this.invisible = invisible;
        return this;
    }

    public boolean isGlowing() {
        return this.glowing;
    }

    public DisplayBitmask setGlowing(boolean glowing) {
        this.glowing = glowing;
        return this;
    }

    public boolean isFlyingElytra() {
        return this.flyingElytra;
    }

    public DisplayBitmask setFlyingElytra(boolean flyingElytra) {
        this.flyingElytra = flyingElytra;
        return this;
    }

    @Override
    public byte toBitmask() {
        int result = 0;
        if (this.onFire) {
            result = 1;
        }
        if (this.crouching) {
            result = result + 2;
        }
        if (this.sprinting) {
            result = result + 8;
        }
        if (this.swimming) {
            result = result + 10;
        }
        if (this.invisible) {
            result = result + 20;
        }
        if (this.glowing) {
            result = result + 40;
        }
        if (this.flyingElytra) {
            result = result + 80;
        }
        return (byte) result;
    }
}
