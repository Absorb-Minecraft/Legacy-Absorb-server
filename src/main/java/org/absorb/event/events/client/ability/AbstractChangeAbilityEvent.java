package org.absorb.event.events.client.ability;

import org.absorb.event.Event;
import org.absorb.event.cause.EventCause;
import org.absorb.event.combine.EventCombine;
import org.absorb.net.Client;
import org.absorb.net.packet.play.incoming.client.ability.PlayerAbilities;
import org.jetbrains.annotations.NotNull;

public class AbstractChangeAbilityEvent implements ChangeAbilityEvent {

    private final EventCause willCause;
    private final EventCause hasCaused;
    private final PlayerAbilities abilities;
    private final Client client;
    private final boolean originalValue;

    private boolean newValue;
    private boolean cancelled;

    public AbstractChangeAbilityEvent(AbstractChangeAbilityEventBuilder builder) {
        this.willCause = builder.getWillCause();
        this.hasCaused = builder.getHasCaused();
        this.abilities = builder.getAbilities();
        this.client = builder.getClient();
        this.newValue = builder.getValue();
        this.originalValue = builder.getValue();
    }

    @Override
    public @NotNull EventCause willCause() {
        return this.willCause;
    }

    @Override
    public @NotNull EventCause hasCaused() {
        return this.hasCaused;
    }

    @Override
    public Event copy() {
        return new AbstractChangeAbilityEventBuilder()
                .setAbilities(this.abilities)
                .setValue(this.newValue)
                .setWillCause(this.willCause)
                .setHasCaused(this.hasCaused)
                .setClient(this.client)
                .build();
    }

    @Override
    public boolean hasBeenCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean check) {
        this.cancelled = check;
    }

    @Override
    public Client getClient() {
        return this.client;
    }

    @Override
    public PlayerAbilities getAbility() {
        return this.abilities;
    }

    @Override
    public boolean getChangingTo() {
        return this.newValue;
    }

    @Override
    public void setChangingTo(boolean value) {
        this.newValue = value;
    }

    @Override
    public boolean getChangingFrom() {
        return this.originalValue;
    }

    @Override
    public EventCombine<?> getCombiner() {
        return new ChangeAbilityEventCombiner(this);
    }
}
