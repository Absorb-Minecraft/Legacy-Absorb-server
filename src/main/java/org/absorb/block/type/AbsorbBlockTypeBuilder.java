package org.absorb.block.type;

import org.absorb.block.BlockTag;
import org.absorb.block.state.AbsorbBlockStateBuilder;
import org.absorb.block.type.properties.BlockTypeProperty;
import org.absorb.block.type.properties.mass.MassProperty;
import org.absorb.block.type.properties.mass.MassType;
import org.absorb.register.AbsorbKey;
import org.absorb.state.AbsorbState;
import org.absorb.utils.Builder;

import java.util.*;

public class AbsorbBlockTypeBuilder implements Builder<AbsorbBlockType> {

    private AbsorbKey item;
    private Collection<BlockTag> tags;
    private Collection<AbsorbBlockStateBuilder> blockStates;
    private AbsorbBlockStateBuilder defaultState;
    private Collection<AbsorbState<?>> propertyStates;
    private String name;
    private String host;
    private String key;
    private Integer networkId;
    private Map<String, BlockTypeProperty> properties = new HashMap<>();

    public AbsorbBlockTypeBuilder addProperty(BlockTypeProperty property) {
        this.properties.put(property.getResourceKey().asFormatted(), property);
        return this;
    }

    public AbsorbBlockTypeBuilder setMass(MassType type) {
        this.addProperty(new MassProperty(type));
        return this;
    }

    public Collection<BlockTypeProperty> getProperties() {
        return this.properties.values();
    }

    public Integer getNetworkId() {
        return this.networkId;
    }

    public AbsorbBlockTypeBuilder setNetworkId(int networkId) {
        this.networkId = networkId;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public AbsorbBlockTypeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getHost() {
        return this.host;
    }

    public AbsorbBlockTypeBuilder setHost(String host) {
        this.host = host;
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public AbsorbBlockTypeBuilder setKey(String key) {
        this.key = key;
        return this;
    }

    public AbsorbKey getItem() {
        return this.item;
    }

    public AbsorbBlockTypeBuilder setItem(AbsorbKey item) {
        this.item = item;
        return this;
    }

    public Collection<BlockTag> getTags() {
        return this.tags;
    }

    public AbsorbBlockTypeBuilder setTags(Collection<BlockTag> tags) {
        this.tags = tags;
        return this;
    }

    public Collection<AbsorbBlockStateBuilder> getBlockStates() {
        return this.blockStates;
    }

    public AbsorbBlockTypeBuilder setBlockStates(Collection<AbsorbBlockStateBuilder> blockStates) {
        this.blockStates = blockStates;
        return this;
    }

    public AbsorbBlockTypeBuilder setBlockStates(AbsorbBlockStateBuilder... blockStates) {
        return this.setBlockStates(List.of(blockStates));
    }

    public AbsorbBlockStateBuilder getDefaultState() {
        return this.defaultState;
    }

    public AbsorbBlockTypeBuilder setDefaultState(AbsorbBlockStateBuilder defaultState) {
        this.defaultState = defaultState;
        return this;
    }

    public Collection<AbsorbState<?>> getPropertyStates() {
        return this.propertyStates;
    }

    public AbsorbBlockTypeBuilder setPropertyStates(Collection<AbsorbState<?>> propertyStates) {
        this.propertyStates = propertyStates;
        return this;
    }

    @Override
    public AbsorbBlockType build() {
        return new AbsorbBlockType(this);
    }

    @Override
    public Builder<AbsorbBlockType> reset() {
        this.blockStates = new HashSet<>();
        this.defaultState = null;
        this.item = null;
        this.tags = new HashSet<>();
        this.propertyStates = new HashSet<>();
        return this;
    }

    @Override
    public Builder<AbsorbBlockType> copy() {
        return new AbsorbBlockTypeBuilder().setBlockStates(this.getBlockStates()).setDefaultState(this.getDefaultState()).setItem(this.getItem()).setTags(this.getTags()).setPropertyStates(this.getPropertyStates());
    }
}
