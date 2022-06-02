package org.absorb.net.processor.play.entity.player.ability.change;

import org.absorb.net.Client;
import org.absorb.net.packet.play.entity.player.abilities.IncomingChangeAbilityPacket;
import org.absorb.net.processor.NetProcess;

import java.io.IOException;

public class ChangeAbilityProcessor implements NetProcess<IncomingChangeAbilityPacket> {
    @Override
    public void onProcess(Client connection, IncomingChangeAbilityPacket packet) throws IOException {

    }
}
