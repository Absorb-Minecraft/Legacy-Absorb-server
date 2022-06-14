package org.absorb.entity.living;

import org.absorb.entity.AbstractEntity;
import org.absorb.entity.EntityType;
import org.jetbrains.annotations.NotNull;

public class AbstractLivingEntity extends AbstractEntity implements LivingEntity {

    private float walkingSpeed;
    private float flyingSpeed;

    public AbstractLivingEntity(@NotNull EntityType<? extends LivingEntity> type) {
        super(type);
    }

    @Override
    public float getWalkingSpeed() {
        return this.walkingSpeed;
    }

    @Override
    public void setWalkingSpeed(float speed) {
        this.walkingSpeed = speed;
    }

    @Override
    public float getFlyingSpeed() {
        return this.flyingSpeed;
    }

    @Override
    public void setFlyingSpeed(float speed) {
        this.flyingSpeed = speed;
    }
}
