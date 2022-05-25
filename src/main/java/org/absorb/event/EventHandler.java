package org.absorb.event;

import org.absorb.event.annotations.OnEvent;
import org.absorb.event.annotations.With;
import org.absorb.event.annotations.WithData;
import org.absorb.event.trigger.EventTriggerType;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.concurrent.LinkedTransferQueue;
import java.util.stream.Collectors;

public class EventHandler<E extends Event> {

    private final Method eventHandler;
    private final Object invokeWith;
    private final Class<E> eventType;
    private final Class<? extends EventTriggerType<?>>[] excludeWhen;
    private final EventPriority priority;
    private final boolean doesModifications;

    private final Collection<WithData> with = new LinkedTransferQueue<>();
    private boolean skip;

    @SafeVarargs
    private EventHandler(Object invokeWith, Method eventHandler, Class<E> eventType, EventPriority priority,
                         boolean doesModifications, Class<? extends EventTriggerType<?>>... excludeWhen) {
        this.invokeWith = invokeWith;
        this.eventHandler = eventHandler;
        this.eventType = eventType;
        this.priority = priority;
        this.excludeWhen = excludeWhen;
        this.doesModifications = doesModifications;
    }

    public Method getEventHandler() {
        return this.eventHandler;
    }

    public boolean doesModifications() {
        return this.doesModifications;
    }

    public Object getInvokeWith() {
        return this.invokeWith;
    }

    public Class<E> getEventType() {
        return this.eventType;
    }

    public Class<? extends EventTriggerType<?>>[] getExcludeWhen() {
        return this.excludeWhen;
    }

    public EventPriority getPriority() {
        return this.priority;
    }

    public boolean isSkipped() {
        return this.skip;
    }

    public void setSkipped(boolean check) {
        this.skip = check;
    }

    public boolean canExecute(@NotNull EventTriggerType<?> type, @NotNull E event) {
        if (this.skip) {
            return false;
        }
        if (Arrays.stream(this.excludeWhen).anyMatch(trigger -> trigger.isInstance(type))) {
            return false;
        }
        return this.with.parallelStream().allMatch(entry -> {
            try {
                Object result = event.getClass().getMethod(entry.name()).invoke(event);
                return entry.type().isInstance(result);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
                return false;
            }
        });
    }

    public @NotNull E call(@NotNull EventTriggerType<?> type, @NotNull E event) throws InvocationTargetException,
            IllegalAccessException {
        if (Arrays.stream(this.excludeWhen).anyMatch(trigger -> trigger.isInstance(type))) {
            throw new IllegalArgumentException("Cannot fire event with trigger type of " + type);
        }
        Map<WithData, Object> with = this.with.parallelStream().map(entry -> {
            try {
                Object result = event.getClass().getMethod(entry.name()).invoke(event);
                return new AbstractMap.SimpleEntry<>(entry, result);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));

        for (Map.Entry<WithData, Object> entry : with.entrySet()) {
            if (!entry.getKey().type().isInstance(entry.getValue())) {
                throw new IllegalArgumentException("The EventHandler (" + this.eventHandler.getName() + ") has been " +
                        "attempted to be invoked with a event that does not have the correct @With values. With: " + entry.getKey().name() + " ValueType: " + entry.getValue().getClass().getName());
            }
        }

        Object[] parameters = new Object[with.size() + 1];
        Object[] withParameters =
                with
                        .entrySet()
                        .stream()
                        .sorted(Comparator.comparing(entry -> entry.getKey().index()))
                        .map(Map.Entry::getValue)
                        .toArray();
        parameters[0] = event;
        System.arraycopy(withParameters, 0, parameters, 1, withParameters.length);

        this.eventHandler.invoke(this.invokeWith, parameters);
        return event;
    }

    public static <H extends Event> @NotNull EventHandler<H> of(@NotNull Object invokeWith, @NotNull Method method) {
        OnEvent onEvent = method.getAnnotation(OnEvent.class);
        if (onEvent==null) {
            throw new IllegalArgumentException("Provided method (" + method.getName() + ") does not contain the " +
                    "annotation @OnEvent");
        }
        Parameter[] parameters = method.getParameters();
        if (parameters.length==0) {
            throw new IllegalArgumentException("Provided method (" + method.getName() + ") does not contain a event");
        }
        Class<?> parameterEvent = parameters[0].getType();
        if (!Event.class.isAssignableFrom(parameterEvent)) {
            throw new IllegalArgumentException("Provided method (" + method.getName() + ") does not contain a event " +
                    "as its first parameter");
        }
        Class<H> eventType = (Class<H>) parameterEvent;
        Class<EventTriggerType<?>>[] excludeWhen = onEvent.excludeWhenType();
        EventPriority priority = onEvent.priority();
        boolean doesModifications = onEvent.hasModifications();

        EventHandler<H> handler = new EventHandler<>(invokeWith, method, eventType, priority, doesModifications, excludeWhen);
        for (int i = 1; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            With with = parameter.getAnnotation(With.class);
            if (with!=null) {
                String methodName = with.methodName();
                Method withMethod;
                try {
                    withMethod = eventType.getMethod(methodName);
                } catch (NoSuchMethodException e) {
                    throw new IllegalArgumentException("Method name found in with (" + methodName + ") on event " +
                            "handler (" + method.getName() + ") does not relate to a none parameter method found in " + eventType.getName(), e);
                }
                Class<?> returnType = parameter.getType();
                handler.with.add(new WithData(i, methodName, returnType));
                continue;
            }

        }
        return handler;

    }
}
