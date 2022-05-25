package org.absorb.event.trigger;

import org.absorb.AbsorbManagers;
import org.absorb.event.Event;
import org.absorb.event.EventHandler;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

public class SyncedTriggerType implements EventTriggerType<Event> {
    @Override
    public <R extends Event> R call(R event) {
        Collection<EventHandler<R>> handlers = new TreeSet<>(Comparator.comparing(EventHandler::getPriority));
        handlers.addAll(AbsorbManagers.getEventManager().getCompatibleHandlers(this, event));
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
