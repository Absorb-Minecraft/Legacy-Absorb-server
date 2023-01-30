package org.absorb.block.palette.biome;

import org.absorb.net.data.NetSerializers;
import org.absorb.world.biome.Biome;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3i;

import java.nio.ByteBuffer;
import java.util.Map;

public class SingledBiomePalette implements BiomePalette {

	private final @NotNull Biome biome;
	private final @NotNull Vector3i location;

	public SingledBiomePalette(@NotNull Biome biome, @NotNull Vector3i location) {
		this.biome = biome;
		this.location = location;
	}

	@Override
	public ByteBuffer write() {
		byte bitsPerEntry = 0;
		ByteBuffer palletBuffer = NetSerializers.VAR_INTEGER.write(this.biome.getNetworkId());
		ByteBuffer dataBuffer = NetSerializers.VAR_INTEGER.write(0);

		ByteBuffer bitsPerEntryBuffer =
				NetSerializers.BYTE.write(bitsPerEntry);

		ByteBuffer buffer =
				ByteBuffer.allocate(bitsPerEntryBuffer.limit() + palletBuffer.limit() + dataBuffer.limit());
		buffer.put(bitsPerEntryBuffer.array());
		buffer.put(palletBuffer.array());
		buffer.put(dataBuffer.array());
		return buffer;
	}

	@Override
	public Map<Vector3i, Biome> getBiomes() {
		return Map.of(this.location, this.biome);
	}
}
