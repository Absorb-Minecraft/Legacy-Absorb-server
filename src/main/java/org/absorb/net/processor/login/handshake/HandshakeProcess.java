package org.absorb.net.processor.login.handshake;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.absorb.net.Client;
import org.absorb.net.packet.PacketState;
import org.absorb.net.packet.handshake.HandshakeState;
import org.absorb.net.packet.handshake.IncomingHandshakePacket;
import org.absorb.net.packet.play.outgoing.client.disconnect.OutgoingCloseConnectionPacketBuilder;
import org.absorb.net.processor.NetProcess;
import org.absorb.version.MCVersion;

public class HandshakeProcess implements NetProcess<IncomingHandshakePacket> {

    @Override
    public void onProcess(Client info, IncomingHandshakePacket packet) {
        if (packet.getHandshakeState()==HandshakeState.LOGIN) {
            this.onLogin(packet, info);
            return;
        }
        onStatus(info);

    }

    private void onStatus(Client info) {
        info.setState(PacketState.STATUS);

    }

    private void onLogin(IncomingHandshakePacket packet, Client info) {
        info.setState(PacketState.LOGIN);
        if (packet.getMcNetworkId()!=MCVersion.CURRENT.protocolVersion()) {
            Component message =
                    Component.text("Unsupported version. This server is running " + MCVersion.CURRENT.getName()).decorate(TextDecoration.BOLD).color(NamedTextColor.RED);
            new OutgoingCloseConnectionPacketBuilder().setUsingPlay(false).setMessage(message).build().writeToAsync(info);
        }
    }
}
