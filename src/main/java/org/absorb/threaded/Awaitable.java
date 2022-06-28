package org.absorb.threaded;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Awaitable<T> {

    private final Supplier<T> getter;

    public Awaitable(Supplier<T> getter) {
        this.getter = getter;
    }

    public T await() {
        return this.getter.get();
    }

    public void await(Consumer<T> runner) {
        new Thread(() -> {
            T value = this.getter.get();
            runner.accept(value);
        }).start();
    }

}
