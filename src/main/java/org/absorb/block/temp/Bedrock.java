package org.absorb.block.temp;

import org.absorb.block.state.AbsorbBlockStateBuilder;
import org.absorb.block.type.AbsorbBlockType;
import org.absorb.block.type.AbsorbBlockTypeBuilder;
import org.absorb.utils.Identifiable;

public class Bedrock {

    private static AbsorbBlockStateBuilder buildState() {
        return new AbsorbBlockStateBuilder().setNetworkId(33);
    }

    public static AbsorbBlockType getType() {
        return new AbsorbBlockTypeBuilder()
                .setBlockStates(buildState())
                .setDefaultState(buildState())
                .setName("Bedrock")
                .setKey("bedrock")
                .setHost(Identifiable.MINECRAFT_HOST)
                .setNetworkId(25)
                .build();
    }
}
