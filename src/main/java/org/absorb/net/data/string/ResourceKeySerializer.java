package org.absorb.net.data.string;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.Serializer;
import org.absorb.net.data.Serializers;
import org.absorb.register.AbsorbKey;

import java.nio.ByteBuffer;

public class ResourceKeySerializer implements Serializer<AbsorbKey> {
    @Override
    public NetEntryData<AbsorbKey> read(int position, ByteBuffer bytes) {
        NetEntryData<String> data = Serializers.STRING.read(position, bytes);
        return new NetEntryData<>(data.originalPosition(), data.endingPosition(), AbsorbKey.resolve(data.value()));
    }

    @Override
    public ByteBuffer write(AbsorbKey value) {
        return Serializers.STRING.write(value.asFormatted());
    }
}
