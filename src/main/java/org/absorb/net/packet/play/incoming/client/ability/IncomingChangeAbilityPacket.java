package org.absorb.net.packet.play.incoming.client.ability;

import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.play.entity.player.ability.change.ChangeAbilityProcessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class IncomingChangeAbilityPacket implements IncomingPacket {

    public static final int ID = 0x1B;

    private final @Nullable PlayerAbilities ability;

    public IncomingChangeAbilityPacket(IncomingChangeAbilityPacketBuilder packet) {
        this.ability = packet.getAbility();
    }

    public @NotNull Optional<PlayerAbilities> getAbility() {
        return Optional.ofNullable(this.ability);
    }

    @Override
    public @NotNull <P extends IncomingPacket> NetProcess<P> getProcess() {
        return (NetProcess<P>) new ChangeAbilityProcessor();
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
        return new IncomingChangeAbilityPacketBuilder().setAbility(this.ability);
    }
}
