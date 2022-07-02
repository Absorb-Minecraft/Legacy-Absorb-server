package org.absorb.net.packet.login.start;

import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.NetProcessors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.OptionalLong;

public class IncomingLoginStartPacket implements IncomingPacket {

    private final @NotNull String username;
    private final @Nullable Long timestamp;
    private final byte[] publicKey;
    private final byte[] publicSign;
    public static final int ID = 0x00;

    public IncomingLoginStartPacket(IncomingLoginStartPacketBuilder builder) {
        this.username = builder.getUsername();
        this.timestamp = builder.getTimestamp();
        byte[] publicKey = builder.getPublicKey();
        if (publicKey == null) {
            publicKey = new byte[0];
        }
        this.publicKey = publicKey;


        byte[] publicSign = builder.getPublicSignature();
        if (publicSign == null) {
            publicSign = new byte[0];
        }
        this.publicSign = publicSign;
    }

    public @NotNull String getUsername() {
        return this.username;
    }

    public OptionalLong getTimestamp() {
        if (this.timestamp == null) {
            return OptionalLong.empty();
        }
        return OptionalLong.of(this.timestamp);
    }

    public byte[] getPublicKey() {
        return this.publicKey;
    }

    public byte[] getPublicSignature() {
        return this.publicSign;
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.LOGIN;
    }

    @Override
    public @NotNull PacketBuilder<? extends Packet> toBuilder() {
        return new IncomingLoginStartPacketBuilder().setUsername(this.username);
    }

    @Override
    public @NotNull <P extends IncomingPacket> NetProcess<P> getProcess() {
        return (NetProcess<P>) NetProcessors.PRE_LOGIN;
    }
}
