package org.absorb.block.palette;

import org.absorb.block.palette.block.BlockPalette;
import org.spongepowered.math.vector.Vector3i;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Comparator;

public interface Palette {

	ByteBuffer write();

	Collection<Vector3i> getLocations();

	Collection<Integer> getIds();

	default Comparator<BlockPalette> compareOnBlockLocation() {
		return (o1, o2) -> {
			Vector3i v1 = o1.getBlocks().keySet().iterator().next();
			Vector3i v2 = o2.getBlocks().keySet().iterator().next();
			if (v1.y() > v2.y()) {
				return 1;
			}
			if (v1.y() < v2.y()) {
				return -1;
			}
			if (v1.z() > v2.z()) {
				return 1;
			}
			if (v1.z() < v2.z()) {
				return -1;
			}
			return Integer.compare(v1.x(), v2.x());
		};
	}
}
