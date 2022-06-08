package org.absorb.command.node.parser.properties;

import org.absorb.net.data.Serializers;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

public class StringTypeProperty implements CommandParserProperty<String> {

    public enum StringType {
        SINGLE(0),
        GREEDY(2),
        QUOTED(1);

        private final int networkId;

        StringType(int id) {
            this.networkId = id;
        }

        public int getNetworkId() {
            return this.networkId;
        }
    }

    private final StringType type;

    public StringTypeProperty(@NotNull StringType type) {
        this.type = type;
    }

    public @NotNull StringType getType() {
        return this.type;
    }

    @Override
    public ByteBuffer write() {
        return Serializers.BYTE.write((byte) this.type.getNetworkId());
    }
}
