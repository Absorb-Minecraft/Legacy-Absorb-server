package org.absorb.entity;

import org.absorb.AbsorbManagers;
import org.absorb.net.Client;
import org.absorb.net.PlayingState;
import org.absorb.node.write.viewer.NullableViewerNodeData;
import org.absorb.node.write.viewer.NotNullableViewerNodeData;
import org.absorb.world.World;
import org.absorb.world.area.AbsorbChunk;
import org.absorb.world.location.Location;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector2i;
import org.spongepowered.math.vector.Vector3d;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class WorldEntity {

	private final int instanceId;
	private final @NotNull Entity entity;
	private final NullableViewerNodeData<Vector3d> fellFrom;
	private final NullableViewerNodeData<Vector3d> landedOn;
	private final NotNullableViewerNodeData<Vector3d> position;
	private final NotNullableViewerNodeData<World> world;

	public WorldEntity(WorldEntityBuilder builder) {
		this.entity = builder.getEntity();
		this.fellFrom = new NullableViewerNodeData<>(builder.getFellFrom());
		this.landedOn = new NullableViewerNodeData<>(builder.getLandedOn());
		this.position = new NotNullableViewerNodeData<>(builder.getPosition());
		this.world = new NotNullableViewerNodeData<>(builder.getWorld());
		this.instanceId = builder.getInstanceId();
	}

	public AbsorbChunk getChunk() {
		Vector2i chunkPosition = this.getLocation().getChunkPosition();
		return this.getWorld()
				.getLoadedChunk(chunkPosition)
				.orElseThrow(() -> new IllegalStateException("Entity is no longer in a loaded chunk"));
	}

	public Location getLocation() {
		return new Location(this.getWorld(), this.getPosition());
	}

	public Optional<Client> getClient() {
		return AbsorbManagers
				.getNetManager()
				.getClients()
				.parallelStream()
				.filter(client -> client.getPlayingState() == PlayingState.PLAYING)
				.filter(client -> client.getEntity().equals(WorldEntity.this))
				.findAny();
	}

	public int getInstanceId() {
		return this.instanceId;
	}

	public @NotNull Entity getEntity() {
		return this.entity;
	}

	public @NotNull Optional<Vector3d> getFellFrom() {
		return Optional.ofNullable(this.fellFrom.getValue());
	}

	public Optional<Vector3d> getLandedOn() {
		return Optional.ofNullable(this.landedOn.getValue());
	}

	public @NotNull Vector3d getPosition() {
		return this.position.getValue();
	}

	public void setPosition(@NotNull Vector3d position) {
		Collection<Vector2i> oldChunks = new HashSet<>();
		Optional<Client> opClient = this.getClient();
		if (opClient.isPresent()) {
			oldChunks = opClient.get().getViewingChunks();
		}
		this.position.setValue(position);
		if (opClient.isEmpty()) {
			return;
		}
		Client client = opClient.get();
		Collection<Vector2i> newChunks = client.getViewingChunks();
		Collection<Vector2i> genChunks = new HashSet<>(newChunks);
		Collection<Vector2i> commonChunks = new HashSet<>(newChunks);
		commonChunks.retainAll(oldChunks);
		genChunks.removeAll(commonChunks);
		if (genChunks.isEmpty()) {
			return;
		}
		client.updateChunks(genChunks);
	}

	public @NotNull World getWorld() {
		return this.world.getValue();
	}
}
