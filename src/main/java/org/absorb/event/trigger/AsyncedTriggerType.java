package org.absorb.event.trigger;

import org.absorb.AbsorbManagers;
import org.absorb.event.Event;
import org.absorb.event.EventHandler;

import java.util.Collection;

public class AsyncedTriggerType implements EventTriggerType<Event> {
    @Override
    public <R extends Event> R call(R event) {
        Collection<EventHandler<R>> handlers = AbsorbManagers.getEventManager().getCompatibleHandlers(this, event);
        for (EventHandler<R> handler : handlers) {
            new Thread(() -> {
                try {
                    handler.call(this, (R) event.copy());
                } catch (Throwable e) {
                    handler.setSkipped(true);
                    e.printStackTrace();
                }
            }).start();
        }
        return event;
    }
}
