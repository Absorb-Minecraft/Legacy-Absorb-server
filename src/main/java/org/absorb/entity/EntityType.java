package org.absorb.entity;

import org.absorb.net.Client;
import org.absorb.register.Typed;
import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

@Typed(getTypesClass = EntityTypes.class)
public interface EntityType<E extends Entity> extends Identifiable {

    void onPrimaryClick(@NotNull Client client, @NotNull E entity);

    void onSecondaryClick(@NotNull Client client, @NotNull E entity);

    void onSneak(@NotNull Client client, @NotNull E entity);

    boolean onRun(@NotNull Client client, @NotNull E entity);

    boolean onChangeFlyingState(@NotNull Client client, @NotNull E entity);

    @NotNull E createDefault();

}
