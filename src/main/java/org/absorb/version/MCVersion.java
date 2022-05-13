package org.absorb.version;

public class MCVersion {

    public static final MCVersion MC1_18_2 = new MCVersion(1, 18, 2, 758);
    public static final MCVersion MC1_18_0 = new MCVersion(1, 18, 0, 757);

    public static final MCVersion CURRENT = MC1_18_2;

    private final int major;
    private final int minor;
    private final int patch;
    private final int networkName;

    private MCVersion(int major, int minor, int patch, int networkId) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
        this.networkName = networkId;
    }


    public int getMajor() {
        return this.major;
    }

    public int getMinor() {
        return this.minor;
    }

    public int getPatch() {
        return this.patch;
    }

    public int protocolVersion() {
        return this.networkName;
    }

    public String name() {
        return this.getMajor() + "." + this.getMinor() + "." + this.getPatch();
    }
}
