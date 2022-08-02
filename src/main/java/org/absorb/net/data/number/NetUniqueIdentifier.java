package org.absorb.net.data.number;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializer;
import org.absorb.net.data.NetSerializers;

import java.nio.ByteBuffer;
import java.util.UUID;

public class NetUniqueIdentifier implements NetSerializer<UUID> {
    @Override
    public NetEntryData<UUID> read(int position, ByteBuffer bytes) {
        NetEntryData<Long> most = NetSerializers.LONG.read(position, bytes);
        NetEntryData<Long> least = NetSerializers.LONG.read(most.endingPosition(), bytes);
        return new NetEntryData<>(position, least.endingPosition(), new UUID(most.value(), least.value()));
    }

    @Override
    public ByteBuffer write(UUID value) {
        ByteBuffer most = NetSerializers.LONG.write(value.getMostSignificantBits());
        ByteBuffer least = NetSerializers.LONG.write(value.getLeastSignificantBits());
        ByteBuffer ret = ByteBuffer.allocate(most.limit() + least.limit());
        ret.put(most.array());
        ret.put(least.array());
        return ret;
    }
}
