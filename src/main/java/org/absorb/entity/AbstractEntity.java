package org.absorb.entity;

import net.kyori.adventure.text.Component;
import org.absorb.node.CollectionNodeData;
import org.absorb.node.write.viewer.NotNullableViewerNodeData;
import org.absorb.node.write.viewer.NullableViewerNodeData;
import org.absorb.node.write.viewer.ViewerCollectionNodeData;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.concurrent.LinkedTransferQueue;

public abstract class AbstractEntity implements Entity {

	private final @NotNull EntityType<?> type;
	private final CollectionNodeData<EntityEffect<?>, Collection<EntityEffect<?>>> effects =
			new ViewerCollectionNodeData<>(LinkedTransferQueue::new);
	private final NotNullableViewerNodeData<Boolean> hasSpawned = new NotNullableViewerNodeData<>(false);
	private final NotNullableViewerNodeData<Boolean> isOnFire = new NotNullableViewerNodeData<>(false);
	private final NotNullableViewerNodeData<Boolean> isGlowing = new NotNullableViewerNodeData<>(false);
	private final NullableViewerNodeData<Component> customName = new NullableViewerNodeData<>();
	private final NotNullableViewerNodeData<Boolean> isFlying = new NotNullableViewerNodeData<>(false);
	private final NotNullableViewerNodeData<Boolean> hasGravity = new NotNullableViewerNodeData<>(true);

	public AbstractEntity(@NotNull EntityType<?> type) {
		this.type = type;
	}

	@Override
	public CollectionNodeData<EntityEffect<?>, Collection<EntityEffect<?>>> effects() {
		return this.effects;
	}

	@Override
	public NotNullableViewerNodeData<Boolean> spawned() {
		return this.hasSpawned;
	}

	@Override
	public NotNullableViewerNodeData<Boolean> gravity() {
		return this.hasGravity;
	}

	@Override
	public NotNullableViewerNodeData<Boolean> flying() {
		return this.isFlying;
	}

	@Override
	public NullableViewerNodeData<Component> customName() {
		return this.customName;
	}

	@Override
	public NotNullableViewerNodeData<Boolean> onFire() {
		return this.isOnFire;
	}

	@Override
	public NotNullableViewerNodeData<Boolean> glowing() {
		return this.isGlowing;
	}

	@Override
	public @NotNull EntityType<? extends Entity> getType() {
		return this.type;
	}
}
