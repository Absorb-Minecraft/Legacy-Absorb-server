package org.absorb.event.combine;

import org.absorb.event.Event;

public interface AwaitingEvent extends Event {

    EventCombine<?> getCombiner();
}
