package org.absorb.environment.change;

import org.absorb.environment.Environment;

import java.time.LocalTime;

public class EnvironmentChange implements Comparable<EnvironmentChange> {

    private final Object id;
    private final LocalTime time;
    private final Runnable runnable;
    private final Environment from;

    public EnvironmentChange(Environment from, Object id, Runnable onChange) {
        this(from, id, onChange, LocalTime.now());
    }

    public EnvironmentChange(Environment environment, Object id, Runnable onChange, LocalTime time) {
        this.id = id;
        this.runnable = onChange;
        this.time = time;
        this.from = environment;
    }

    public Object getId() {
        return this.id;
    }

    public Runnable getOnChange() {
        return this.runnable;
    }

    public LocalTime getTime() {
        return this.time;
    }

    public Environment getFrom() {
        return this.from;
    }

    @Override
    public int compareTo(EnvironmentChange o) {
        int comp = this.getFrom().getEnvironmentType().compareTo(o.getFrom().getEnvironmentType());
        if (comp!=0) {
            return comp;
        }
        return this.getTime().compareTo(o.getTime());
    }
}
