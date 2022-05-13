package org.absorb.block.state;

import org.absorb.block.type.AbsorbBlockType;
import org.absorb.state.AbsorbState;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class AbsorbBlockState {

    private final Collection<AbsorbState<?>> states;
    private final AbsorbBlockType type;
    private final int networkId;


    public AbsorbBlockState(AbsorbBlockStateBuilder builder) {
        Collection<AbsorbState<?>> states = builder.getStates();
        if (states==null) {
            states = new HashSet<>();
        }
        this.states = Collections.unmodifiableCollection(states);
        this.type = builder.getType();
        this.networkId = builder.getNetworkId();
    }

    public int getNetworkId() {
        return this.networkId;
    }

    public AbsorbBlockType getType() {
        return this.type;
    }

    public Collection<AbsorbState<?>> getStates() {
        return this.states;
    }

    public FullBlockState asFull() {
        return new FullBlockState(this);
    }
}
