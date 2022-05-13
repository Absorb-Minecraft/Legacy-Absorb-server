package org.absorb.utils.colllection;

import java.util.Collection;
import java.util.Iterator;

public class ConnectedIterator<T> implements Iterator<T> {

    private final Iterator<Collection<T>> collectionIterator;
    private Iterator<T> target;

    ConnectedIterator(ConnectedCollection<T> collection) {
        this.collectionIterator = collection.getConnected().iterator();
    }

    @Override
    public boolean hasNext() {
        if (target==null && collectionIterator.hasNext()) {
            target = collectionIterator.next().iterator();
        }
        if (target==null) {
            return false;
        }
        if (target.hasNext()) {
            return true;
        }
        return this.collectionIterator.hasNext();
    }

    @Override
    public T next() {
        if (target==null && collectionIterator.hasNext()) {
            target = collectionIterator.next().iterator();
        }
        if (target==null) {
            throw new IndexOutOfBoundsException("No more next");
        }
        if (target.hasNext()) {
            return target.next();
        }
        if (this.collectionIterator.hasNext()) {
            this.target = this.collectionIterator.next().iterator();
            return this.target.next();
        }
        throw new IndexOutOfBoundsException("No more next");

    }
}
