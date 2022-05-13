package org.absorb.block.type;

import org.absorb.block.BlockTag;
import org.absorb.block.state.AbsorbBlockState;
import org.absorb.register.AbsorbKey;
import org.absorb.state.AbsorbState;
import org.absorb.utils.NetworkIdentifiable;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AbsorbBlockType implements NetworkIdentifiable {

    private final @NotNull AbsorbKey item;
    private final @NotNull Collection<BlockTag> tags;
    private final @NotNull List<AbsorbBlockState> blockStates;
    private final @NotNull Collection<AbsorbState<?>> propertyStates;
    private final @NotNull String name;
    private final @NotNull String host;
    private final @NotNull String key;
    private final int networkId;


    public AbsorbBlockType(@NotNull AbsorbBlockTypeBuilder builder) {
        if(builder.getDefaultState() == null){
            throw new RuntimeException("Default state is not set");
        }
        if(builder.getBlockStates() == null || builder.getBlockStates().isEmpty()){
            throw new RuntimeException("BlockStates is missing");
        }
        /*if(builder.getItem() == null){
            throw new RuntimeException("Block item is missing");
        }*/
        if(builder.getNetworkId() == null){
            throw new RuntimeException("NetworkId is missing");
        }
        if(builder.getName() == null){
            throw new RuntimeException("Name is missing");
        }
        if(builder.getKey() == null){
            throw new RuntimeException("Key is missing");
        }
        if(builder.getHost() == null){
            throw new RuntimeException("Host is missing");
        }
        AbsorbBlockState defaultState = builder.getDefaultState().setType(this).build();
        this.item = builder.getItem();
        this.tags = builder.getTags();
        this.blockStates =
                builder.getBlockStates().stream().map(stateBuilder -> stateBuilder.setType(this).build()).collect(Collectors.toList());
        this.blockStates.remove(defaultState);
        this.blockStates.set(0, defaultState);
        this.propertyStates = builder.getPropertyStates();
        this.name = builder.getName();
        this.host = builder.getHost();
        this.key = builder.getKey();
        this.networkId = builder.getNetworkId();
    }

    public @NotNull AbsorbKey getItemKey() {
        return this.item;
    }

    public @NotNull Collection<BlockTag> getTags() {
        return this.tags;
    }

    public @NotNull Collection<AbsorbBlockState> getBlockStates() {
        return Collections.unmodifiableCollection(this.blockStates);
    }

    public @NotNull AbsorbBlockState getDefaultBlockState() {
        return this.blockStates.get(0);
    }

    public @NotNull Collection<AbsorbState<?>> getPropertyStates() {
        return Collections.unmodifiableCollection(this.propertyStates);
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    @Override
    public @NotNull String getKey() {
        return this.key;
    }

    @Override
    public @NotNull String getHost() {
        return this.host;
    }

    @Override
    public int getNetworkId() {
        return this.networkId;
    }
}
