package org.absorb.net.processor.play.message;

import net.kyori.adventure.text.Component;
import org.absorb.AbsorbManagers;
import org.absorb.net.Client;
import org.absorb.net.packet.play.incoming.client.channel.command.IncomingCommandPacket;
import org.absorb.net.packet.play.outgoing.client.channel.chat.system.OutgoingSystemChatMessagePacketBuilder;
import org.absorb.net.processor.NetProcess;

import java.io.IOException;

public class CommandProcessor implements NetProcess<IncomingCommandPacket> {
    @Override
    public void onProcess(Client connection, IncomingCommandPacket packet) throws IOException {
        try {
            AbsorbManagers.getCommandManager().execute(connection, packet.getCommand().substring(1));
        } catch (Throwable e) {
            new OutgoingSystemChatMessagePacketBuilder()
                    .setMessage(Component.text("Command Failed: " + e.getMessage()))
                    .build()
                    .writeToAsync(connection);
            e.printStackTrace();
        }
    }
}
