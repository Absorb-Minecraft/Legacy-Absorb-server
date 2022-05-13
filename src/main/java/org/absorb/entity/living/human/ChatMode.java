package org.absorb.entity.living.human;

public enum ChatMode {

    ENABLED(0),
    COMMAND_ONLY(1),
    HIDDEN(2);

    private final int id;

    ChatMode(int id) {
        this.id = id;
    }

    public int getNetworkId() {
        return id;
    }

    public static ChatMode fromNetworkId(int id) {
        for (ChatMode mode : values()) {
            if (mode.id==id) {
                return mode;
            }
        }
        throw new IllegalArgumentException("Unknown network id of " + id);
    }
}
