package org.absorb.entity.living.monster.creeper;

import org.absorb.entity.EntityType;
import org.absorb.net.Client;
import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

public class CreeperType implements EntityType<Creeper> {
    @Override
    public void onPrimaryClick(@NotNull Client client, @NotNull Creeper entity) {

    }

    @Override
    public void onSecondaryClick(@NotNull Client client, @NotNull Creeper entity) {

    }

    @Override
    public void onSneak(@NotNull Client client, @NotNull Creeper entity) {

    }

    @Override
    public boolean onRun(@NotNull Client client, @NotNull Creeper entity) {
        return false;
    }

    @Override
    public boolean onChangeFlyingState(@NotNull Client client, @NotNull Creeper entity) {
        return false;
    }

    @Override
    public @NotNull Creeper createDefault() {
        return new Creeper();
    }

    @Override
    public @NotNull String getName() {
        return "Creeper";
    }

    @Override
    public @NotNull String getKey() {
        return Identifiable.MINECRAFT_HOST;
    }

    @Override
    public @NotNull String getHost() {
        return "creeper";
    }
}
