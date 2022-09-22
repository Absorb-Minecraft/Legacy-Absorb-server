package org.absorb.net.processor.play.message;

import org.absorb.net.Client;
import org.absorb.net.packet.play.incoming.client.channel.chat.preview.IncomingMessagePreviewPacket;
import org.absorb.net.processor.NetProcess;

import java.io.IOException;

public class MessagePreviewProcessor implements NetProcess<IncomingMessagePreviewPacket> {
    @Override
    public void onProcess(Client connection, IncomingMessagePreviewPacket packet) throws IOException {
        System.out.println("on chat preview");
    }
}
