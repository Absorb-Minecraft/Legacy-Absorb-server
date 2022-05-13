package org.absorb.state;

public class AbsorbState<V> {

    private final AbsorbStateType<V> type;
    private final V value;

    public AbsorbState(AbsorbStateType<V> type, V value) {
        this.type = type;
        this.value = value;
    }

    public AbsorbStateType<V> getType() {
        return this.type;
    }

    public V getValue() {
        return this.value;
    }
}
