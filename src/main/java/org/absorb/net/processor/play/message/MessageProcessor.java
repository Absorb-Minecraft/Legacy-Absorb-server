package org.absorb.net.processor.play.message;

import net.kyori.adventure.text.Component;
import org.absorb.AbsorbManagers;
import org.absorb.message.MessagePosition;
import org.absorb.message.channel.ChatChannel;
import org.absorb.net.Client;
import org.absorb.net.packet.play.incoming.client.channel.chat.IncomingMessagePacket;
import org.absorb.net.packet.play.outgoing.client.channel.chat.OutgoingChatMessagePacketBuilder;
import org.absorb.net.processor.NetProcess;
import org.jetbrains.annotations.NotNull;

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

    private void onCommandProcess(@NotNull Client connection, @NotNull String command) {
        try {
            AbsorbManagers.getCommandManager().execute(connection, command.substring(1));
        } catch (Throwable e) {
            new OutgoingChatMessagePacketBuilder().setPosition(MessagePosition.SYSTEM).setDisplayMessage(Component.text(
                    "Command Failed: " + e.getMessage())).build().writeToAsync(connection);
            e.printStackTrace();
        }
    }

    private void onMessageProcess(Client connection, String message) {
        ChatChannel channel = AbsorbManagers.getChannelManager().getChatChannel();
        Component messageToSend = channel.format(connection, message);
        Collection<Client> audience = channel.getClients(connection);


        audience.forEach(client -> {
            new OutgoingChatMessagePacketBuilder()
                    .setDisplayMessage(messageToSend)
                    .setFrom(connection.getUuid())
                    .setPosition(channel.getDefaultPosition())
                    .build()
                    .writeToAsync(client);
        });
    }
}
