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
