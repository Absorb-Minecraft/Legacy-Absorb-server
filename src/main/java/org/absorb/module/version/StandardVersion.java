package org.absorb.module.version;

import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class StandardVersion implements ModuleVersion {
    private final int major;
    private final int minor;
    private final int patch;
    private final @Nullable String notes;

    public static final String DEV = "Dev";
    public static final String SNAPSHOT = "SNAPSHOT";

    public StandardVersion(int major, int minor, int patch) {
        this(major, minor, patch, null);
    }

    public StandardVersion(int major, int minor, int patch, @Nullable String notes) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
        this.notes = notes;
    }

    public Optional<String> getNote() {
        return Optional.ofNullable(this.notes);
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
        return this.getNote().map(note -> note + "-").orElse("") + this.major + "." + this.minor + "." + this.patch;
    }

    @Override
    public String asString() {
        return this.toString();
    }
}
