package org.absorb.block.pallet;

import org.absorb.block.locatable.BlockData;
import org.absorb.net.data.NetSerializers;
import org.spongepowered.math.vector.Vector3i;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class DirectPallet implements BlockPallet {


    @Override
    public Map<Vector3i, BlockData> getBlocks() {
        return new HashMap<>();
    }

    @Override
    public ByteBuffer write() {
        return NetSerializers.BYTE.write((byte) Math.ceil((StrictMath.log(15) / 2)));
    }
}
