package org.absorb.net.packet.play.incoming.client.ability;

public enum PlayerAbilities {

    IS_FLYING(0x02);

    private final int networkId;

    PlayerAbilities(int networkId) {
        this.networkId = networkId;
    }

    public int getNetworkId() {
        return this.networkId;
    }

    public static PlayerAbilities getValueOf(int networkId) {
        for (PlayerAbilities ability : values()) {
            if (ability.getNetworkId()==networkId) {
                return ability;
            }
        }
        throw new RuntimeException("Unknown PlayerAbility of " + networkId);
    }
}
