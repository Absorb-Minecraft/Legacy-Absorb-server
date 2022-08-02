package org.absorb.entity.living;


import org.absorb.entity.Entity;

public interface LivingEntity extends Entity {

    float getWalkingSpeed();

    void setWalkingSpeed(float speed);

    float getFlyingSpeed();

    void setFlyingSpeed(float speed);

    int getArrowsInside();

    void setArrowsInside(int arrows);

    double getHealth();

    void setHealth(double health);

    default double damage(double damage) {
        double newHealth = this.getHealth() - damage;
        this.setHealth(newHealth);
        return newHealth;
    }

    default void kill() {
        this.setHealth(0);
    }

    default boolean isDead() {
        return this.getHealth() == 0;
    }
}
