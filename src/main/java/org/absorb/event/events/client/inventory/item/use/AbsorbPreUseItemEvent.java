package org.absorb.event.events.client.inventory.item.use;

import org.absorb.event.Event;
import org.absorb.event.cause.EventCause;
import org.absorb.inventory.slot.Slot;
import org.absorb.net.Client;
import org.jetbrains.annotations.NotNull;

public class AbsorbPreUseItemEvent implements UseItemEvent.Pre {

    private final Client client;

    private final Slot slot;
    private final EventCause caused;
    private final EventCause willCause;
    private boolean cancelled;

    public AbsorbPreUseItemEvent(UseItemEventBuilder<?> builder) {
        this.caused = builder.getCaused();
        this.willCause = builder.getWillCause();
        this.slot = builder.getItem();
        this.client = builder.getClient();
    }


    @Override
    public @NotNull EventCause willCause() {
        return this.willCause;
    }

    @Override
    public @NotNull EventCause hasCaused() {
        return this.caused;
    }

    @Override
    public Event copy() {
        return new UseItemEventBuilder<UseItemEvent.Pre>().from(this).build();
    }

    @Override
    public Client getClient() {
        return this.client;
    }

    @Override
    public Slot getSlot() {
        return this.slot;
    }

    @Override
    public boolean hasBeenCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean check) {
        this.cancelled = check;
    }
}
