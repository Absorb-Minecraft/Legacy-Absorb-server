package org.absorb.command.node.parser.properties;

import org.absorb.net.data.NetSerializer;
import org.absorb.net.data.NetUtils;
import org.absorb.net.data.NetSerializers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Optional;

public class MinMaxParserProperty<T extends Number> implements CommandParserProperty<T> {

    private @Nullable T min;
    private @Nullable T max;
    private @NotNull NetSerializer<T> serializer;

    public MinMaxParserProperty(@NotNull NetSerializer<T> serializer, @Nullable T min, @Nullable T max) {
        this.min = min;
        this.max = max;
        this.serializer = serializer;
    }

    public NetSerializer<T> getSerializer() {
        return this.serializer;
    }

    public Optional<T> getMinimum() {
        return Optional.ofNullable(this.min);
    }

    public Optional<T> getMaximum() {
        return Optional.ofNullable(this.max);
    }

    @Override
    public ByteBuffer write() {
        byte flag = 0;
        ByteBuffer minBuffer = ByteBuffer.allocate(0);
        ByteBuffer maxBuffer = ByteBuffer.allocate(0);
        if (this.min!=null) {
            flag = 1;
            minBuffer = this.serializer.write(this.min);
        }
        if (this.max!=null) {
            flag = (byte) (flag + 2);
            maxBuffer = this.serializer.write(this.max);
        }

        ByteBuffer flagBuffer = NetSerializers.BYTE.write(flag);

        return NetUtils.collect(List.of(flagBuffer, minBuffer, maxBuffer));
    }
}
