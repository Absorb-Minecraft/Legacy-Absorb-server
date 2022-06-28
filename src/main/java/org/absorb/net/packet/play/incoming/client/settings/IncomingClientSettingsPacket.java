package org.absorb.net.packet.play.incoming.client.settings;

import org.absorb.entity.living.human.ChatMode;
import org.absorb.entity.living.human.Hand;
import org.absorb.entity.living.human.SkinParts;
import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.processor.NetProcess;
import org.absorb.net.processor.play.settings.IncomingClientSettingsProcessor;
import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;
import java.util.Locale;

public class IncomingClientSettingsPacket implements IncomingPacket {

    private final @NotNull Locale locale;
    private final byte viewDistance;
    private final @NotNull ChatMode chatMode;
    private final boolean chatColorEnabled;
    private final @NotNull EnumSet<SkinParts> parts;
    private final @NotNull Hand mainHand;
    private final boolean showOnList;

    public static final int ID = 0x07;

    public IncomingClientSettingsPacket(@NotNull IncomingClientSettingsPacketBuilder builder) {
        this.locale = builder.getLocale();
        this.viewDistance = builder.getViewDistance();
        this.chatMode = builder.getChatMode();
        this.chatColorEnabled = builder.isChatColorEnabled();
        this.parts = EnumSet.copyOf(builder.getParts());
        this.mainHand = builder.getMainHand();
        this.showOnList = builder.isShowOnList();
    }

    public @NotNull Locale getLocale() {
        return this.locale;
    }

    public byte getViewDistance() {
        return this.viewDistance;
    }

    public @NotNull ChatMode getChatMode() {
        return this.chatMode;
    }

    public boolean isChatColorEnabled() {
        return this.chatColorEnabled;
    }

    public @NotNull EnumSet<SkinParts> getParts() {
        return this.parts;
    }

    public @NotNull Hand getMainHand() {
        return this.mainHand;
    }

    public boolean isShowOnList() {
        return this.showOnList;
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
        return new IncomingClientSettingsPacketBuilder()
                .setShowOnList(this.showOnList)
                .setViewDistance(this.viewDistance)
                .setLocale(this.locale)
                .setChatMode(this.chatMode)
                .setChatColorEnabled(this.chatColorEnabled)
                .setMainHand(this.mainHand);
    }

    @Override
    public @NotNull <P extends IncomingPacket> NetProcess<P> getProcess() {
        return (NetProcess<P>) new IncomingClientSettingsProcessor();
    }
}
