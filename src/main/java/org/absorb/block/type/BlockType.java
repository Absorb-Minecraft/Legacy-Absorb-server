package org.absorb.block.type;

import org.absorb.block.BlockTag;
import org.absorb.block.state.BlockState;
import org.absorb.block.state.BlockStateBuilder;
import org.absorb.block.state.properties.BlockStateProperty;
import org.absorb.block.state.properties.BlockStatePropertyType;
import org.absorb.block.state.properties.type.FixedBlockStatePropertyType;
import org.absorb.block.type.properties.BlockTypeProperty;
import org.absorb.block.type.properties.mass.MassProperty;
import org.absorb.block.type.properties.mass.MassType;
import org.absorb.register.AbsorbKey;
import org.absorb.register.Typed;
import org.absorb.utils.NetworkIdentifiable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

@Typed(getTypesClass = BlockTypes.class)
public class BlockType implements NetworkIdentifiable {

    private final @Nullable AbsorbKey item;
    private final @NotNull Collection<BlockTag> tags;
    private final @NotNull BlockState defaultState;
    private final @NotNull Collection<BlockStatePropertyType<?>> propertyStates = new ArrayList<>();
    private final @NotNull String name;
    private final @NotNull String host;
    private final @NotNull String key;
    private final @NotNull Collection<BlockTypeProperty> properties = new HashSet<>();
    private final int networkId;
    private final @NotNull Collection<BlockState> blockStates = new HashSet<>();
    private Integer minimumBlockState;

    public BlockType(@NotNull BlockTypeBuilder builder) {
        BlockStateBuilder defaultStateBuilder;
        this.propertyStates.addAll(builder.getPropertyStates());
        if (builder.getKey() == null) {
            throw new RuntimeException("Key is missing");
        }
        if (builder.getHost() == null) {
            throw new RuntimeException("Host is missing");
        }
        if (!builder.getPropertyStates().isEmpty() && builder.getBlockStates().isEmpty()) {
            this.blockStates.addAll(this.buildStates());
        }

        if (builder.getDefaultState() == null && (builder.getBlockStates() == null || builder
                .getBlockStates()
                .isEmpty())) {
            defaultStateBuilder = new BlockStateBuilder();
        } else if (builder.getDefaultState() == null || (builder.getBlockStates() == null || builder
                .getBlockStates()
                .isEmpty())) {
            throw new RuntimeException("Default state is not set: " + builder.getHost() + ":" + builder.getKey());
        } else {
            defaultStateBuilder = builder.getDefaultState();
        }
        if (builder.getNetworkId() == null) {
            throw new RuntimeException("NetworkId is missing: " + builder.getHost() + ":" + builder.getKey());
        }
        if (builder.getName() == null) {
            throw new RuntimeException("Name is missing: " + builder.getHost() + ":" + builder.getKey());
        }
        if (builder.getMass() == null) {
            throw new RuntimeException("Mass property missing: " + builder.getHost() + ":" + builder.getKey());
        }
        this.defaultState = defaultStateBuilder.setType(this).build();
        this.item = builder.getItem();
        this.tags = builder.getTags();
        this.blockStates.addAll(builder
                                        .getBlockStates()
                                        .parallelStream()
                                        .map(bsBuilder -> bsBuilder.setType(this).build())
                                        .toList());
        this.name = builder.getName();
        this.host = builder.getHost();
        this.key = builder.getKey();
        this.networkId = builder.getNetworkId();
        this.properties.addAll(builder.getProperties());
    }

    public int getMinimumNetworkBlockStateId() {
        if (this.minimumBlockState == null) {
            throw new RuntimeException("Register has not registered state ids yet");
        }
        return this.minimumBlockState;
    }

    public void setMinimumBlockState(int minimumBlockState) {
        if (this.minimumBlockState != null) {
            throw new RuntimeException("Minimum blockstate already registered. This method should not be called");
        }
        this.minimumBlockState = minimumBlockState;
    }

    public MassType getMassType() {
        return this
                .get(MassProperty.class)
                .orElseThrow(() -> new RuntimeException(
                        "Block (" + this.getResourceKey().asFormatted() + ") does not contain Mass property"))
                .get();
    }

    public <T extends BlockTypeProperty> Optional<T> get(Class<T> clazz) {
        return this.properties.parallelStream().filter(clazz::isInstance).findAny().map(prop -> (T) prop);
    }

    public @NotNull Optional<AbsorbKey> getItemKey() {
        return Optional.ofNullable(this.item);
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

    public @NotNull Collection<BlockStatePropertyType<?>> getPropertyStates() {
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

    private Collection<BlockState> buildStates() {
        List<BlockStatePropertyType<?>> properties = new ArrayList<>(this.getPropertyStates());
        return this.buildStates(0, 0, properties);
    }

    private Collection<BlockState> buildStates(int current, int index, List<BlockStatePropertyType<?>> types,
                                               BlockStateProperty<?>... currentValues) {
        BlockStatePropertyType<?> propertyType = types.get(current);
        if (propertyType instanceof FixedBlockStatePropertyType<?> enumPropertyType) {
            return this.buildStateFromFixed(current, index, types, enumPropertyType, currentValues);
        }
        throw new RuntimeException("Unknown state type of " + propertyType.getClass().getName());

    }

    private <T> Collection<BlockState> buildStateFromFixed(int current, int index,
                                                           List<BlockStatePropertyType<?>> types,
                                                           FixedBlockStatePropertyType<?> type,
                                                           BlockStateProperty<?>... currentValues) {
        Collection<BlockState> states = new ArrayList<>();
        FixedBlockStatePropertyType<T> typedPropertyType = (FixedBlockStatePropertyType<T>) type;
        for (T value : typedPropertyType.getValues()) {
            Collection<BlockStateProperty<?>> propertiesCollection = new ArrayList<>(Arrays.asList(currentValues));
            propertiesCollection.add(typedPropertyType.withValue(value));
            if (current + 1 == types.size()) {
                states.add(new BlockStateBuilder()
                                   .setType(this)
                                   .setId(index)
                                   .setProperties(propertiesCollection)
                                   .build());
                index++;
                continue;
            }
            Collection<BlockState> toAddStates = this.buildStates(current + 1,
                                                                  index,
                                                                  types,
                                                                  propertiesCollection.toArray(new BlockStateProperty[0]));
            states.addAll(toAddStates);
            index = index + toAddStates.size();
        }
        return states;
    }
}
