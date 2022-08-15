package org.absorb.entity.living.monster.creeper;

import org.absorb.entity.EntityTypes;
import org.absorb.entity.living.AbstractLivingEntity;
import org.absorb.entity.living.monster.MonsterEntity;
import org.absorb.net.packet.play.outgoing.entity.metadata.types.EntityMetadataType;
import org.absorb.net.packet.play.outgoing.entity.metadata.types.EntityMetadataTypes;
import org.absorb.world.explode.Explosive;

import java.util.Collection;

public class Creeper extends AbstractLivingEntity implements MonsterEntity, Explosive {

    private boolean isCharged;
    private boolean isIgniting;

    public Creeper() {
        super(EntityTypes.CREEPER);
    }

    public boolean isCharged() {
        return this.isCharged;
    }

    public Creeper setCharged(boolean charged) {
        this.isCharged = charged;
        return this;
    }

    public boolean isIgniting() {
        return this.isIgniting;
    }

    public Creeper setIgniting(boolean isIgniting) {
        this.isIgniting = isIgniting;
        return this;
    }

    @Override
    public double getStartDamage() {
        if (this.isCharged) {
            return 43.5;
        }

        return 22;
    }

    @Override
    public double getDistance() {
        return 3.0;
    }

    @Override
    public double getDamageMultiplier() {
        return this.getStartDamage() / this.getDistance();
    }

    @Override
    public boolean canDestroyBlocks() {
        return true;
    }

    @Override
    public boolean canHurtEntities() {
        return true;
    }

    @Override
    public Collection<EntityMetadataType<?, ?>> getMetadataTypes() {
        return EntityMetadataTypes.getCreeperMetadata();
    }
}
