package org.absorb.block.pallet;

import org.absorb.block.state.FullBlockState;
import org.absorb.net.data.Serializers;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Set;

public class SinglePallet implements BlockPallet {

    private final @NotNull FullBlockState state;

    public SinglePallet(@NotNull FullBlockState state) {
        this.state = state;
    }

    @Override
    public Set<FullBlockState> getBlocks() {
        return Set.of(this.state);
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
