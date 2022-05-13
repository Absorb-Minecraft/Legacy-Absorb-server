package org.absorb.block.state;

import org.absorb.block.type.AbsorbBlockType;
import org.absorb.state.AbsorbState;
import org.absorb.utils.Builder;

import java.util.Collection;
import java.util.HashSet;

public class AbsorbBlockStateBuilder implements Builder<AbsorbBlockState> {

    private Collection<AbsorbState<?>> states;
    private AbsorbBlockType type;
    private Integer networkId;

    public Collection<AbsorbState<?>> getStates() {
        return this.states;
    }

    public AbsorbBlockStateBuilder setStates(Collection<AbsorbState<?>> states) {
        this.states = states;
        return this;
    }

    public AbsorbBlockType getType() {
        return this.type;
    }

    public AbsorbBlockStateBuilder setType(AbsorbBlockType type) {
        this.type = type;
        return this;
    }

    public Integer getNetworkId() {
        return this.networkId;
    }

    public AbsorbBlockStateBuilder setNetworkId(int networkId) {
        this.networkId = networkId;
        return this;
    }

    @Override
    public AbsorbBlockState build() {
        return new AbsorbBlockState(this);
    }

    @Override
    public Builder<AbsorbBlockState> reset() {
        this.states = new HashSet<>();
        this.type = null;
        this.networkId = null;
        return this;
    }

    @Override
    public Builder<AbsorbBlockState> copy() {
        return new AbsorbBlockStateBuilder().setStates(this.getStates()).setNetworkId(this.getNetworkId()).setType(this.getType());
    }
}
