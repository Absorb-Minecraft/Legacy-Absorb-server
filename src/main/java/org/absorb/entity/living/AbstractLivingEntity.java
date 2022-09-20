package org.absorb.entity.living;

import org.absorb.entity.AbstractEntity;
import org.absorb.entity.EntityType;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractLivingEntity extends AbstractEntity implements LivingEntity {

    private float walkingSpeed;
    private float flyingSpeed;
    private int arrowsInside;
    private double health;

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

    @Override
    public int getArrowsInside() {
        return this.arrowsInside;
    }

    @Override
    public void setArrowsInside(int arrows) {
        this.arrowsInside = arrows;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }
}
