package org.absorb.event.events.inventory.client.inventory.item.use;

import org.absorb.event.cause.EventCause;
import org.absorb.inventory.slot.Slot;
import org.absorb.net.Client;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

public class UseItemEventBuilder<E extends UseItemEvent> implements Builder<E> {

    private EventCause caused;
    private EventCause willCause;
    private Slot item;
    private Client client;

    public EventCause getCaused() {
        return this.caused;
    }

    public UseItemEventBuilder<E> setCaused(EventCause caused) {
        this.caused = caused;
        return this;
    }

    public EventCause getWillCause() {
        return this.willCause;
    }

    public UseItemEventBuilder<E> setWillCause(EventCause willCause) {
        this.willCause = willCause;
        return this;
    }

    public Slot getItem() {
        return this.item;
    }

    public UseItemEventBuilder<E> setItem(Slot item) {
        this.item = item;
        return this;
    }

    public Client getClient() {
        return this.client;
    }

    public UseItemEventBuilder<E> setClient(Client client) {
        this.client = client;
        return this;
    }

    @Override
    public @NotNull E build() {
        return (E) new AbsorbPreUseItemEvent(this);
    }

    @Override
    public @NotNull Builder<E> reset() {
        this.caused = null;
        this.willCause = null;
        this.item = null;
        this.client = null;
        return this;
    }

    @Override
    public @NotNull Builder<E> copy() {
        return new UseItemEventBuilder<E>()
                .setItem(this.item)
                .setCaused(this.caused)
                .setClient(this.client)
                .setWillCause(this.willCause);
    }

    public UseItemEventBuilder<E> from(UseItemEvent event) {
        this.item = event.getSlot();
        this.client = event.getClient();
        this.willCause = event.willCause();
        this.caused = event.hasCaused();
        return this;
    }
}
