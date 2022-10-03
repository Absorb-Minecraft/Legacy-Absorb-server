package org.absorb.entity;

import org.spongepowered.math.vector.Vector3d;

public interface PhysicalEntity extends Entity {
	Vector3d getDirection();
}
