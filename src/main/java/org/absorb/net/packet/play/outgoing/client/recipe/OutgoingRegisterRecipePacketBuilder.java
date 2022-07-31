package org.absorb.net.packet.play.outgoing.client.recipe;

import org.absorb.inventory.recipe.Recipe;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class OutgoingRegisterRecipePacketBuilder implements OutgoingPacketBuilder<OutgoingRegisterRecipePacket> {

    private final @NotNull Collection<Recipe> recipes = new HashSet<>();

    public OutgoingRegisterRecipePacketBuilder addRecipes(@NotNull Recipe... recipes) {
        this.addRecipes(Arrays.asList(recipes));
        return this;
    }

    public OutgoingRegisterRecipePacketBuilder addRecipes(@NotNull Collection<? extends Recipe> recipes) {
        this.recipes.addAll(recipes);
        return this;
    }

    public @NotNull Collection<Recipe> getRecipes() {
        return this.recipes;
    }

    @Override
    public @NotNull OutgoingRegisterRecipePacket build() {
        return new OutgoingRegisterRecipePacket(this);
    }

    @Override
    public @NotNull Builder<OutgoingRegisterRecipePacket> from(OutgoingRegisterRecipePacket value) {
        this.recipes.addAll(value.getRecipes());
        return this;
    }

    @Override
    public PacketBuilder<OutgoingRegisterRecipePacket> reset() {
        this.recipes.clear();
        return this;
    }

    @Override
    public PacketBuilder<OutgoingRegisterRecipePacket> copy() {
        return new OutgoingRegisterRecipePacketBuilder().addRecipes(this.recipes);
    }

    @Override
    public int getId() {
        return OutgoingRegisterRecipePacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
