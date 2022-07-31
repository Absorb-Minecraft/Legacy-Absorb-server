package org.absorb.event.annotations;

import org.absorb.event.Event;
import org.absorb.event.EventPriority;
import org.absorb.event.trigger.EventTriggerType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OnEvent {

    EventPriority priority() default EventPriority.MIDDLE;

    Class<EventTriggerType<?>>[] excludeWhenType() default {};

    Class<Event>[] ignoreWhen() default {};
    
    Class<Event>[] ignoreWhenNot() default {};

    boolean hasModifications() default true;
}
