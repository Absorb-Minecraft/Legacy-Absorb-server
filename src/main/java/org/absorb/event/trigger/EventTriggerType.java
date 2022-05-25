package org.absorb.event.trigger;

import org.absorb.event.Event;
import org.absorb.register.Typed;

@Typed(getTypesClass = EventTriggerTypes.class)
public interface EventTriggerType<E extends Event> {

    <R extends E> R call(R event);
}
