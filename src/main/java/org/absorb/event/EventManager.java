package org.absorb.event;

import org.absorb.event.annotations.OnEvent;
import org.absorb.event.combine.AwaitingEvent;
import org.absorb.event.trigger.EventTriggerType;
import org.absorb.event.trigger.EventTriggerTypes;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;
import java.util.stream.Collectors;

public class EventManager {

    private final LinkedTransferQueue<EventHandler<?>> eventHandlers = new LinkedTransferQueue<>();

    public void register(@NotNull EventHandler<?> handler) {
        this.eventHandlers.add(handler);
    }

    public void registerAll(@NotNull Object object) {
        List<EventHandler<Event>> eventHandlers = Arrays.stream(object.getClass().getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(OnEvent.class))
                .map(method -> EventHandler.of(object, method))
                .toList();
        this.eventHandlers.addAll(eventHandlers);
    }

    public <E extends Event> Collection<EventHandler<E>> getHandlersFor(Class<E> eventClass) {
        return this
                .eventHandlers
                .parallelStream()
                .filter(handler -> handler.getEventType().isAssignableFrom(eventClass))
                .map(handler -> (EventHandler<E>) handler)
                .toList();
    }

    public <E extends Event> Collection<EventHandler<E>> getCompatibleHandlers(@NotNull EventTriggerType<?> type,
                                                                               @NotNull E event) {
        return this
                .getHandlersFor((Class<E>) event.getClass())
                .parallelStream()
                .filter(handler -> handler.canExecute(type, event))
                .collect(Collectors.toSet());
    }

    public <R extends Event, E extends R> E call(@NotNull EventTriggerType<R> type, @NotNull E event) {
        return type.call(event);
    }

    public <E extends Event> E callSynced(@NotNull E event) {
        return EventTriggerTypes.SYNCED.call(event);
    }

    public <E extends AwaitingEvent> E callAwaiting(@NotNull E event) {
        return EventTriggerTypes.AWAITED.call(event);
    }

    public void callAsynced(@NotNull Event event) {
        EventTriggerTypes.ASYNCED.call(event);
    }
}
