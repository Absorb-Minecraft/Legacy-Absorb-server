package org.absorb.net.processor.play.settings;

import org.absorb.net.Client;
import org.absorb.net.packet.play.incoming.client.settings.IncomingClientSettingsPacket;
import org.absorb.net.processor.NetProcess;

import java.io.IOException;

public class IncomingClientSettingsProcessor implements NetProcess<IncomingClientSettingsPacket> {
    @Override
    public void onProcess(Client connection, IncomingClientSettingsPacket packet) throws IOException {
        connection.setChatMode(packet.getChatMode());
        connection.setColouredChatMessages(packet.isChatColorEnabled());
        connection.setLocale(packet.getLocale());
        connection.setHiddenToList(packet.isShowOnList());
        connection.setViewDistance(packet.getViewDistance());
    }
}
