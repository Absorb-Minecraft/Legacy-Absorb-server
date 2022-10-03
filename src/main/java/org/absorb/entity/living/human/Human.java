package org.absorb.entity.living.human;

import net.kyori.adventure.text.Component;
import org.absorb.entity.EntityTypes;
import org.absorb.entity.living.AbstractLivingEntity;
import org.absorb.net.packet.play.outgoing.entity.metadata.types.EntityMetadataType;
import org.absorb.node.write.viewer.NotNullableViewerNodeData;
import org.absorb.node.write.viewer.NullableViewerNodeData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class Human extends AbstractLivingEntity {

	private final NotNullableViewerNodeData<Gamemode> gamemode = new NotNullableViewerNodeData<>(Gamemodes.CREATIVE);
	private final NullableViewerNodeData<Component> tabDisplayName = new NullableViewerNodeData<>();
	private final NullableViewerNodeData<Boolean> isFlyingAllowed = new NullableViewerNodeData<>();

	public Human() {
		super(EntityTypes.HUMAN);
	}

	public Optional<Component> getTabName() {
		return Optional.ofNullable(this.tabDisplayName.getValue());
	}

	public void setTabDisplayName(@Nullable Component component) {
		this.tabDisplayName.setValue(component);
	}

	public @NotNull Gamemode getGamemode() {
		return this.gamemode.getValue();
	}

	public void setGamemode(@NotNull Gamemode mode) {
		this.gamemode.setValue(mode);
	}

	public boolean isFlyingAllowed() {
		if (this.isFlyingAllowed.getValue() == null) {
			return this.getGamemode() == Gamemodes.CREATIVE;
		}
		return this.isFlyingAllowed.getValue();
	}

	public void setFlyingAllowed(boolean check) {
		this.isFlyingAllowed.setValue(check);
	}

	public void setGamemodeFlyingRequirements() {
		this.isFlyingAllowed.setValue(null);
	}

	@Override
	public Collection<EntityMetadataType<?, ?>> getMetadataTypes() {
		//TODO
		return Collections.emptyList();
	}
}
