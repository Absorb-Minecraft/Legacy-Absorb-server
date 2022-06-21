package org.absorb.block.pallet;

import org.absorb.block.state.FullBlockState;
import org.absorb.net.data.Serializers;
import org.spongepowered.math.vector.Vector3i;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class DirectPallet implements BlockPallet {


    @Override
    public Map<Vector3i, FullBlockState> getBlocks() {
        return new HashMap<>();
    }

    @Override
    public ByteBuffer write() {
        return Serializers.BYTE.write((byte) Math.ceil((StrictMath.log(15) / 2)));
    }
}
