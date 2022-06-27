package org.absorb.block.pallet;

import org.absorb.block.locatable.BlockData;
import org.spongepowered.math.vector.Vector3i;

import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public interface BlockPallet {

    Map<Vector3i, BlockData> getBlocks();

    ByteBuffer write();

    default Set<Integer> getBlockIds() {
        return this.getBlocks().entrySet().parallelStream().map(entry -> entry.getValue().getState().getNetworkId()).collect(Collectors.toUnmodifiableSet());
    }

    default Comparator<BlockPallet> compareOnBlockLocation(){
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
