package org.absorb.block.type;

import org.absorb.block.BlockTag;
import org.absorb.block.state.BlockState;
import org.absorb.block.state.BlockStateBuilder;
import org.absorb.block.state.properties.BlockStatePropertyType;
import org.absorb.block.type.properties.BlockTypeProperty;
import org.absorb.block.type.properties.mass.MassProperty;
import org.absorb.block.type.properties.mass.MassType;
import org.absorb.register.AbsorbKey;
import org.absorb.utils.BuildException;
import org.absorb.utils.Builder;
import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class BlockTypeBuilder implements Builder<BlockType> {

    private final Collection<BlockStatePropertyType<?>> propertyStates = new HashSet<>();
    private final Map<String, BlockTypeProperty> properties = new HashMap<>();
    private AbsorbKey item;
    private Collection<BlockTag> tags;
    private Collection<Builder<BlockState>> blockStates;
    private Builder<BlockState> defaultState;
    private String name;
    private String host;
    private String key;
    private Integer networkId;

    public BlockTypeBuilder() {
        reset();
    }

    public BlockTypeBuilder addProperty(BlockTypeProperty property) {
        this.properties.put(property.getResourceKey().asFormatted(), property);
        return this;
    }

    public BlockTypeBuilder addStateProperty(BlockStatePropertyType<?> property) {
        this.propertyStates.add(property);
        return this;
    }

    public MassType getMass() {
        BlockTypeProperty property = this.properties.get(Identifiable.ABSORB_HOST + ":mass_type");
        if (property == null) {
            return null;
        }
        return ((MassProperty) property).get();
    }

    public BlockTypeBuilder setMass(MassType type) {
        this.addProperty(new MassProperty(type));
        return this;
    }

    public Collection<BlockTypeProperty> getProperties() {
        return this.properties.values();
    }

    public Integer getNetworkId() {
        return this.networkId;
    }

    public BlockTypeBuilder setNetworkId(int networkId) {
        this.networkId = networkId;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public BlockTypeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getHost() {
        return this.host;
    }

    public BlockTypeBuilder setHost(String host) {
        this.host = host;
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public BlockTypeBuilder setKey(String key) {
        this.key = key;
        return this;
    }

    public AbsorbKey getItem() {
        return this.item;
    }

    public BlockTypeBuilder setItem(AbsorbKey item) {
        this.item = item;
        return this;
    }

    public BlockTypeBuilder setItem(Identifiable register) {
        return this.setItem(register.getResourceKey());
    }

    public Collection<BlockTag> getTags() {
        return this.tags;
    }

    public BlockTypeBuilder setTags(Collection<BlockTag> tags) {
        this.tags = tags;
        return this;
    }

    public Collection<Builder<BlockState>> getBlockStates() {
        return this.blockStates;
    }

    public BlockTypeBuilder setBlockStates(Collection<Builder<BlockState>> blockStates) {
        this.blockStates = blockStates;
        return this;
    }

    public BlockTypeBuilder setBlockStates(BlockStateBuilder... blockStates) {
        return this.setBlockStates(List.of(blockStates));
    }

    public Builder<BlockState> getDefaultState() {
        return this.defaultState;
    }

    public BlockTypeBuilder setDefaultState(Builder<BlockState> defaultState) {
        this.defaultState = defaultState;
        return this;
    }

    public Collection<BlockStatePropertyType<?>> getPropertyStates() {
        return this.propertyStates;
    }

    public BlockTypeBuilder setPropertyStates(Collection<? extends BlockStatePropertyType<?>> propertyStates) {
        this.propertyStates.clear();
        this.propertyStates.addAll(propertyStates);
        return this;
    }

    @Override
    public BlockType build() {
        try {
            return new BlockType(this);
        } catch (Throwable e) {
            throw new BuildException(new AbsorbKey(this.host, this.key), e);
        }
    }

    @Override
    public Builder<BlockType> reset() {
        this.blockStates = new HashSet<>();
        this.defaultState = null;
        this.item = null;
        this.tags = new HashSet<>();
        this.propertyStates.clear();
        this.key = null;
        this.host = Identifiable.MINECRAFT_HOST;
        this.name = null;
        return this;
    }

    @Override
    public Builder<BlockType> copy() {
        return new BlockTypeBuilder()
                .setBlockStates(this.getBlockStates())
                .setDefaultState(this.getDefaultState())
                .setItem(this.getItem())
                .setTags(this.getTags())
                .setPropertyStates(this.getPropertyStates());
    }

    @Override
    public @NotNull Builder<BlockType> from(BlockType value) {
        this.key = value.getKey();
        this.name = value.getName();
        this.host = value.getHost();
        this.propertyStates.addAll(value.getPropertyStates());
        this.defaultState = new BlockStateBuilder().from(value.getDefaultBlockState());
        this.item = value.getItemKey().orElse(null);
        this.networkId = value.getNetworkId();
        this.tags.addAll(value.getTags());
        this.blockStates.addAll(value
                                        .getBlockStates()
                                        .parallelStream()
                                        .map(bs -> new BlockStateBuilder().from(bs))
                                        .toList());
        return this;
    }
}
