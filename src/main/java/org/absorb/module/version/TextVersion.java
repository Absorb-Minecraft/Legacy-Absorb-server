package org.absorb.module.version;

import org.jetbrains.annotations.NotNull;

public class TextVersion implements ModuleVersion {

    private final @NotNull String text;

    public TextVersion(@NotNull String text) {
        this.text = text;
    }

    @Override
    public String asString() {
        return this.text;
    }
}
