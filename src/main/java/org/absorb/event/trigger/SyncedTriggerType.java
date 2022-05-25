package org.absorb.event.trigger;

import org.absorb.AbsorbManagers;
import org.absorb.event.Event;
import org.absorb.event.EventHandler;

import java.util.Collection;

public class SyncedTriggerType implements EventTriggerType<Event> {
    @Override
    public <R extends Event> R call(R event) {
        Collection<EventHandler<R>> handlers = AbsorbManagers.getEventManager().getCompatibleHandlers(this, event);
        for (EventHandler<R> handler : handlers) {
            try {
                handler.call(this, event);
            } catch (Throwable e) {
                handler.setSkipped(true);
                e.printStackTrace();
            }
        }
        return event;
    }
}
