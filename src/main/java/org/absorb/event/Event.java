package org.absorb.event;

import org.absorb.event.cause.EventCause;
import org.jetbrains.annotations.NotNull;

public interface Event {

    @NotNull EventCause willCause();

    @NotNull EventCause hasCaused();

    Event copy();
}
