package org.absorb.net.packet.play.incoming.client.recipe;

import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.play.recipe.request.RecipeRequestProcessor;
import org.absorb.register.AbsorbKey;
import org.jetbrains.annotations.NotNull;

public class IncomingRecipeRequestPacket implements IncomingPacket {

    public static final int ID = 0x18;

    private final byte windowId;
    private final @NotNull AbsorbKey recipe;
    private final boolean makeAll;

    public IncomingRecipeRequestPacket(IncomingRecipeRequestPacketBuilder builder) {
        this.makeAll = builder.isMakeAll();
        this.recipe = builder.getRecipe();
        this.windowId = builder.getWindowId();
    }

    public byte getWindowId() {
        return this.windowId;
    }

    public @NotNull AbsorbKey getRecipe() {
        return this.recipe;
    }

    public boolean isMakeAll() {
        return this.makeAll;
    }

    @Override
    public @NotNull <P extends IncomingPacket> NetProcess<P> getProcess() {
        return (NetProcess<P>) new RecipeRequestProcessor();
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
    public @NotNull PacketBuilder<? extends Packet> toBuilder() {
        return new IncomingRecipeRequestPacketBuilder().setRecipe(this.recipe).setWindowId(this.windowId).setMakeAll(this.makeAll);
    }
}
