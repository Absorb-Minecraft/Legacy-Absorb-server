package org.absorb.entity.living.human;

import org.absorb.entity.EntityType;
import org.absorb.net.Client;
import org.absorb.net.packet.play.outgoing.entity.ability.OutgoingAbilityPacketBuilder;
import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

public class HumanType implements EntityType<Human> {

    @Override
    public @NotNull String getName() {
        return "Human";
    }

    @Override
    public @NotNull String getKey() {
        return "player";
    }

    @Override
    public @NotNull String getHost() {
        return Identifiable.MINECRAFT_HOST;
    }

    @Override
    public void onPrimaryClick(@NotNull Client client, @NotNull Human entity) {

    }

    @Override
    public void onSecondaryClick(@NotNull Client client, @NotNull Human entity) {

    }

    @Override
    public void onSneak(@NotNull Client client, @NotNull Human entity) {

    }

    @Override
    public boolean onRun(@NotNull Client client, @NotNull Human entity) {
        return true;
    }

    @Override
    public boolean onChangeFlyingState(@NotNull Client client, @NotNull Human entity) {
        if (!entity.isFlyingAllowed()) {
            return false;
        }

        entity.setFlying(!entity.isFlying());
        //send the change state packet as some clients don't assume that you can swap
        new OutgoingAbilityPacketBuilder().fromClient(client).build().writeToAsync(client);
        return true;
    }

    @Override
    public @NotNull Human createDefault() {
        return new Human();
    }
}
