package org.absorb.entity;

public interface EntityEffect<E extends Entity> {

    byte getStatusCode();

    Class<E> getTargetEntityClass();
}
