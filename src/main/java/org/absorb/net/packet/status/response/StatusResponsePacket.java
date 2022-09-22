package org.absorb.net.packet.status.response;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.absorb.net.Client;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.jackson.FieldValueSeparatorStyle;
import org.spongepowered.configurate.jackson.JacksonConfigurationLoader;

import java.nio.ByteBuffer;

public class StatusResponsePacket implements OutgoingPacket {

    private final int protocolVersion;
    private final String nameVersion;
    private final Component descriptionText;
    private final int currentPlayers;
    private final int maxPlayers;
    private final boolean previewChat;
    private final boolean enforceSecureChat;
    public static final int ID = 0x00;

    public StatusResponsePacket(StatusResponsePacketBuilder builder) {
        this.currentPlayers = builder.getCurrentPlayers();
        this.maxPlayers = builder.getMaxPlayers();

        this.descriptionText = builder.getDescription();
        this.nameVersion = builder.getVersionName();
        this.protocolVersion = builder.getVersionProtocol();
        this.previewChat = builder.isPreviewChat();
        this.enforceSecureChat = builder.isEnforceSecureChat();
    }

    public int getProtocolVersion() {
        return this.protocolVersion;
    }

    public String getNameVersion() {
        return this.nameVersion;
    }

    public Component getDescriptionText() {
        return this.descriptionText;
    }

    public int getCurrentPlayers() {
        return this.currentPlayers;
    }

    public int getMaxPlayers() {
        return this.maxPlayers;
    }

    public boolean isPreviewingChatEnabled() {
        return this.previewChat;
    }

    public boolean isSecureChatEnforced() {
        return this.enforceSecureChat;
    }

    @Override
    public int getId() {
        return StatusResponsePacket.ID;
    }

    @Override
    public PacketState getState() {
        return PacketState.STATUS;
    }

    @Override
    public @NotNull StatusResponsePacketBuilder toBuilder() {
        return new StatusResponsePacketBuilder();
    }

    @Override
    public ByteBuffer toBytes(Client stream) {
        JacksonConfigurationLoader loader = JacksonConfigurationLoader.builder().build();
        ConfigurationNode node = loader.createNode();
        try {
            node
                    .node("description")
                    .node("text")
                    .set(PlainTextComponentSerializer.plainText().serialize(this.descriptionText));
            node.node("players").node("max").set(this.maxPlayers);
            node.node("players").node("online").set(this.currentPlayers);
            node.node("version").node("name").set(this.nameVersion);
            node.node("version").node("protocol").set(this.protocolVersion);
            node.node("previewsChat").set(this.previewChat);
            node.node("enforcesSecureChat").set(this.enforceSecureChat);
            String json = JacksonConfigurationLoader
                    .builder()
                    .fieldValueSeparatorStyle(FieldValueSeparatorStyle.NO_SPACE)
                    .indent(0)
                    .buildAndSaveString(node);
            ByteBuffer bytes = NetSerializers.STRING.write(json);
            return NetUtils.createPacket(StatusResponsePacket.ID, bytes);
        } catch (ConfigurateException e) {
            throw new RuntimeException(e);
        }
    }
}
