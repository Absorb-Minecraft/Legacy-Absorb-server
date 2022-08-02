package org.absorb.net.packet.play.outgoing.client.action;

public enum ClientCommandAction {

    RESPAWN(0),
    REQUEST_STATISTICS(1);

    private final int networkId;

    ClientCommandAction(int id) {
        this.networkId = id;
    }

    public int getNetworkId() {
        return this.networkId;
    }

    public static ClientCommandAction getValue(int id) {
        for (ClientCommandAction action : values()) {
            if (action.getNetworkId() == id) {
                return action;
            }
        }
        throw new IllegalArgumentException("Action with id of " + id + " cannot be found");
    }

}
