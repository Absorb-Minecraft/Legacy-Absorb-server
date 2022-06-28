package org.absorb.net.packet.play.incoming.client.settings;

import org.absorb.entity.living.human.ChatMode;
import org.absorb.entity.living.human.Hand;
import org.absorb.entity.living.human.SkinParts;
import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketBuilder;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;
import java.util.*;

public class IncomingClientSettingsPacketBuilder implements IncomingPacketBuilder<IncomingClientSettingsPacket> {

    private Locale locale;
    private byte viewDistance;
    private ChatMode chatMode;
    private boolean chatColorEnabled;
    private final Set<SkinParts> parts = EnumSet.noneOf(SkinParts.class);
    private Hand mainHand;
    private boolean showOnList;

    public Locale getLocale() {
        return this.locale;
    }

    public IncomingClientSettingsPacketBuilder setLocale(Locale locale) {
        this.locale = locale;
        return this;
    }

    public byte getViewDistance() {
        return this.viewDistance;
    }

    public IncomingClientSettingsPacketBuilder setViewDistance(byte viewDistance) {
        this.viewDistance = viewDistance;
        return this;
    }

    public ChatMode getChatMode() {
        return this.chatMode;
    }

    public IncomingClientSettingsPacketBuilder setChatMode(ChatMode chatMode) {
        this.chatMode = chatMode;
        return this;
    }

    public boolean isChatColorEnabled() {
        return this.chatColorEnabled;
    }

    public IncomingClientSettingsPacketBuilder setChatColorEnabled(boolean chatColorEnabled) {
        this.chatColorEnabled = chatColorEnabled;
        return this;
    }

    public Set<SkinParts> getParts() {
        return this.parts;
    }

    public IncomingClientSettingsPacketBuilder addParts(Collection<SkinParts> parts){
        this.parts.addAll(parts);
        return this;
    }

    public Hand getMainHand() {
        return this.mainHand;
    }

    public IncomingClientSettingsPacketBuilder setMainHand(Hand mainHand) {
        this.mainHand = mainHand;
        return this;
    }

    public boolean isShowOnList() {
        return this.showOnList;
    }

    public IncomingClientSettingsPacketBuilder setShowOnList(boolean showOnList) {
        this.showOnList = showOnList;
        return this;
    }

    @Override
    public PacketBuilder<IncomingClientSettingsPacket> from(ByteBuffer packetBytes) {
        NetEntryData<String> localeString = NetSerializers.STRING.read(0, packetBytes);
        NetEntryData<Byte> viewDistance = NetSerializers.BYTE.read(localeString.endingPosition(), packetBytes);
        NetEntryData<Integer> chatModeId = NetSerializers.VAR_INTEGER.read(viewDistance.endingPosition(), packetBytes);
        NetEntryData<Boolean> chatColoursEnabled = NetSerializers.BOOLEAN.read(chatModeId.endingPosition(), packetBytes);
        NetEntryData<Byte> skinPartsId = NetSerializers.BYTE.read(chatColoursEnabled.endingPosition(), packetBytes);
        NetEntryData<Integer> mainHandId = NetSerializers.VAR_INTEGER.read(skinPartsId.endingPosition(), packetBytes);
        NetEntryData<Boolean> textFiltering = NetSerializers.BOOLEAN.read(mainHandId.endingPosition(), packetBytes);
        NetEntryData<Boolean> showOnList = NetSerializers.BOOLEAN.read(textFiltering.endingPosition(), packetBytes);

        this.locale = Locale.forLanguageTag(localeString.value());
        this.viewDistance = viewDistance.value();
        this.chatMode = ChatMode.fromNetworkId(chatModeId.value());
        this.chatColorEnabled = chatColoursEnabled.value();
        this.mainHand = Hand.fromNetworkId(mainHandId.value());
        this.showOnList = showOnList.value();
        return this;
    }

    @Override
    public @NotNull IncomingClientSettingsPacket build() {
        return new IncomingClientSettingsPacket(this);
    }

    @Override
    public @NotNull IncomingClientSettingsPacketBuilder reset() {
        this.parts.clear();
        this.chatColorEnabled = true;
        this.chatMode = ChatMode.HIDDEN;
        this.locale = Locale.ENGLISH;
        this.mainHand = Hand.RIGHT;
        this.showOnList = true;
        this.viewDistance = 1;
        return this;
    }

    @Override
    public @NotNull IncomingClientSettingsPacketBuilder copy() {
        return new IncomingClientSettingsPacketBuilder()
                .addParts(this.parts)
                .setChatColorEnabled(this.chatColorEnabled)
                .setChatMode(this.chatMode)
                .setLocale(this.locale)
                .setViewDistance(this.viewDistance)
                .setShowOnList(this.showOnList);
    }

    @Override
    public int getId() {
        return IncomingClientSettingsPacket.ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }
}
