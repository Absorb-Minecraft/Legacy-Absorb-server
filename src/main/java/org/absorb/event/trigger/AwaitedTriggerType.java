package org.absorb.event.trigger;

import org.absorb.AbsorbManagers;
import org.absorb.event.EventHandler;
import org.absorb.event.combine.AwaitingEvent;
import org.absorb.event.combine.EventCombine;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.concurrent.LinkedTransferQueue;

public class AwaitedTriggerType implements EventTriggerType<AwaitingEvent> {
    @Override
    public <R extends AwaitingEvent> R call(R event) {
        Collection<EventHandler<R>> handlers = new TreeSet<>(Comparator.comparing(EventHandler::getPriority));
        handlers.addAll(AbsorbManagers.getEventManager().getCompatibleHandlers(this, event));
        EventCombine<R> combiner = (EventCombine<R>) event.getCombiner();
        Collection<Thread> threads = new LinkedTransferQueue<>();
        for (EventHandler<R> handler : handlers) {
            Thread thread = new Thread(() -> {
                R result;
                try {
                    result = handler.call(this, (R) event.copy());
                } catch (Throwable e) {
                    handler.setSkipped(true);
                    e.printStackTrace();
                    return;
                }
                combiner.apply(result);
            });
            thread.start();
            if (handler.doesModifications()) {
                //if no modifications are done, wont change result and therefore to save time, don't await it
                threads.add(thread);
            }
        }

        while (threads.parallelStream().anyMatch(Thread::isAlive)) {
            //await for all threads to complete
        }
        return combiner.build();
    }
}
