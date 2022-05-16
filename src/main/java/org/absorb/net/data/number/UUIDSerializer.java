package org.absorb.net.data.number;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.Serializer;
import org.absorb.net.data.Serializers;

import java.nio.ByteBuffer;
import java.util.UUID;

public class UUIDSerializer implements Serializer<UUID> {
    @Override
    public NetEntryData<UUID> read(int position, ByteBuffer bytes) {
        NetEntryData<Long> most = Serializers.LONG.read(position, bytes);
        NetEntryData<Long> least = Serializers.LONG.read(most.endingPosition(), bytes);
        System.out.println("UUID Most: " + most.value());
        System.out.println("UUID least: " + least.value());
        return new NetEntryData<>(position, least.endingPosition(), new UUID(most.value(), least.value()));
    }

    @Override
    public ByteBuffer write(UUID value) {
        System.out.println("UUID Most: " + value.getMostSignificantBits());
        System.out.println("UUID least: " + value.getLeastSignificantBits());

        ByteBuffer most = Serializers.LONG.write(value.getMostSignificantBits());
        ByteBuffer least = Serializers.LONG.write(value.getLeastSignificantBits());
        ByteBuffer ret = ByteBuffer.allocate(most.limit() + least.limit());
        ret.put(most.array());
        ret.put(least.array());
        return ret;
    }
}
