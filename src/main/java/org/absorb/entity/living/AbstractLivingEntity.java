package org.absorb.entity.living;

import org.absorb.entity.AbstractEntity;
import org.absorb.entity.EntityType;
import org.absorb.node.write.viewer.number.ViewerDoubleNodeData;
import org.absorb.node.write.viewer.number.ViewerFloatNodeData;
import org.absorb.node.write.viewer.number.ViewerIntegerNodeData;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractLivingEntity extends AbstractEntity implements LivingEntity {

	private final ViewerFloatNodeData walkingSpeed = new ViewerFloatNodeData();
	private final ViewerFloatNodeData flyingSpeed = new ViewerFloatNodeData();
	private final ViewerIntegerNodeData arrowsInside = new ViewerIntegerNodeData();
	private final ViewerDoubleNodeData health = new ViewerDoubleNodeData();

	public AbstractLivingEntity(@NotNull EntityType<? extends LivingEntity> type) {
		super(type);
	}

	@Override
	public ViewerFloatNodeData walkingSpeed() {
		return this.walkingSpeed;
	}

	@Override
	public ViewerFloatNodeData flyingSpeed() {
		return this.flyingSpeed;
	}

	@Override
	public ViewerIntegerNodeData arrowsInside() {
		return this.arrowsInside;
	}

	@Override
	public ViewerDoubleNodeData health() {
		return this.health;
	}
}
