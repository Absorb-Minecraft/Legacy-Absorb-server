package org.absorb.event.events;

import org.absorb.event.Event;
import org.absorb.net.Client;

public interface ClientEvent extends Event {

    Client getClient();
}
