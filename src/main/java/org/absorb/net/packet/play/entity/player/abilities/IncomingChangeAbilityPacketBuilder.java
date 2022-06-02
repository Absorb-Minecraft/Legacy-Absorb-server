package org.absorb.net.packet.play.entity.player.abilities;

import org.absorb.net.data.Serializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.ByteBuffer;

public class IncomingChangeAbilityPacketBuilder implements IncomingPacketBuilder<IncomingChangeAbilityPacket> {

    private PlayerAbilities ability;

    public IncomingChangeAbilityPacketBuilder setAbility(@Nullable PlayerAbilities ability){
        this.ability = ability;
        return this;
    }

    public PlayerAbilities getAbility(){
        return this.ability;
    }


    @Override
    public PacketBuilder<IncomingChangeAbilityPacket> from(ByteBuffer packetBytes) {
        byte packet = Serializers.BYTE.read(0, packetBytes).value();
        this.ability = PlayerAbilities.getValueOf(packet);
        return this;
    }

    @Override
    public @NotNull IncomingChangeAbilityPacket build() {
        return new IncomingChangeAbilityPacket(this);
    }

    @Override
    public @NotNull IncomingPacketBuilder<IncomingChangeAbilityPacket> reset() {
        this.ability = null;
        return this;
    }

    @Override
    public IncomingPacketBuilder<IncomingChangeAbilityPacket> copy() {
        return new IncomingChangeAbilityPacketBuilder().setAbility(this.ability);
    }

    @Override
    public int getId() {
        return IncomingChangeAbilityPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
