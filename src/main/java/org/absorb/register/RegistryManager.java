package org.absorb.register;

import org.absorb.block.BlockTag;
import org.absorb.block.type.AbsorbBlockType;
import org.absorb.inventory.item.ItemType;
import org.absorb.inventory.item.data.StackDataKey;
import org.absorb.inventory.recipe.Recipe;
import org.absorb.register.registry.MemoryRegistry;
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

public class RegistryManager {

    private final Collection<Registry<WorldType>> worldTypes = new LinkedTransferQueue<>();
    private final Collection<Registry<Biome>> biomes = new LinkedTransferQueue<>();
    private final Collection<Registry<AbsorbBlockType>> blockTypes = new LinkedTransferQueue<>();
    private final Collection<Registry<ItemType>> itemTypes = new LinkedTransferQueue<>();
    private final Collection<Registry<? extends StackDataKey<?, ?>>> stackDataKey = new LinkedTransferQueue<>();
    private final Collection<Registry<Recipe>> recipes = new LinkedTransferQueue<>();
    private final Collection<Registry<BlockTag>> blockTags = new LinkedTransferQueue<>();

    public RegistryManager() {
        init();
    }

    private void init() {
        worldTypes.addAll(RegistryManager.getVanillaValues(WorldType.class).stream().map(MemoryRegistry::new).collect(Collectors.toSet()));
        biomes.addAll(RegistryManager.getVanillaValues(Biome.class).stream().map(MemoryRegistry::new).collect(Collectors.toSet()));
        stackDataKey.addAll(RegistryManager
                .getVanillaValues(StackDataKey.class)
                .stream()
                .map(data -> (StackDataKey<?, ?>) data)
                .map(MemoryRegistry::new)
                .collect(Collectors.toUnmodifiableSet()));
    }

    public Collection<Registry<AbsorbBlockType>> getBlockTypes() {
        return Collections.unmodifiableCollection(this.blockTypes);
    }

    public Registry<AbsorbBlockType> getBlockType(@NotNull AbsorbKey key) {
        return this.get(key, this.blockTypes);
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
        return collection.stream().filter(registry -> registry.getResourceKey().equals(key)).findAny().orElseThrow(() -> new IllegalArgumentException("Unknown key of " + key.asFormatted()));
    }

    private <T extends NetworkIdentifiable, R extends Registry<T>> T get(int id, Collection<R> collection) {
        return collection.parallelStream().map(Supplier::get).filter(regId -> regId.getNetworkId()==id).findAny().orElseThrow(() -> new IllegalArgumentException("Unknown id of " + id));
    }

    public static <T> Set<T> getVanillaValues(Class<T> classType) {
        Typed t = classType.getAnnotation(Typed.class);
        if (t==null) {
            throw new IllegalArgumentException("Provided class of " + classType.getSimpleName() + " is not annotated " +
                    "with @Typed");
        }
        return Arrays
                .stream(t.getTypesClass().getDeclaredFields())
                .filter(field -> Modifier.isStatic(field.getModifiers()))
                .filter(field -> Modifier.isPublic(field.getModifiers()))
                .filter(field -> Modifier.isFinal(field.getModifiers()))
                .filter(field -> classType.isAssignableFrom(field.getType()))
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
