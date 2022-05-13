package org.absorb.block.pallet;

import org.absorb.block.state.AbsorbBlockState;
import org.absorb.block.state.FullBlockState;
import org.absorb.net.data.Serializers;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;
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
        ByteBuffer palletBuffer = Serializers.VAR_INTEGER.write(this.state.getState().getNetworkId());
        ByteBuffer bitsPerEntryBuffer = Serializers.BYTE.write((byte)palletBuffer.limit());
        ByteBuffer dataBuffer = Serializers.VAR_INTEGER.write(0);

        ByteBuffer buffer = ByteBuffer.allocate(bitsPerEntryBuffer.limit() + palletBuffer.limit() + dataBuffer.limit());
        buffer.put(bitsPerEntryBuffer);
        buffer.put(palletBuffer);
        buffer.put(dataBuffer);

        return buffer;
    }

}
