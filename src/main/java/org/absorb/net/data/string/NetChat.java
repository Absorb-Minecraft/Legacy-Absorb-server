package org.absorb.net.data.string;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializer;
import org.absorb.net.data.NetSerializers;

import java.nio.ByteBuffer;

public class NetChat implements NetSerializer<Component> {
    @Override
    public NetEntryData<Component> read(int position, ByteBuffer bytes) {
        NetEntryData<String> entry = NetSerializers.STRING.read(position, bytes);
        Component component = GsonComponentSerializer.gson().deserialize(entry.value());
        return new NetEntryData<>(entry.originalPosition(), entry.endingPosition(), component);
    }

    @Override
    public ByteBuffer write(Component value) {
        String sValue = GsonComponentSerializer.gson().serialize(value);
        if (sValue.length() >= 262144) {
            throw new RuntimeException("Component is greater then 262144 characters when string format");
        }
        return NetSerializers.STRING.write(sValue, false);
    }
}
