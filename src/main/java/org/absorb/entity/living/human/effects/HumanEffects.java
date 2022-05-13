package org.absorb.entity.living.human.effects;

public enum HumanEffects implements HumanEffect {

    PERMISSION_LEVEL_ZERO(24),
    PERMISSION_LEVEL_ONE(25),
    PERMISSION_LEVEL_TWO(26),
    PERMISSION_LEVEL_THREE(27),
    PERMISSION_LEVEL_FOUR(28);

    private final byte statusCode;

    HumanEffects(int code) {
        this.statusCode = (byte) code;
    }

    @Override
    public byte getStatusCode() {
        return this.statusCode;
    }
}
