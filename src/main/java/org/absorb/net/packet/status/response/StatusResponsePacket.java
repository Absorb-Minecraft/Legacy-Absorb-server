package org.absorb.net.packet.status.response;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.absorb.net.Client;
import org.absorb.net.data.SerializerUtils;
import org.absorb.net.data.Serializers;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.PacketState;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.jackson.FieldValueSeparatorStyle;
import org.spongepowered.configurate.jackson.JacksonConfigurationLoader;

import java.io.IOException;
import java.nio.ByteBuffer;

public class StatusResponsePacket implements OutgoingPacket {

    public static final int ID = 0x00;

    private final int protocolVersion;
    private final String nameVersion;
    private final Component descriptionText;
    private final int currentPlayers;
    private final int maxPlayers;

    public StatusResponsePacket(StatusResponsePacketBuilder builder) {
        this.currentPlayers = builder.getCurrentPlayers();
        this.maxPlayers = builder.getMaxPlayers();

        this.descriptionText = builder.getDescription();
        this.nameVersion = builder.getVersionName();
        this.protocolVersion = builder.getVersionProtocol();
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

    @Override
    public void send(Client stream) {
        JacksonConfigurationLoader loader = JacksonConfigurationLoader.builder().build();
        ConfigurationNode node = loader.createNode();
        try {
            node.node("description").node("text").set(PlainTextComponentSerializer.plainText().serialize(this.descriptionText));
            node.node("players").node("max").set(this.maxPlayers);
            node.node("players").node("online").set(this.currentPlayers);
            //node.node("players").node("sample").set(Collections.emptyList());
            node.node("version").node("name").set(this.nameVersion);
            node.node("version").node("protocol").set(this.protocolVersion);
            String json =
                    JacksonConfigurationLoader.builder().fieldValueSeparatorStyle(FieldValueSeparatorStyle.NO_SPACE).indent(0).buildAndSaveString(node);
            ByteBuffer bytes = Serializers.STRING.write(json);
            ByteBuffer bytesToSend = SerializerUtils.createPacket(StatusResponsePacket.ID, bytes);
            try {
                stream.write(bytesToSend);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ConfigurateException e) {
            e.printStackTrace();
        }
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
    public StatusResponsePacketBuilder toBuilder() {
        return new StatusResponsePacketBuilder();
    }
}
