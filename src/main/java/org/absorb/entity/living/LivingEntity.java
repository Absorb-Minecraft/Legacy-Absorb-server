package org.absorb.entity.living;


import org.absorb.entity.Entity;

public interface LivingEntity extends Entity {

    float getWalkingSpeed();

    void setWalkingSpeed(float speed);

    float getFlyingSpeed();

    void setFlyingSpeed(float speed);


}
