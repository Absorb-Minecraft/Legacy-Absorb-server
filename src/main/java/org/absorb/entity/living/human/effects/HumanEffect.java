package org.absorb.entity.living.human.effects;

import org.absorb.entity.EntityEffect;
import org.absorb.entity.living.human.Human;

public interface HumanEffect extends EntityEffect<Human> {

    @Override
    default Class<Human> getTargetEntityClass() {
        return Human.class;
    }
}
