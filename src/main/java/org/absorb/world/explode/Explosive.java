package org.absorb.world.explode;

public interface Explosive {

    double getStartDamage();

    double getDistance();

    double getDamageMultiplier();

    boolean canDestroyBlocks();

    boolean canHurtEntities();
}
