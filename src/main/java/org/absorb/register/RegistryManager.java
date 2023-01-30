package org.absorb.register;

import org.absorb.block.BlockTag;
import org.absorb.block.state.BlockState;
import org.absorb.block.type.BlockType;
import org.absorb.inventory.item.ItemType;
import org.absorb.inventory.item.data.StackDataKey;
import org.absorb.inventory.recipe.Recipe;
import org.absorb.register.registry.MemoryBuilderRegistry;
import org.absorb.register.registry.Registry;
import org.absorb.utils.Identifiable;
import org.absorb.utils.NetworkIdentifiable;
import org.absorb.world.biome.Biome;
import org.absorb.world.type.WorldType;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.LinkedTransferQueue;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegistryManager {

	private final Collection<Registry<WorldType>> worldTypes = new LinkedTransferQueue<>();
	private final Collection<Registry<Biome>> biomes = new LinkedTransferQueue<>();
	private final LinkedTransferQueue<Registry<BlockType>> blockTypes = new LinkedTransferQueue<>();
	private final Collection<Registry<ItemType>> itemTypes = new LinkedTransferQueue<>();
	private final Collection<Registry<? extends StackDataKey<?, ?>>> stackDataKey = new LinkedTransferQueue<>();
	private final Collection<Registry<Recipe>> recipes = new LinkedTransferQueue<>();
	private final Collection<Registry<BlockTag>> blockTags = new LinkedTransferQueue<>();
	private boolean haveBlockStatesBeenInit;

	public RegistryManager() {
		init();
	}

	private void init() {
		worldTypes.addAll(RegistryManager.getVanillaValues(WorldType.class)
				.stream()
				.map(MemoryBuilderRegistry::of)
				.collect(Collectors.toSet()));
		biomes.addAll(RegistryManager.getVanillaValues(Biome.class)
				.stream()
				.map(MemoryBuilderRegistry::of)
				.collect(Collectors.toSet()));
		stackDataKey.addAll(RegistryManager
				.getVanillaValues(StackDataKey.class)
				.stream()
				.map(data -> (StackDataKey<?, ?>) data)
				.map(MemoryBuilderRegistry::of)
				.collect(Collectors.toUnmodifiableSet()));
		this.itemTypes.addAll(RegistryManager.getVanillaRegisters(ItemType.class));
		this.blockTypes.addAll(RegistryManager.getVanillaRegisters(BlockType.class));
		new Thread(this::initBlockStates).start();
	}

	private void initBlockStates() {
		while (this.blockTypes.hasWaitingConsumer()) {

		}
		Collection<Registry<BlockType>> types =
				new TreeSet<>(Comparator.comparing(type -> type.getResourceKey().asFormatted()));
		types.addAll(this.blockTypes);
		int i = 0;
		for (Registry<BlockType> type : types) {
			BlockType bType = type.get();
			bType.setMinimumBlockState(i);
			i = i + bType.getBlockStates().size();
		}
		this.haveBlockStatesBeenInit = true;
	}

	public boolean isReady() {
		return this.haveBlockStatesBeenInit;
	}

	public Collection<Registry<BlockType>> getBlockTypes() {
		return Collections.unmodifiableCollection(this.blockTypes);
	}

	public Registry<BlockType> getBlockType(@NotNull AbsorbKey key) {
		return this.get(key, this.blockTypes);
	}

	public Stream<BlockState> getBlockStates() {
		return this.blockTypes.parallelStream()
				.flatMap(type -> type.get().getBlockStates().parallelStream());
	}

	public Collection<Registry<ItemType>> getItemTypes() {
		return Collections.unmodifiableCollection(this.itemTypes);
	}

	public Registry<ItemType> getItemType(@NotNull AbsorbKey key) {
		return this.get(key, this.itemTypes);
	}

	public ItemType getItemTypeWithNetworkId(int id) {
		return this.get(id, this.itemTypes);
	}

	public Registry<BlockTag> getBlockTag(@NotNull AbsorbKey key) {
		return this.get(key, this.blockTags);
	}

	public Collection<Registry<BlockTag>> getBlockTags() {
		return Collections.unmodifiableCollection(this.blockTags);
	}

	public Collection<Registry<? extends Recipe>> getRecipes() {
		return Collections.unmodifiableCollection(this.recipes);
	}

	public Registry<? extends Recipe> getRecipe(@NotNull AbsorbKey key) {
		return this.get(key, this.recipes);
	}

	public Collection<Registry<WorldType>> getWorldTypes() {
		return Collections.unmodifiableCollection(this.worldTypes);
	}

	public Registry<WorldType> getWorldType(@NotNull AbsorbKey key) {
		return this.get(key, this.getWorldTypes());
	}

	public Collection<Registry<Biome>> getBiomes() {
		return Collections.unmodifiableCollection(this.biomes);
	}

	public Registry<Biome> getBiome(@NotNull AbsorbKey key) {
		return this.get(key, this.getBiomes());
	}

	private <T extends Identifiable, R extends Registry<T>> R get(@NotNull AbsorbKey key, Collection<R> collection) {
		return collection.stream()
				.filter(registry -> registry.getResourceKey().equals(key))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("Unknown key of " + key.asFormatted()));
	}

	private <T extends NetworkIdentifiable, R extends Registry<T>> T get(int id, Collection<R> collection) {
		return collection.parallelStream()
				.map(Supplier::get)
				.filter(regId -> regId.getNetworkId() == id)
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("Unknown id of " + id));
	}

	public static <T extends Identifiable> Set<Registry<T>> getVanillaRegisters(Class<T> classType) {
		return getVanillaValues(classType, Registry.class).parallelStream()
				.map(reg -> (Registry<T>) reg)
				.collect(Collectors.toSet());
	}

	public static <T> Set<T> getVanillaValues(Class<T> classType) {
		return getVanillaValues(classType, classType);
	}

	public static <T> Set<T> getVanillaValues(Class<?> classType, Class<T> asClass) {
		Typed t = classType.getAnnotation(Typed.class);
		if (t == null) {
			throw new IllegalArgumentException("Provided class of " + classType.getSimpleName() + " is not annotated"
                    + " " +
					"with @Typed");
		}
		return Arrays
				.stream(t.getTypesClass().getDeclaredFields())
				.filter(field -> Modifier.isStatic(field.getModifiers()))
				.filter(field -> Modifier.isPublic(field.getModifiers()))
				.filter(field -> Modifier.isFinal(field.getModifiers()))
				.filter(field -> asClass.isAssignableFrom(field.getType()))
				.map(field -> {
					try {
						return (T) field.get(null);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
						//noinspection ReturnOfNull
						return null;
					}
				})
				.filter(Objects::nonNull)
				.collect(Collectors.toUnmodifiableSet());
	}

}
