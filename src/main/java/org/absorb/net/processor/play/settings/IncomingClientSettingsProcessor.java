package org.absorb.net.processor.play.settings;

import org.absorb.net.Client;
import org.absorb.net.packet.play.entity.player.inventory.OutgoingSwapHotbarPacketBuilder;
import org.absorb.net.packet.play.settings.client.IncomingClientSettingsPacket;
import org.absorb.net.processor.NetProcess;

public class IncomingClientSettingsProcessor implements NetProcess<IncomingClientSettingsPacket> {
    @Override
    public void onProcess(Client connection, IncomingClientSettingsPacket packet) {
        System.out.println("Got client settings");
        connection.setChatMode(packet.getChatMode());
        connection.setColouredChatMessages(packet.isChatColorEnabled());
        connection.setLocale(packet.getLocale());
        connection.setHiddenToList(packet.isShowOnList());
        connection.setViewDistance(packet.getViewDistance());


        new OutgoingSwapHotbarPacketBuilder().setNewSlot(connection.getInventory().getHotbar().getSelected()).build().sendAsync(connection);
        System.out.println("Set slot");
    }
}
