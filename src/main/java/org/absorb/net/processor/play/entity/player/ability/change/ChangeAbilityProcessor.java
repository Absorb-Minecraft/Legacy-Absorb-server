package org.absorb.net.processor.play.entity.player.ability.change;

import org.absorb.entity.Entity;
import org.absorb.entity.EntityType;
import org.absorb.net.Client;
import org.absorb.net.packet.play.entity.player.abilities.IncomingChangeAbilityPacket;
import org.absorb.net.packet.play.entity.player.abilities.PlayerAbilities;
import org.absorb.net.packet.play.settings.ability.OutgoingAbilityPacketBuilder;
import org.absorb.net.processor.NetProcess;

import java.io.IOException;
import java.util.function.BiFunction;

public class ChangeAbilityProcessor implements NetProcess<IncomingChangeAbilityPacket> {
    @Override
    public void onProcess(Client connection, IncomingChangeAbilityPacket packet) throws IOException {
        if (packet.getAbility().map(ability -> ability==PlayerAbilities.IS_FLYING).orElse(true)) {
            boolean shouldCancel = !this.onChange(connection, (e, t) -> t.onChangeFlyingState(connection, e));
            if (shouldCancel) {
                new OutgoingAbilityPacketBuilder().fromClient(connection).build().writeToAsync(connection);
            }
            return;
        }
throw new RuntimeException("Could not process ability change of: " + packet.getAbility());
    }

    private <T extends Entity, R> R onChange(Client client, BiFunction<T, ? super EntityType<T>, R> runner) {
        T entity = (T) client.getEntity().getEntity();
        EntityType<T> type = (EntityType<T>) entity.getType();
        return runner.apply(entity, type);
    }
}
