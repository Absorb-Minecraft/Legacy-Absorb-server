package org.absorb.net;

import org.absorb.net.handler.NetHandler;
import org.absorb.net.packet.IncomingPacket;
import org.absorb.net.packet.IncomingPacketBuilder;
import org.absorb.net.packet.PacketState;
import org.absorb.net.packet.handshake.IncomingHandshakePacketBuilder;
import org.absorb.net.packet.login.start.IncomingLoginStartPacketBuilder;
import org.absorb.net.packet.play.incoming.client.ability.IncomingChangeAbilityPacketBuilder;
import org.absorb.net.packet.play.incoming.client.channel.chat.IncomingMessagePacketBuilder;
import org.absorb.net.packet.play.incoming.client.channel.command.IncomingCommandPacketBuilder;
import org.absorb.net.packet.play.incoming.client.channel.plugin.IncomingPluginMessagePacketBuilder;
import org.absorb.net.packet.play.incoming.client.inventory.close.IncomingCloseInventoryPacketBuilder;
import org.absorb.net.packet.play.incoming.client.inventory.creative.IncomingCreativeInventoryClickPacketBuilder;
import org.absorb.net.packet.play.incoming.client.inventory.hotbar.cooldown.IncomingItemCooldownPacketBuilder;
import org.absorb.net.packet.play.incoming.client.inventory.hotbar.selected.IncomingHotbarChangePacketBuilder;
import org.absorb.net.packet.play.incoming.client.keep.alive.IncomingKeepAlivePacketBuilder;
import org.absorb.net.packet.play.incoming.client.movement.IncomingPlayerMovementPacketBuilder;
import org.absorb.net.packet.play.incoming.client.movement.basic.IncomingBasicPlayerMovementPacketBuilder;
import org.absorb.net.packet.play.incoming.client.movement.rotation.IncomingRotationPacketBuilder;
import org.absorb.net.packet.play.incoming.client.movement.teleport.confirm.IncomingTeleportConfirmPacketBuilder;
import org.absorb.net.packet.play.incoming.client.query.entity.IncomingEntityQueryPacketBuilder;
import org.absorb.net.packet.play.incoming.client.recipe.IncomingRecipeRequestPacketBuilder;
import org.absorb.net.packet.play.incoming.client.settings.IncomingClientSettingsPacketBuilder;
import org.absorb.net.packet.play.outgoing.client.action.IncomingClientCommandActionPacketBuilder;
import org.absorb.net.packet.status.ping.IncomingPingPacketBuilder;
import org.absorb.net.packet.status.request.IncomingStatusRequestPacketBuilder;

import java.io.IOException;
import java.net.SocketAddress;
import java.util.*;
import java.util.function.Supplier;

public class NetManager {

    private final NetHandler handler;
    private final Map<SocketAddress, Client> info = new HashMap<>();
    private final Map<Map.Entry<Integer, PacketState>, Supplier<IncomingPacketBuilder<? extends IncomingPacket>>> packetBuilders = new HashMap<>();

    public NetManager(NetHandler handler) {
        this.handler = handler;
        this.init();
    }

    public void registerIncomingPacketBuilder(IncomingPacketBuilder<? extends IncomingPacket> builder) {
        Optional<Map.Entry<Integer, PacketState>> opKey = this.packetBuilders
                .keySet()
                .stream()
                .filter(entry -> entry.getValue() == builder.getState() && entry.getKey() == builder.getId())
                .findAny();
        if (opKey.isPresent()) {
            this.packetBuilders.replace(opKey.get(), builder::copy);
            return;
        }
        this.packetBuilders.put(new AbstractMap.SimpleImmutableEntry<>(builder.getId(), builder.getState()),
                                builder::copy);
    }

    public NetHandler getHandler() {
        return this.handler;
    }

    public Optional<Client> getClient(SocketAddress address) {
        return Optional.ofNullable(this.info.get(address));
    }

    public Collection<Client> getClients() {
        return this.info.values();
    }

    public void register(Client info) throws IOException {
        this.info.put(info.getAddress(), info);
    }

    public Optional<IncomingPacketBuilder<? extends IncomingPacket>> getIncomingPacketBuilder(int networkId,
                                                                                              PacketState state) {
        return this.packetBuilders
                .entrySet()
                .parallelStream()
                .filter(entry -> entry.getKey().getKey() == networkId)
                .filter(entry -> entry.getKey().getValue() == state)
                .findAny()
                .map(entry -> entry.getValue().get());
    }

    public void unregister(Client info) {
        try {
            info.getSocket().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.info.remove(info.getAddress());
    }

    private void init() {
        this.registerPacketBuilders();
    }

    private void registerPacketBuilders() {
        this.registerIncomingPacketBuilder(new IncomingHandshakePacketBuilder());
        this.registerIncomingPacketBuilder(new IncomingLoginStartPacketBuilder());
        this.registerIncomingPacketBuilder(new IncomingStatusRequestPacketBuilder());
        this.registerIncomingPacketBuilder(new IncomingPingPacketBuilder());
        this.registerIncomingPacketBuilder(new IncomingPingPacketBuilder().setUsePlay(true));
        this.registerIncomingPacketBuilder(new IncomingClientSettingsPacketBuilder());
        this.registerIncomingPacketBuilder(new IncomingTeleportConfirmPacketBuilder());
        this.registerIncomingPacketBuilder(new IncomingRecipeRequestPacketBuilder());
        this.registerIncomingPacketBuilder(new IncomingPlayerMovementPacketBuilder());
        this.registerIncomingPacketBuilder(new IncomingPluginMessagePacketBuilder());
        this.registerIncomingPacketBuilder(new IncomingBasicPlayerMovementPacketBuilder());
        this.registerIncomingPacketBuilder(new IncomingChangeAbilityPacketBuilder());
        this.registerIncomingPacketBuilder(new IncomingRotationPacketBuilder());
        this.registerIncomingPacketBuilder(new IncomingMessagePacketBuilder());
        this.registerIncomingPacketBuilder(new IncomingCreativeInventoryClickPacketBuilder());
        this.registerIncomingPacketBuilder(new IncomingCloseInventoryPacketBuilder());
        this.registerIncomingPacketBuilder(new IncomingItemCooldownPacketBuilder());
        this.registerIncomingPacketBuilder(new IncomingHotbarChangePacketBuilder());
        this.registerIncomingPacketBuilder(new IncomingCommandPacketBuilder());
        this.registerIncomingPacketBuilder(new IncomingClientCommandActionPacketBuilder());
        this.registerIncomingPacketBuilder(new IncomingEntityQueryPacketBuilder());
        this.registerIncomingPacketBuilder(new IncomingKeepAlivePacketBuilder());
    }
}
