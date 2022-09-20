package org.absorb.net.packet.play.outgoing.entity.metadata.types.value.bitmask;

import org.absorb.net.data.Bitmaskable;

public class MobBitmask implements Bitmaskable {

    private boolean noAi;
    private boolean leftHanded;
    private boolean isAggressive;

    public boolean hasNoAi() {
        return this.noAi;
    }

    public MobBitmask setNoAi(boolean noAi) {
        this.noAi = noAi;
        return this;
    }

    public boolean isLeftHanded() {
        return this.leftHanded;
    }

    public MobBitmask setLeftHanded(boolean leftHanded) {
        this.leftHanded = leftHanded;
        return this;
    }

    public boolean isAggressive() {
        return this.isAggressive;
    }

    public MobBitmask setAggressive(boolean aggressive) {
        this.isAggressive = aggressive;
        return this;
    }

    @Override
    public byte toBitmask() {
        int bitmask = 0;
        if (this.noAi) {
            bitmask = 1;
        }
        if (this.leftHanded) {
            bitmask = bitmask + 2;
        }
        if (this.isAggressive) {
            bitmask = bitmask + 4;
        }

        return (byte) bitmask;
    }
}
