package org.absorb.block.pallet;

import org.absorb.block.state.FullBlockState;

import java.nio.ByteBuffer;
import java.util.Set;
import java.util.stream.Collectors;

public interface BlockPallet {

    Set<FullBlockState> getBlocks();

    ByteBuffer write();

    default Set<Integer> getBlockIds() {
        return this.getBlocks().parallelStream().map(state -> state.getState().getNetworkId()).collect(Collectors.toUnmodifiableSet());
    }
}
