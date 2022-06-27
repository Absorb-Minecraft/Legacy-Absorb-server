package org.absorb.block.pallet;

import org.absorb.block.locatable.BlockData;
import org.absorb.net.data.Serializers;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3i;

import java.nio.ByteBuffer;
import java.util.Map;

public class SinglePallet implements BlockPallet {

    private final @NotNull BlockData state;
    private final @NotNull Vector3i location;

    public SinglePallet(@NotNull BlockData state, @NotNull Vector3i location) {
        this.state = state;
        this.location = location;
    }

    @Override
    public Map<Vector3i, BlockData> getBlocks() {
        return Map.of(this.location, this.state);
    }

    @Override
    public ByteBuffer write() {
        byte bitsPerEntry = 0;
        ByteBuffer palletBuffer = Serializers.VAR_INTEGER.write(this.state.getState().getNetworkId());
        ByteBuffer dataBuffer = Serializers.VAR_INTEGER.write(0);

        ByteBuffer bitsPerEntryBuffer =
                Serializers.BYTE.write(bitsPerEntry);

        ByteBuffer buffer = ByteBuffer.allocate(bitsPerEntryBuffer.limit() + palletBuffer.limit() + dataBuffer.limit());
        buffer.put(bitsPerEntryBuffer.array());
        buffer.put(palletBuffer.array());
        buffer.put(dataBuffer.array());
        return buffer;
    }

}
