package org.absorb.utils;

import org.absorb.register.AbsorbKey;

public class BuildException extends IllegalStateException {

    public BuildException(Identifiable cause, Throwable e) {
        this("Could not build " + cause.getResourceKey(), e);
    }

    public BuildException(AbsorbKey cause, Throwable e) {
        this("Could not build " + cause.asFormatted(), e);
    }

    public BuildException(String reason, Throwable e) {
        super(reason, e);
    }
}
