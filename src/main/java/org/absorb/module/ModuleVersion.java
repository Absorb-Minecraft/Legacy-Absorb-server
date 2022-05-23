package org.absorb.module;

public class ModuleVersion {

    private final int major;
    private final int minor;
    private final int patch;

    public ModuleVersion(int major, int minor, int patch) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
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

    public String toString() {
        return this.major + "." + this.minor + "." + this.patch;
    }
}
