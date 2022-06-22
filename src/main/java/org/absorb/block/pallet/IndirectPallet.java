package org.absorb.block.pallet;

import org.absorb.block.locatable.BlockData;
import org.absorb.net.data.SerializerUtils;
import org.absorb.net.data.Serializers;
import org.spongepowered.math.vector.Vector3i;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IndirectPallet implements BlockPallet {

    private static class BlockMappings {
        private final Vector3i location;
        private final BlockData state;

        private BlockMappings(Vector3i location, BlockData state) {
            this.location = location;
            this.state = state;
        }

        public Vector3i getLocation() {
            return this.location;
        }

        public BlockData getState() {
            return this.state;
        }
    }

    private final List<BlockMappings> mappings = new LinkedList<>();
    private final byte bitsPerEntry;

    public IndirectPallet(byte bitsPerEntry) {
        if (bitsPerEntry < 4) {
            bitsPerEntry = 4;
        }
        this.bitsPerEntry = bitsPerEntry;
    }

    public void addBlock(Vector3i location, BlockData state) {
        this.mappings.add(new BlockMappings(location, state));

    }

    @Override
    public Map<Vector3i, BlockData> getBlocks() {
        return this.mappings.parallelStream().collect(Collectors.toMap(BlockMappings::getLocation,
                BlockMappings::getState));
    }

    @Override
    public ByteBuffer write() {
        ByteBuffer bitsPerEntryBuffer = Serializers.BYTE.write(this.bitsPerEntry);
        ByteBuffer paletteSize = Serializers.VAR_INTEGER.write(this.mappings.size());
        ByteBuffer paletteBuffer = SerializerUtils
                .collect(
                        this
                                .mappings
                                .stream()
                                .map(mappings -> Serializers.VAR_INTEGER
                                        .write(mappings
                                                .getState()
                                                .getState()
                                                .getNetworkId()))
                                .toList());


        return SerializerUtils.collect(Arrays.asList(bitsPerEntryBuffer, paletteSize, paletteBuffer));
    }
}
