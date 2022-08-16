package org.absorb.net.packet.play.outgoing.entity.metadata.types.value.bitmask;

import org.absorb.net.data.Bitmaskable;

public class SkinBitmask implements Bitmaskable {

    private boolean cape;
    private boolean jacket;
    private boolean leftSleeve;
    private boolean rightSleeve;
    private boolean leftTrousers;
    private boolean rightTrousers;
    private boolean hat;

    public SkinBitmask setShowingRightCape(boolean check) {
        this.cape = check;
        return this;
    }

    public boolean isShowingCape() {
        return this.cape;
    }

    public boolean isShowingJacket() {
        return this.jacket;
    }

    public SkinBitmask setShowingJacket(boolean check) {
        this.jacket = check;
        return this;
    }

    public boolean isShowingLeftSleeve() {
        return this.leftSleeve;
    }

    public SkinBitmask setShowingLeftSleeve(boolean check) {
        this.leftSleeve = check;
        return this;
    }

    public boolean isShowingRightSleeve() {
        return this.rightSleeve;
    }

    public SkinBitmask setShowingRightSleeve(boolean check) {
        this.rightSleeve = check;
        return this;
    }

    public boolean isShowingLeftTrousers() {
        return this.leftTrousers;
    }

    public SkinBitmask setShowingLeftTrousers(boolean check) {
        this.leftTrousers = check;
        return this;
    }

    public boolean isShowingRightTrousers() {
        return this.rightTrousers;
    }

    public SkinBitmask setShowingRightTrousers(boolean check) {
        this.rightTrousers = check;
        return this;
    }

    public boolean isShowingHat() {
        return this.hat;
    }

    public SkinBitmask setShowingHat(boolean check) {
        this.hat = check;
        return this;
    }


    @Override
    public byte toBitmask() {
        int bitmask = 0;
        if (this.cape) {
            bitmask = bitmask + 1;
        }
        if (this.jacket) {
            bitmask = bitmask + 2;
        }
        if (this.leftSleeve) {
            bitmask = bitmask + 4;
        }
        if (this.rightSleeve) {
            bitmask = bitmask + 8;
        }
        if (this.leftTrousers) {
            bitmask = bitmask + 10;
        }
        if (this.rightTrousers) {
            bitmask = bitmask + 20;
        }
        if (this.hat) {
            bitmask = bitmask + 40;
        }
        return (byte) bitmask;
    }
}
