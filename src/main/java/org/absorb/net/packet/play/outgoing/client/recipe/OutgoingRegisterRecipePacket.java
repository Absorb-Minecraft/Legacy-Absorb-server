package org.absorb.net.packet.play.outgoing.client.recipe;

import me.nullicorn.nedit.NBTOutputStream;
import org.absorb.AbsorbManagers;
import org.absorb.inventory.recipe.Recipe;
import org.absorb.net.Client;
import org.absorb.net.data.NetUtils;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.absorb.register.registry.Registry;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class OutgoingRegisterRecipePacket implements OutgoingPacket {

    public static final int ID = 0x67;

    private final Set<Recipe> recipes = new HashSet<>();

    public OutgoingRegisterRecipePacket(@NotNull OutgoingRegisterRecipePacketBuilder builder) {
        this.recipes.addAll(builder.getRecipes());
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }

    @Override
    public @NotNull OutgoingPacketBuilder<? extends Packet> toBuilder() {
        return new OutgoingRegisterRecipePacketBuilder().addRecipes(this.recipes);
    }

    @Override
    public ByteBuffer toBytes(@NotNull Client stream) {
        Collection<Registry<? extends Recipe>> recipes = AbsorbManagers.getRegistryManager().getRecipes();
        try {
            ByteArrayOutputStream baOs = new ByteArrayOutputStream();


            NBTOutputStream nbtOs = new NBTOutputStream(baOs, false);
            nbtOs.write(NetSerializers.VAR_INTEGER.write(recipes.size()).array());
            for (Registry<? extends Recipe> registry : recipes) {
                Recipe recipe = registry.get();
                nbtOs.write(recipe.write().array());
            }
            return NetUtils.createPacket(ID, ByteBuffer.wrap(baOs.toByteArray()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
