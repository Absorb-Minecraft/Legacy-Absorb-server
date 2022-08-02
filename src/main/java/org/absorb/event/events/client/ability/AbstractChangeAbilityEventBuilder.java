package org.absorb.event.events.client.ability;

import org.absorb.event.cause.EventCause;
import org.absorb.net.Client;
import org.absorb.net.packet.play.incoming.client.ability.PlayerAbilities;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

public class AbstractChangeAbilityEventBuilder implements Builder<ChangeAbilityEvent> {

    private EventCause willCause;
    private EventCause hasCaused;
    private PlayerAbilities abilities;
    private Client client;
    private boolean originalValue;

    public EventCause getWillCause() {
        return this.willCause;
    }

    public AbstractChangeAbilityEventBuilder setWillCause(EventCause willCause) {
        this.willCause = willCause;
        return this;
    }

    public EventCause getHasCaused() {
        return this.hasCaused;
    }

    public AbstractChangeAbilityEventBuilder setHasCaused(EventCause hasCaused) {
        this.hasCaused = hasCaused;
        return this;
    }

    public PlayerAbilities getAbilities() {
        return this.abilities;
    }

    public AbstractChangeAbilityEventBuilder setAbilities(PlayerAbilities abilities) {
        this.abilities = abilities;
        return this;
    }

    public Client getClient() {
        return this.client;
    }

    public AbstractChangeAbilityEventBuilder setClient(Client client) {
        this.client = client;
        return this;
    }

    public boolean getValue() {
        return this.originalValue;
    }

    public AbstractChangeAbilityEventBuilder setValue(boolean originalValue) {
        this.originalValue = originalValue;
        return this;
    }

    @Override
    public @NotNull ChangeAbilityEvent build() {
        return new AbstractChangeAbilityEvent(this);
    }

    @Override
    public @NotNull Builder<ChangeAbilityEvent> reset() {
        this.abilities = null;
        this.hasCaused = null;
        this.willCause = null;
        this.client = null;
        this.originalValue = false;
        return this;
    }

    @Override
    public @NotNull Builder<ChangeAbilityEvent> copy() {
        return new AbstractChangeAbilityEventBuilder()
                .setAbilities(this.abilities)
                .setClient(this.client)
                .setHasCaused(this.hasCaused)
                .setWillCause(this.willCause)
                .setValue(this.originalValue);
    }

    @Override
    public AbstractChangeAbilityEventBuilder from(ChangeAbilityEvent value) {
        this.abilities = value.getAbility();
        this.originalValue = value.getChangingTo();
        this.client = value.getClient();
        this.willCause = value.willCause();
        this.hasCaused = value.hasCaused();
        return this;
    }
}
