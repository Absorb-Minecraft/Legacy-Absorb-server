package org.absorb.net.processor.play.message;

import net.kyori.adventure.text.Component;
import org.absorb.AbsorbManagers;
import org.absorb.message.channel.ChatChannel;
import org.absorb.net.Client;
import org.absorb.net.packet.play.message.IncomingMessagePacket;
import org.absorb.net.packet.play.message.chat.OutgoingChatMessagePacketBuilder;
import org.absorb.net.processor.NetProcess;

import java.io.IOException;
import java.util.Collection;

public class MessageProcessor implements NetProcess<IncomingMessagePacket> {
    @Override
    public void onProcess(Client connection, IncomingMessagePacket packet) throws IOException {
        if (packet.getMessage().startsWith("/")) {
            this.onCommandProcess(connection, packet.getMessage());
            return;
        }
        this.onMessageProcess(connection, packet.getMessage());
    }

    private void onCommandProcess(Client connection, String command) throws IOException {

    }

    private void onMessageProcess(Client connection, String message) throws IOException {
        ChatChannel channel = AbsorbManagers.getChannelManager().getChatChannel();
        Component messageToSend = channel.format(connection, message);
        Collection<Client> audience = channel.getClients(connection);


        audience.forEach(client -> {
            new OutgoingChatMessagePacketBuilder()
                    .setMessage(messageToSend)
                    .setFrom(connection.getUuid())
                    .setPosition(channel.getDefaultPosition())
                    .build()
                    .writeToAsync(client);
        });
    }
}
