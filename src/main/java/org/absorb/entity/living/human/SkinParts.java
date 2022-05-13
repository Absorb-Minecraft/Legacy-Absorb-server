package org.absorb.entity.living.human;

public enum SkinParts {

    CAPE(0x01),
    JACKET(0x02),
    LEFT_SLEEVE(0x04),
    RIGHT_SLEEVE(0x08),
    LEFT_LEG(0x10),
    RIGHT_LEG(0x20),
    HAT(0x40);

    private final int id;

    SkinParts(int id) {
        this.id = id;
    }

    public int getNetworkId() {
        return id;
    }

    public static SkinParts fromNetworkId(int id) {
        for (SkinParts mode : values()) {
            if (mode.id==id) {
                return mode;
            }
        }
        throw new IllegalArgumentException("Unknown network id of " + id);
    }
}
