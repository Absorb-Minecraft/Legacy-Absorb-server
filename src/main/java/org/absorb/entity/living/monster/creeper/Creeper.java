package org.absorb.entity.living.monster.creeper;

import org.absorb.entity.EntityTypes;
import org.absorb.entity.living.AbstractLivingEntity;
import org.absorb.entity.living.monster.MonsterEntity;
import org.absorb.net.packet.play.outgoing.entity.metadata.types.EntityMetadataType;
import org.absorb.net.packet.play.outgoing.entity.metadata.types.EntityMetadataTypes;
import org.absorb.node.write.viewer.NotNullableViewerNodeData;
import org.absorb.world.explode.Explosive;

import java.util.Collection;

public class Creeper extends AbstractLivingEntity implements MonsterEntity, Explosive {

	private final NotNullableViewerNodeData<Boolean> isCharged = new NotNullableViewerNodeData<>(false);
	private final NotNullableViewerNodeData<Boolean> isIgniting = new NotNullableViewerNodeData<>(false);

	public Creeper() {
		super(EntityTypes.CREEPER);
	}

	public NotNullableViewerNodeData<Boolean> charged() {
		return this.isCharged;
	}

	public NotNullableViewerNodeData<Boolean> igniting() {
		return this.isIgniting;
	}

	public boolean isCharged() {
		return this.charged().getValue();
	}

	public Creeper setCharged(boolean charged) {
		this.isCharged.setValue(charged);
		return this;
	}

	public boolean isIgniting() {
		return this.isIgniting.getValue();
	}

	public Creeper setIgniting(boolean isIgniting) {
		this.isIgniting.setValue(isIgniting);
		return this;
	}

	@Override
	public double getStartDamage() {
		if (this.isCharged()) {
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
