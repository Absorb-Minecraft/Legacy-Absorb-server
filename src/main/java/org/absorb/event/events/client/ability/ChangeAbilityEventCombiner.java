package org.absorb.event.events.client.ability;

import org.absorb.event.combine.EventCombine;
import org.absorb.threaded.SimpleDataPoint;
import org.absorb.threaded.ThreadedDataPoint;

public class ChangeAbilityEventCombiner implements EventCombine<ChangeAbilityEvent> {

    private final ChangeAbilityEvent original;
    private ThreadedDataPoint<Boolean, Boolean> cancelled;
    private ThreadedDataPoint<Boolean, Boolean> value;

    public ChangeAbilityEventCombiner(ChangeAbilityEvent event) {
        this.cancelled = new SimpleDataPoint<>(event.hasBeenCancelled());
        this.value = new SimpleDataPoint<>(event.getChangingTo());
        this.original = event;
    }


    @Override
    public void apply(ChangeAbilityEvent event) {
        ThreadedDataPoint<Boolean, Boolean> cancelled = new SimpleDataPoint<>(event.hasBeenCancelled());
        if (cancelled.isNewer(this.cancelled)) {
            this.cancelled = cancelled;
        }
        ThreadedDataPoint<Boolean, Boolean> value = new SimpleDataPoint<>(event.getChangingTo());
        if (value.isNewer(this.value)) {
            this.value = value;
        }
    }

    @Override
    public ChangeAbilityEvent build() {
        ChangeAbilityEvent event = new AbstractChangeAbilityEventBuilder().from(this.original).build();
        event.setChangingTo(this.value.getValue());
        event.setCancelled(this.cancelled.getValue());
        return event;
    }
}
