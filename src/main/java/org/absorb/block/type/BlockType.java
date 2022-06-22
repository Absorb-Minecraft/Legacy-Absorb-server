package org.absorb.block.type;

import org.absorb.block.BlockTag;
import org.absorb.block.state.BlockState;
import org.absorb.block.state.BlockStateBuilder;
import org.absorb.block.state.properties.BlockStateProperty;
import org.absorb.block.type.properties.BlockTypeProperty;
import org.absorb.block.type.properties.mass.MassProperty;
import org.absorb.block.type.properties.mass.MassType;
import org.absorb.register.AbsorbKey;
import org.absorb.register.Typed;
import org.absorb.utils.NetworkIdentifiable;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

@Typed(getTypesClass = BlockTypes.class)
public class BlockType implements NetworkIdentifiable {

    private final @NotNull AbsorbKey item;
    private final @NotNull Collection<BlockTag> tags;
    private final @NotNull TreeSet<BlockState> blockStates;
    private Integer minimumBlockState;
    private final @NotNull BlockState defaultState;
    private final @NotNull Collection<BlockStateProperty<?>> propertyStates;
    private final @NotNull String name;
    private final @NotNull String host;
    private final @NotNull String key;
    private final @NotNull Collection<BlockTypeProperty> properties = new HashSet<>();
    private final int networkId;

    public BlockType(@NotNull BlockTypeBuilder builder) {
        BlockStateBuilder defaultStateBuilder;
        if (builder.getKey()==null) {
            throw new RuntimeException("Key is missing");
        }
        if (builder.getHost()==null) {
            throw new RuntimeException("Host is missing");
        }
        if (builder.getDefaultState()==null && (builder.getBlockStates()==null || builder.getBlockStates().isEmpty())) {
            defaultStateBuilder = new BlockStateBuilder();
        } else if (builder.getDefaultState()==null || (builder.getBlockStates()==null || builder.getBlockStates().isEmpty())) {
            throw new RuntimeException("Default state is not set: " + builder.getHost() + ":" + builder.getKey());
        } else {
            defaultStateBuilder = builder.getDefaultState();
        }
        if (builder.getItem()==null) {
            throw new RuntimeException("Block item is missing: " + builder.getHost() + ":" + builder.getKey());
        }
        if (builder.getNetworkId()==null) {
            throw new RuntimeException("NetworkId is missing: " + builder.getHost() + ":" + builder.getKey());
        }
        if (builder.getName()==null) {
            throw new RuntimeException("Name is missing: " + builder.getHost() + ":" + builder.getKey());
        }
        if (builder.getMass()==null) {
            throw new RuntimeException("Mass property missing: " + builder.getHost() + ":" + builder.getKey());
        }
        this.defaultState = defaultStateBuilder.setType(this).build();
        this.item = builder.getItem();
        this.tags = builder.getTags();
        this.blockStates =
                builder.getBlockStates().stream().map(stateBuilder -> {
                    if (stateBuilder.getId()==this.defaultState.getId()) {
                        return this.defaultState;
                    }
                    return stateBuilder.setType(this).build();
                }).collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(BlockState::getId))));

        this.propertyStates = builder.getPropertyStates();
        this.name = builder.getName();
        this.host = builder.getHost();
        this.key = builder.getKey();
        this.networkId = builder.getNetworkId();
        this.properties.addAll(builder.getProperties());
    }

    public int getMinimumNetworkBlockStateId() {
        if (this.minimumBlockState==null) {
            throw new RuntimeException("Register has not registered state ids yet");
        }
        return this.minimumBlockState;
    }

    public void setMinimumBlockState(int minimumBlockState) {
        if (this.minimumBlockState!=null) {
            throw new RuntimeException("Minimum blockstate already registered. This method should not be called");
        }
        this.minimumBlockState = minimumBlockState;
    }

    public MassType getMassType() {
        return this.get(MassProperty.class).orElseThrow(() -> new RuntimeException(
                "Block (" + this.getResourceKey().asFormatted() + ") does not contain Mass property")).get();
    }

    public <T extends BlockTypeProperty> Optional<T> get(Class<T> clazz) {
        return this.properties.parallelStream().filter(clazz::isInstance).findAny().map(prop -> (T) prop);
    }

    public @NotNull AbsorbKey getItemKey() {
        return this.item;
    }

    public @NotNull Collection<BlockTag> getTags() {
        return this.tags;
    }

    public @NotNull Collection<BlockState> getBlockStates() {
        return Collections.unmodifiableCollection(this.blockStates);
    }

    public @NotNull BlockState getDefaultBlockState() {
        return this.defaultState;
    }

    public @NotNull Collection<BlockStateProperty<?>> getPropertyStates() {
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
