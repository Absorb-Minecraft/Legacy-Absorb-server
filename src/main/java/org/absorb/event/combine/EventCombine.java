package org.absorb.event.combine;

import org.absorb.event.Event;

public interface EventCombine<E extends Event> {

    void apply(E event);

    E build();

}
