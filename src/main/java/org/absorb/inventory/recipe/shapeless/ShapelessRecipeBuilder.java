package org.absorb.inventory.recipe.shapeless;

import org.absorb.inventory.recipe.RecipeBuilder;
import org.absorb.inventory.slot.Slot;
import org.absorb.inventory.slot.UnknownSlot;
import org.absorb.net.data.NetList;
import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializers;
import org.absorb.register.AbsorbKey;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShapelessRecipeBuilder implements RecipeBuilder<ShapelessRecipe> {

    private String name;
    private String key;
    private String namespace;
    private String groupName;
    private UnknownSlot result;
    private final Set<UnknownSlot[]> ingredients = new HashSet<>();

    public String getName() {
        return this.name;
    }

    public ShapelessRecipeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public ShapelessRecipeBuilder setKey(String key) {
        this.key = key;
        return this;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public ShapelessRecipeBuilder setNamespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public ShapelessRecipeBuilder setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public UnknownSlot getResult() {
        return this.result;
    }

    public ShapelessRecipeBuilder setResult(UnknownSlot result) {
        this.result = result;
        return this;
    }

    public Collection<UnknownSlot[]> getIngredients() {
        return this.ingredients;
    }

    public ShapelessRecipeBuilder addIngredients(UnknownSlot... ingredients) {
        this.ingredients.add(ingredients);
        return this;
    }

    public ShapelessRecipeBuilder addManyIngredients(UnknownSlot[]... ingredients) {
        return this.addManyIngredients(Set.of(ingredients));
    }

    public ShapelessRecipeBuilder addManyIngredients(Collection<UnknownSlot[]> ingredients) {
        this.ingredients.addAll(ingredients);
        return this;
    }

    @Override
    public @NotNull ShapelessRecipe build() {
        return new ShapelessRecipe(this);
    }

    @Override
    public @NotNull Builder<ShapelessRecipe> reset() {
        this.key = null;
        this.groupName = null;
        this.result = null;
        this.ingredients.clear();
        return this;
    }

    @Override
    public @NotNull Builder<ShapelessRecipe> copy() {
        return new ShapelessRecipeBuilder().setGroupName(this.groupName).addManyIngredients(this.ingredients).setKey(this.key).setGroupName(this.groupName);
    }

    @Override
    public RecipeBuilder<ShapelessRecipe> from(ByteBuffer data) {
        NetEntryData<AbsorbKey> type = NetSerializers.RESOURCE_KEY.read(0, data);
        NetEntryData<AbsorbKey> id = NetSerializers.RESOURCE_KEY.read(type.endingPosition(), data);
        NetEntryData<String> groupName = NetSerializers.STRING.read(id.endingPosition(), data);
        NetEntryData<List<List<Slot>>> ingredients =
                new NetList<>(new NetList<>(NetSerializers.SLOT)).read(groupName.endingPosition(), data);
        NetEntryData<Slot> result = NetSerializers.SLOT.read(ingredients.endingPosition(), data);

        if (!id.value().value().equals(ShapelessRecipe.SHAPELESS)) {
            throw new IllegalStateException("Cannot accept type " + id.value().value() + " on Shapeless");
        }

        this.setKey(this.getKey());
        this.setNamespace(this.getNamespace());
        this.setName(this.getName());
        this.setGroupName(groupName.value());
        this.setResult((UnknownSlot) result.value());
        for (List<Slot> slots : ingredients.value()) {
            UnknownSlot[] unknownSlots =
                    slots.stream().map(slot -> (UnknownSlot) slot).toArray(UnknownSlot[]::new);
            this.addIngredients(unknownSlots);
        }

        return this;
    }
}
