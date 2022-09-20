package org.absorb.net.packet.play.outgoing.entity.metadata.types.value.bitmask;

import org.absorb.entity.living.human.Hand;
import org.absorb.net.data.Bitmaskable;
import org.jetbrains.annotations.NotNull;

public class HandBitmask implements Bitmaskable {

    private boolean isHandActive;
    private @NotNull Hand activeHand;
    private boolean isRiptideSpinAttack;

    public HandBitmask() {
        this.activeHand = Hand.RIGHT;
    }

    public boolean isHandActive() {
        return this.isHandActive;
    }

    public HandBitmask setHandActive(boolean handActive) {
        this.isHandActive = handActive;
        return this;
    }

    public Hand getActiveHand() {
        return this.activeHand;
    }

    public HandBitmask setActiveHand(Hand activeHand) {
        this.activeHand = activeHand;
        return this;
    }

    public boolean isRiptideSpinAttack() {
        return this.isRiptideSpinAttack;
    }

    public HandBitmask setRiptideSpinAttack(boolean riptideSpinAttack) {
        this.isRiptideSpinAttack = riptideSpinAttack;
        return this;
    }

    @Override
    public byte toBitmask() {
        int bitmask = 0;
        if (this.isHandActive) {
            bitmask = 1;
        }
        if (this.activeHand == Hand.LEFT) {
            bitmask = bitmask + 2;
        }
        if (this.isRiptideSpinAttack) {
            bitmask = bitmask + 4;
        }
        return (byte) bitmask;
    }
}
