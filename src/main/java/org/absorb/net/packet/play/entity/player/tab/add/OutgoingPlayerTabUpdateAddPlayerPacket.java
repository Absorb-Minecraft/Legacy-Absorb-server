package org.absorb.net.packet.play.entity.player.tab.add;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.absorb.entity.living.human.tab.PlayerTab;
import org.absorb.entity.living.human.tab.PlayerTabProperty;
import org.absorb.net.Client;
import org.absorb.net.data.SerializerUtils;
import org.absorb.net.data.Serializers;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.play.entity.player.tab.OutgoingPlayerTabUpdatePacket;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
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
    public ByteBuffer toBytes(@NotNull Client stream) {
        ByteArrayOutputStream baOs = new ByteArrayOutputStream();
        try {
            ByteBuffer actionBuffer = Serializers.VAR_INTEGER.write(0);
            ByteBuffer tabSize = Serializers.VAR_INTEGER.write(this.tabs.size());

            baOs.write(actionBuffer.array());
            baOs.write(tabSize.array());

            System.out.println("Action: 0 {" + Arrays.toString(actionBuffer.array()) + "}{" + actionBuffer.array().length + "}");
            System.out.println("Tab Size: " + this.tabs.size() + "{" + Arrays.toString(tabSize.array()) + "}{" + tabSize.array().length + "}");
            for (PlayerTab tab : this.tabs) {
                ByteBuffer uuidBuffer = Serializers.UUID.write(tab.getUuid());
                ByteBuffer nameBuffer = Serializers.STRING.write(tab.getName());
                ByteBuffer propertiesSize = Serializers.VAR_INTEGER.write(tab.getProperties().size());

                baOs.write(uuidBuffer.array());
                baOs.write(nameBuffer.array());
                baOs.write(propertiesSize.array());

                System.out.println("UUID: " + tab.getUuid() + "{" + Arrays.toString(uuidBuffer.array()) + "}{" + uuidBuffer.array().length + "}");
                System.out.println("Name: " + tab.getName() + "{" + Arrays.toString(nameBuffer.array()) + "}{" + nameBuffer.array().length + "}");
                System.out.println("Properties Size: " + tab.getProperties().size() + "{" + Arrays.toString(propertiesSize.array()) + "}{" + propertiesSize.array().length + "}");
                for (PlayerTabProperty property : tab.getProperties()) {
                    Optional<String> opSign = property.getSignature();


                    ByteBuffer propNameBuffer = Serializers.STRING.write(property.getName());
                    ByteBuffer valueBuffer = Serializers.STRING.write(property.getValue());
                    ByteBuffer signPresentBuffer = Serializers.BOOLEAN.write(opSign.isPresent());

                    baOs.write(propNameBuffer.array());
                    baOs.write(valueBuffer.array());
                    baOs.write(signPresentBuffer.array());

                    System.out.println("Name: " + property.getName() + "{" + Arrays.toString(propNameBuffer.array()) + "}");
                    System.out.println("Value: " + property.getValue() + "{" + Arrays.toString(valueBuffer.array()) + "}");
                    System.out.println("is sign present: " + opSign.isPresent() + "{" + Arrays.toString(signPresentBuffer.array()) +
                            "}");
                    if (opSign.isPresent()) {
                        ByteBuffer signBuffer = Serializers.STRING.write(opSign.get());
                        baOs.write(signBuffer.array());

                        System.out.println("Sign: " + opSign.get() + "{" + Arrays.toString(signBuffer.array()) + "}");
                    }
                }
                Optional<Component> opDisplayName = tab.getDisplayName();

                ByteBuffer gamemodeBuffer = Serializers.VAR_INTEGER.write(tab.getGameMode().getNetworkId());
                ByteBuffer pingBuffer = Serializers.VAR_INTEGER.write(tab.getPing());
                ByteBuffer displayNamePresent = Serializers.BOOLEAN.write(opDisplayName.isPresent());

                baOs.write(gamemodeBuffer.array());
                baOs.write(pingBuffer.array());
                baOs.write(displayNamePresent.array());

                System.out.println("Gamemode: " + tab.getGameMode().getNetworkId() + "{" + Arrays.toString(gamemodeBuffer.array()) + "}{" + gamemodeBuffer.array().length + "}");
                System.out.println("Ping: " + tab.getPing() + "{" + Arrays.toString(pingBuffer.array()) + "}{" + pingBuffer.array().length + "}");
                System.out.println("DisplayName Present: " + opDisplayName.isPresent() + "{" + Arrays.toString(displayNamePresent.array()) + "}{" + displayNamePresent.array().length + "}");
                if (opDisplayName.isPresent()) {
                    ByteBuffer displayNameBuffer = Serializers.CHAT.write(opDisplayName.get());

                    baOs.write(displayNameBuffer.array());

                    System.out.println("DisplayName: " + GsonComponentSerializer.gson().serialize(opDisplayName.get()) + "{" + Arrays.toString(displayNameBuffer.array()) + "}");
                }
            }
            baOs.flush();
            return SerializerUtils.createPacket(this.getId(), ByteBuffer.wrap(baOs.toByteArray()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
