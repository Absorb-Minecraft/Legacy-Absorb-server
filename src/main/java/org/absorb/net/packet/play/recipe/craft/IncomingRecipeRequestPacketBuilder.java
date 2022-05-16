package org.absorb.net.packet.play.recipe.craft;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.Serializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.register.AbsorbKey;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class IncomingRecipeRequestPacketBuilder implements IncomingPacketBuilder<IncomingRecipeRequestPacket> {

    private byte windowId;
    private AbsorbKey recipe;
    private boolean makeAll;

    public byte getWindowId() {
        return this.windowId;
    }

    public IncomingRecipeRequestPacketBuilder setWindowId(byte windowId) {
        this.windowId = windowId;
        return this;
    }

    public AbsorbKey getRecipe() {
        return this.recipe;
    }

    public IncomingRecipeRequestPacketBuilder setRecipe(AbsorbKey recipe) {
        this.recipe = recipe;
        return this;
    }

    public boolean isMakeAll() {
        return this.makeAll;
    }

    public IncomingRecipeRequestPacketBuilder setMakeAll(boolean makeAll) {
        this.makeAll = makeAll;
        return this;
    }

    @Override
    public PacketBuilder<IncomingRecipeRequestPacket> from(ByteBuffer packetBytes) {
        NetEntryData<Byte> windowId = Serializers.BYTE.read(0, packetBytes);
        NetEntryData<AbsorbKey> recipe = Serializers.RESOURCE_KEY.read(windowId.endingPosition(), packetBytes);
        NetEntryData<Boolean> makeAll = Serializers.BOOLEAN.read(recipe.endingPosition(), packetBytes);

        this.makeAll = makeAll.value();
        this.recipe = recipe.value();
        this.windowId = windowId.value();
        return this;
    }

    @Override
    public @NotNull IncomingRecipeRequestPacket build() {
        return new IncomingRecipeRequestPacket(this);
    }

    @Override
    public IncomingPacketBuilder<IncomingRecipeRequestPacket> reset() {
        this.windowId = 0;
        this.makeAll = false;
        this.recipe = null;
        return this;
    }

    @Override
    public IncomingPacketBuilder<IncomingRecipeRequestPacket> copy() {
        return new IncomingRecipeRequestPacketBuilder().setRecipe(this.recipe).setMakeAll(this.makeAll).setWindowId(this.windowId);
    }

    @Override
    public int getId() {
        return IncomingRecipeRequestPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
