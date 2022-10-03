package org.absorb.entity.living;


import org.absorb.entity.Entity;
import org.absorb.node.write.viewer.number.ViewerDoubleNodeData;
import org.absorb.node.write.viewer.number.ViewerFloatNodeData;
import org.absorb.node.write.viewer.number.ViewerIntegerNodeData;

public interface LivingEntity extends Entity {

	ViewerFloatNodeData walkingSpeed();

	ViewerFloatNodeData flyingSpeed();

	ViewerIntegerNodeData arrowsInside();

	ViewerDoubleNodeData health();

	default float getWalkingSpeed() {
		return this.walkingSpeed().getValue();
	}

	default void setWalkingSpeed(float speed) {
		this.walkingSpeed().setValue(speed);
	}

	default float getFlyingSpeed() {
		return this.flyingSpeed().getValue();
	}

	default void setFlyingSpeed(float speed) {
		this.flyingSpeed().setValue(speed);
	}

	default int getArrowsInside() {
		return this.arrowsInside().getValue();
	}

	default void setArrowsInside(int arrows) {
		this.arrowsInside().setValue(arrows);
	}

	default double getHealth() {
		return this.health().getValue();
	}

	default void setHealth(double health) {
		this.health().setValue(health);
	}

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
