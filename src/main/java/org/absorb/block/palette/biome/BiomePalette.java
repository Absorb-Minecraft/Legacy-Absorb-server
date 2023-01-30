package org.absorb.block.palette.biome;

import org.absorb.block.palette.Palette;
import org.absorb.world.biome.Biome;
import org.spongepowered.math.vector.Vector3i;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public interface BiomePalette extends Palette {

	Map<Vector3i, Biome> getBiomes();

	@Override
	default Set<Integer> getIds() {
		return this.getBiomes()
				.entrySet()
				.parallelStream()
				.map(entry -> entry.getValue().getNetworkId())
				.collect(Collectors.toUnmodifiableSet());
	}

	@Override
	default Collection<Vector3i> getLocations() {
		return this.getBiomes().keySet();
	}
}
