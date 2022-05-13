package org.absorb.world;

public enum Difficulty {

    PEACEFUL(0),
    EASY(1),
    NORMAL(2),
    HARD(3);

    private final byte id;

    Difficulty(int id) {
        this.id = (byte) id;
    }

    public byte getNetworkId() {
        return this.id;
    }
}
