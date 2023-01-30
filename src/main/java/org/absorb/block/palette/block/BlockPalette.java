package org.absorb.block.palette.block;

import org.absorb.block.locatable.BlockData;
import org.absorb.block.palette.Palette;
import org.spongepowered.math.vector.Vector3i;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public interface BlockPalette extends Palette {

	Map<Vector3i, BlockData> getBlocks();

	@Override
	default Set<Integer> getIds() {
		return this.getBlocks()
				.entrySet()
				.parallelStream()
				.map(entry -> entry.getValue().getState().getNetworkId())
				.collect(Collectors.toUnmodifiableSet());
	}

	@Override
	default Collection<Vector3i> getLocations(){
		return this.getBlocks().keySet();
	}
}
