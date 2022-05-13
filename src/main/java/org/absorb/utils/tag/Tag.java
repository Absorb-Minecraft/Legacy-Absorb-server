package org.absorb.utils.tag;

import org.absorb.utils.Identifiable;
import org.absorb.utils.NetworkIdentifiable;

import java.util.Collection;

public interface Tag<T extends NetworkIdentifiable> extends Identifiable {

    Collection<T> getRegistered();



}
