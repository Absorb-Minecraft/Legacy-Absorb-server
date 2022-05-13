package org.absorb.utils.colllection;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedTransferQueue;
import java.util.stream.Collectors;

public class ConnectedCollection<T> implements Collection<T> {

    private LinkedTransferQueue<Collection<T>> transferQueue = new LinkedTransferQueue<>();

    public ConnectedCollection(Collection<T> collection) {
        this.transferQueue.add(collection);
    }

    public ConnectedCollection(Collection<T>... collection) {
        for (Collection<T> collect : collection) {
            transferQueue.add(collect);
        }
    }

    LinkedTransferQueue<Collection<T>> getConnected() {
        return this.transferQueue;
    }

    public void addConnection(Collection<T> collection) {
        this.transferQueue.add(collection);
    }

    public void removeConnection(Collection<T> collection) {
        this.transferQueue.remove(collection);
    }

    @Override
    public int size() {
        return this.transferQueue.parallelStream().mapToInt(Collection::size).sum();
    }

    @Override
    public boolean isEmpty() {
        return this.transferQueue.parallelStream().allMatch(Collection::isEmpty);
    }

    @Override
    public boolean contains(Object o) {
        return this.transferQueue.parallelStream().anyMatch(c -> c.contains(o));
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new ConnectedIterator<>(this);
    }

    @Override
    public @NotNull Object[] toArray() {
        return this.transferQueue.parallelStream().flatMap(Collection::parallelStream).toArray();
    }

    @NotNull
    @Override
    public <T1> T1[] toArray(@NotNull T1[] a) {
        return this.transferQueue.parallelStream().flatMap(Collection::parallelStream).collect(Collectors.toUnmodifiableSet()).toArray(a);
    }

    @Override
    @Deprecated
    public boolean add(T t) {
        throw new RuntimeException("Cannot add though ConntectedCollection");
    }

    @Override
    public boolean remove(Object o) {
        boolean check = false;
        for (Collection<T> collection : this.transferQueue) {
            if (collection.remove(o)) {
                check = true;
            }
        }
        return check;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        Map<Object, Boolean> map = c.parallelStream().collect(Collectors.toMap(v -> (Object) v, v -> false));
        for (Object con : c) {
            for (Collection<T> collection : this.transferQueue) {
                if (collection.contains(con)) {
                    map.replace(con, true);
                }
            }
        }
        return map.values().parallelStream().allMatch(v -> v);
    }

    @Override
    @Deprecated
    public boolean addAll(@NotNull Collection<? extends T> c) {
        throw new RuntimeException("Cannot add though ConntectedCollection");
    }

    @Override
    @Deprecated
    public boolean removeAll(@NotNull Collection<?> c) {
        throw new RuntimeException("Cannot add though ConntectedCollection");
    }

    @Override
    @Deprecated
    public boolean retainAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (Collection<T> collection : this.transferQueue) {
            collection.clear();
        }
    }
}
