package org.absorb.world.explode;

import org.absorb.block.locatable.LocatableBlock;
import org.absorb.entity.WorldEntity;
import org.absorb.utils.Transaction;
import org.absorb.world.location.Locatable;

import java.util.Collection;
import java.util.Optional;

public interface Explosion<T> extends Locatable {

    Explosive getExplosive();

    Collection<Transaction<LocatableBlock>> getDamagedBlocks();

    Collection<WorldEntity> getDamagedEntities();

    Optional<T> getSource();

}
