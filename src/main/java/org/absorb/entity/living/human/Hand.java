package org.absorb.entity.living.human;

public enum Hand {

    LEFT(0),
    RIGHT(1);

    private final int id;

    Hand(int id) {
        this.id = id;
    }

    public int getNetworkId() {
        return this.id;
    }

    public static Hand fromNetworkId(int id) {
        for (Hand mode : values()) {
            if (mode.id==id) {
                return mode;
            }
        }
        throw new IllegalArgumentException("Unknown network id of " + id);
    }
}
