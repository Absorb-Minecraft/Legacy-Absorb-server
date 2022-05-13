package org.absorb.inventory.recipe.shapeless;

import org.absorb.inventory.recipe.Recipe;
import org.absorb.inventory.recipe.RecipeBuilder;
import org.absorb.inventory.slot.Slot;
import org.absorb.inventory.slot.UnknownSlot;
import org.absorb.net.data.ListSerializer;
import org.absorb.net.data.Serializers;
import org.absorb.register.AbsorbKey;
import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

public class ShapelessRecipe implements Recipe {

    public static final String SHAPELESS = "crafting_shapeless";

    private final @NotNull String name;
    private final @NotNull String key;
    private final @NotNull String namespace;
    private final @NotNull String groupName;
    private final @NotNull UnknownSlot result;
    private final Collection<UnknownSlot[]> ingredients = new HashSet<>();

    public ShapelessRecipe(@NotNull ShapelessRecipeBuilder builder) {
        this.key = builder.getKey();
        this.name = builder.getName();
        this.namespace = builder.getNamespace();
        this.groupName = builder.getGroupName();
        this.result = builder.getResult();
        this.ingredients.addAll(builder.getIngredients());
    }

    public @NotNull String getGroupName() {
        return this.groupName;
    }

    public @NotNull UnknownSlot getResult() {
        return this.result;
    }

    public @NotNull Collection<UnknownSlot[]> getIngredients() {
        return Collections.unmodifiableCollection(this.ingredients);
    }

    @Override
    public @NotNull AbsorbKey getType() {
        return new AbsorbKey(Identifiable.MINECRAFT_HOST, SHAPELESS);
    }

    @Override
    public RecipeBuilder<? extends Recipe> toBuilder() {
        return new ShapelessRecipeBuilder()
                .setGroupName(this.groupName)
                .setKey(this.key)
                .addManyIngredients(this.ingredients)
                .setResult(this.result);
    }

    @Override
    public ByteBuffer write() {
        ByteBuffer type = Serializers.RESOURCE_KEY.write(this.getType());
        ByteBuffer id = Serializers.RESOURCE_KEY.write(this.getResourceKey());
        ByteBuffer group = Serializers.STRING.write(this.getGroupName());
        ByteBuffer ingredients = new ListSerializer<>(new ListSerializer<>(Serializers.SLOT))
                .write(this
                        .getIngredients()
                        .parallelStream()
                        .map(i -> Arrays.stream(i).map(slot -> (Slot) slot).collect(Collectors.toList()))
                        .toList());
        ByteBuffer result = Serializers.SLOT.write(this.getResult());

        ByteBuffer ret =
                ByteBuffer.allocate(type.limit() + id.limit() + group.limit() + ingredients.limit() + result.limit());
        ret.put(type);
        ret.put(id);
        ret.put(group);
        ret.put(ingredients);
        ret.put(result);
        return ret;
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
        return this.namespace;
    }
}
