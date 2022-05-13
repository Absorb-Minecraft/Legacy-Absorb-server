package org.absorb.net.packet.play.entity.player.tab.add;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.absorb.entity.living.human.tab.PlayerTab;
import org.absorb.entity.living.human.tab.PlayerTabProperty;
import org.absorb.net.Client;
import org.absorb.net.data.Serializer;
import org.absorb.net.data.SerializerUtils;
import org.absorb.net.data.Serializers;
import org.absorb.net.data.string.FixedSizeStringSerializer;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.play.entity.player.tab.OutgoingPlayerTabUpdatePacket;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class OutgoingPlayerTabUpdateAddPlayerPacket implements OutgoingPlayerTabUpdatePacket {

    private final Collection<PlayerTab> tabs = new HashSet<>();

    public OutgoingPlayerTabUpdateAddPlayerPacket(@NotNull OutgoingPlayerTabUpdateAddPlayerPacketBuilder builder) {
        this.tabs.addAll(builder.getTabs());
    }

    public Collection<PlayerTab> getTabs() {
        return this.tabs;
    }

    @Override
    public @NotNull OutgoingPacketBuilder<? extends Packet> toBuilder() {
        return new OutgoingPlayerTabUpdateAddPlayerPacketBuilder().addTabs(this.tabs);
    }

    @Override
    public void send(@NotNull Client stream) {
        ByteArrayOutputStream baOs = new ByteArrayOutputStream();
        try {
            ByteBuffer actionBuffer = Serializers.VAR_INTEGER.write(0);
            ByteBuffer tabSize = Serializers.VAR_INTEGER.write(this.tabs.size());

            baOs.write(actionBuffer.array());
            baOs.write(tabSize.array());

            System.out.println("Action: 0");
            System.out.println("Tab Size: " + this.tabs.size());
            for (PlayerTab tab : this.tabs) {
                ByteBuffer uuidBuffer = Serializers.UUID.write(tab.getUuid());
                ByteBuffer propertiesSize = Serializers.VAR_INTEGER.write(tab.getProperties().size());

                baOs.write(uuidBuffer.array());
                baOs.write(propertiesSize.array());

                System.out.println("UUID: " + tab.getUuid());
                System.out.println("Properties Size: " + tab.getProperties().size());
                for (PlayerTabProperty property : tab.getProperties()) {
                    Serializer<String> fixedString = new FixedSizeStringSerializer(32767);
                    Optional<String> opSign = property.getSignature();


                    ByteBuffer nameBuffer = fixedString.write(property.getName());
                    ByteBuffer valueBuffer = fixedString.write(property.getValue());
                    ByteBuffer signPresentBuffer = Serializers.BOOLEAN.write(opSign.isPresent());

                    baOs.write(nameBuffer.array());
                    baOs.write(valueBuffer.array());
                    baOs.write(signPresentBuffer.array());

                    System.out.println("Name: " + property.getName());
                    System.out.println("Value: " + property.getValue());
                    System.out.println("is sign present: " + opSign.isPresent());
                    if (opSign.isPresent()) {
                        ByteBuffer signBuffer = fixedString.write(opSign.get());
                        baOs.write(signBuffer.array());

                        System.out.println("Sign: " + opSign.get());
                    }
                }
                Optional<Component> opDisplayName = tab.getDisplayName();

                ByteBuffer gamemodeBuffer = Serializers.VAR_INTEGER.write(tab.getGameMode().getNetworkId());
                ByteBuffer pingBuffer = Serializers.VAR_INTEGER.write(tab.getPing());
                ByteBuffer displayNamePresent = Serializers.BOOLEAN.write(opDisplayName.isPresent());

                baOs.write(gamemodeBuffer.array());
                baOs.write(pingBuffer.array());
                baOs.write(displayNamePresent.array());

                System.out.println("Gamemode: " + tab.getGameMode().getNetworkId());
                System.out.println("Ping: " + tab.getPing());
                System.out.println("DisplayName Present: " + opDisplayName.isPresent());
                if (opDisplayName.isPresent()) {
                    ByteBuffer displayNameBuffer = Serializers.CHAT.write(opDisplayName.get());

                    baOs.write(displayNameBuffer.array());

                    System.out.println("DisplayName: " + GsonComponentSerializer.gson().serialize(opDisplayName.get()));
                }
            }
            baOs.flush();
            ByteBuffer ret = SerializerUtils.createPacket(this.getId(), ByteBuffer.wrap(baOs.toByteArray()));
            stream.write(ret);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
