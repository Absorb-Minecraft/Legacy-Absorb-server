package org.absorb.event.events.client.ability;

import org.absorb.event.combine.AwaitingEvent;
import org.absorb.event.events.CancelableEvent;
import org.absorb.event.events.ClientEvent;
import org.absorb.net.packet.play.incoming.client.ability.PlayerAbilities;

public interface ChangeAbilityEvent extends ClientEvent, CancelableEvent, AwaitingEvent {

    PlayerAbilities getAbility();

    boolean getChangingTo();

    void setChangingTo(boolean value);

    boolean getChangingFrom();
}
