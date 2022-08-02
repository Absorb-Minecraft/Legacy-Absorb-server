package org.absorb.net.packet.play.outgoing.entity.tab.add;

import net.kyori.adventure.text.Component;
import org.absorb.entity.living.human.tab.PlayerTab;
import org.absorb.entity.living.human.tab.PlayerTabProperty;
import org.absorb.net.Client;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.play.outgoing.entity.tab.OutgoingPlayerTabUpdatePacket;
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
    public ByteBuffer toBytes(@NotNull Client stream) {
        ByteArrayOutputStream baOs = new ByteArrayOutputStream();
        try {
            ByteBuffer actionBuffer = NetSerializers.VAR_INTEGER.write(0);
            ByteBuffer tabSize = NetSerializers.VAR_INTEGER.write(this.tabs.size());

            baOs.write(actionBuffer.array());
            baOs.write(tabSize.array());

            for (PlayerTab tab : this.tabs) {
                ByteBuffer uuidBuffer = NetSerializers.UUID.write(tab.getUuid());
                ByteBuffer nameBuffer = NetSerializers.STRING.write(tab.getName());
                ByteBuffer propertiesSize = NetSerializers.VAR_INTEGER.write(tab.getProperties().size());

                baOs.write(uuidBuffer.array());
                baOs.write(nameBuffer.array());
                baOs.write(propertiesSize.array());

                for (PlayerTabProperty property : tab.getProperties()) {
                    Optional<String> opSign = property.getSignature();


                    ByteBuffer propNameBuffer = NetSerializers.STRING.write(property.getName());
                    ByteBuffer valueBuffer = NetSerializers.STRING.write(property.getValue());
                    ByteBuffer signPresentBuffer = NetSerializers.BOOLEAN.write(opSign.isPresent());

                    baOs.write(propNameBuffer.array());
                    baOs.write(valueBuffer.array());
                    baOs.write(signPresentBuffer.array());

                    if (opSign.isPresent()) {
                        ByteBuffer signBuffer = NetSerializers.STRING.write(opSign.get());
                        baOs.write(signBuffer.array());
                    }
                }
                Optional<Component> opDisplayName = tab.getDisplayName();

                ByteBuffer gamemodeBuffer = NetSerializers.VAR_INTEGER.write(tab.getGameMode().getNetworkId());
                ByteBuffer pingBuffer = NetSerializers.VAR_INTEGER.write(tab.getPing());
                ByteBuffer displayNamePresent = NetSerializers.BOOLEAN.write(opDisplayName.isPresent());
                ByteBuffer signDataPresent = NetSerializers.BOOLEAN.write(tab.getTimestamp().isPresent());

                baOs.write(gamemodeBuffer.array());
                baOs.write(pingBuffer.array());
                baOs.write(displayNamePresent.array());

                if (opDisplayName.isPresent()) {
                    ByteBuffer displayNameBuffer = NetSerializers.CHAT.write(opDisplayName.get());

                    baOs.write(displayNameBuffer.array());
                }

                baOs.write(signDataPresent.array());

                if(tab.getTimestamp().isPresent()) {
                    ByteBuffer timestamp = NetSerializers.LONG.write(tab.getTimestamp().orElse(0));
                    ByteBuffer publicKeyLength = NetSerializers.VAR_INTEGER.write(tab.getPublicKey().length);
                    ByteBuffer publicKeyBuffer = ByteBuffer.wrap(tab.getPublicKey());
                    ByteBuffer signLength = NetSerializers.VAR_INTEGER.write(tab.getSignature().length);
                    ByteBuffer signBuffer = ByteBuffer.wrap(tab.getSignature());

                    baOs.write(timestamp.array());
                    baOs.write(publicKeyLength.array());
                    baOs.write(publicKeyBuffer.array());
                    baOs.write(signLength.array());
                    baOs.write(signBuffer.array());
                }


            }
            baOs.flush();
            return NetUtils.createPacket(this.getId(), ByteBuffer.wrap(baOs.toByteArray()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
