package org.absorb.entity;

import org.absorb.entity.living.human.HumanType;
import org.absorb.entity.living.monster.creeper.CreeperType;

public interface EntityTypes {

    HumanType HUMAN = new HumanType();
    CreeperType CREEPER = new CreeperType();
}
