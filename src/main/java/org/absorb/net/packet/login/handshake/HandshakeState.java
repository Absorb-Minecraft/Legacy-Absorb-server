package org.absorb.net.packet.login.handshake;

public enum HandshakeState {

    STATUS(1),
    LOGIN(2);

    private final int stateId;

    HandshakeState(int id) {
        this.stateId = id;
    }

    public int Id() {
        return this.stateId;
    }

    public static HandshakeState getValue(int networkId) {
        for (HandshakeState state : values()) {
            if (state.Id()==networkId) {
                return state;
            }
        }
        throw new IllegalArgumentException("Cannot find Handshake status with id of " + networkId);
    }
}
