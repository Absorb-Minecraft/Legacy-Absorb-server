package org.absorb.event.events;

import org.absorb.event.Event;

public interface CancelableEvent extends Event {

    boolean hasBeenCancelled();

    void setCancelled(boolean check);
}
