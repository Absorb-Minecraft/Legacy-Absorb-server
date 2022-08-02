package org.absorb.net.data.string;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializer;
import org.absorb.net.data.NetSerializers;
import org.absorb.register.AbsorbKey;

import java.nio.ByteBuffer;

public class NetKey implements NetSerializer<AbsorbKey> {
    @Override
    public NetEntryData<AbsorbKey> read(int position, ByteBuffer bytes) {
        NetEntryData<String> data = NetSerializers.STRING.read(position, bytes);
        return new NetEntryData<>(data.originalPosition(), data.endingPosition(), AbsorbKey.resolve(data.value()));
    }

    @Override
    public ByteBuffer write(AbsorbKey value) {
        return NetSerializers.STRING.write(value.asFormatted());
    }
}
