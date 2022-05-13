package org.absorb.net.data.string;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.Serializer;
import org.absorb.net.data.Serializers;

import java.nio.ByteBuffer;

public class ChatSerializer implements Serializer<Component> {
    @Override
    public NetEntryData<Component> read(int position, ByteBuffer bytes) {
        NetEntryData<String> entry = Serializers.STRING.read(position, bytes);
        Component component = GsonComponentSerializer.gson().deserialize(entry.value());
        return new NetEntryData<>(entry.originalPosition(), entry.endingPosition(), component);
    }

    @Override
    public ByteBuffer write(Component value) {
        String sValue = GsonComponentSerializer.gson().serialize(value);

        return Serializers.STRING.write(sValue);
    }
}
