package org.absorb.net.data;

import org.spongepowered.math.vector.Vector3i;

import java.nio.ByteBuffer;

public class PositionSerializer implements Serializer<Vector3i> {
    @Override
    public NetEntryData<Vector3i> read(int position, ByteBuffer bytes) {
        long value = bytes.getLong(position);
        int x = (int) (value >> 38);
        int y = (int) (value & 0xFFF);
        int z = (int) ((value >> 12) & 0x3FFFFFF);
        return new NetEntryData<>(position, position + Long.BYTES, new Vector3i(x, y, z));
    }

    @Override
    public ByteBuffer write(Vector3i value) {
        long ret = ((value.x() & 0x3FFFFFF) | ((value.z() & 0x3FFFFFF) << 12) | (value.y() & 0xFFF));
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(ret);
        return buffer;
    }
}
