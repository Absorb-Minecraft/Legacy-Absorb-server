package org.absorb.net.processor.play.recipe.request;

import org.absorb.net.Client;
import org.absorb.net.packet.play.incoming.client.recipe.IncomingRecipeRequestPacket;
import org.absorb.net.processor.NetProcess;

import java.io.IOException;

public class RecipeRequestProcessor implements NetProcess<IncomingRecipeRequestPacket> {
    @Override
    public void onProcess(Client connection, IncomingRecipeRequestPacket packet) throws IOException {
        throw new RuntimeException("Not implemented yet");
    }
}
