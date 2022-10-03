package org.absorb.entity;

import net.kyori.adventure.text.Component;
import org.absorb.net.packet.play.outgoing.entity.metadata.types.EntityMetadataType;
import org.absorb.node.CollectionNodeData;
import org.absorb.node.write.viewer.NullableViewerNodeData;
import org.absorb.node.write.viewer.NotNullableViewerNodeData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Optional;

public interface Entity {

	CollectionNodeData<EntityEffect<?>, Collection<EntityEffect<?>>> effects();

	NotNullableViewerNodeData<Boolean> spawned();

	NotNullableViewerNodeData<Boolean> gravity();

	NotNullableViewerNodeData<Boolean> flying();

	NullableViewerNodeData<Component> customName();

	NotNullableViewerNodeData<Boolean> onFire();

	NotNullableViewerNodeData<Boolean> glowing();

	default Collection<EntityEffect<?>> getEffects() {
		return this.effects().getValue();
	}

	default void addEffect(EntityEffect<?> effect) {
		this.effects().add(effect);
	}

	default boolean hasSpawned() {
		return this.spawned().getValue();
	}

	default void setGravity(boolean gravity) {
		this.gravity().setValue(gravity);
	}

	default boolean hasGravity() {
		return this.gravity().getValue();
	}

	default boolean isFlying() {
		return this.flying().getValue();
	}

	default void setFlying(boolean isFlying) {
		this.flying().setValue(isFlying);
	}

	@NotNull EntityType<? extends Entity> getType();

	default Optional<Component> getCustomName() {
		return Optional.ofNullable(this.customName().getValue());
	}

	default void setCustomName(@Nullable Component component) {
		this.customName().setValue(component);
	}

	default boolean isOnFire() {
		return this.onFire().getValue();
	}

	default void setOnFire(boolean check) {
		this.onFire().setValue(check);
	}

	default boolean isGlowing() {
		return this.glowing().getValue();
	}

	default void setGlowing(boolean glowing) {
		this.glowing().setValue(glowing);
	}

	Collection<EntityMetadataType<?, ?>> getMetadataTypes();

	default void removeCustomName() {
		this.setCustomName(null);
	}

}
