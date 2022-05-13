package org.absorb.inventory;

public enum InventoryType {

    PLAYER_INVENTORY(0);

    private final int networkId;

    InventoryType(int networkId) {
        this.networkId = networkId;
    }

    public int getNetworkId() {
        return this.networkId;
    }
}
