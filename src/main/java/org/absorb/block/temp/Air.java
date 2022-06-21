package org.absorb.block.temp;

import org.absorb.block.state.AbsorbBlockStateBuilder;
import org.absorb.block.type.AbsorbBlockType;
import org.absorb.block.type.AbsorbBlockTypeBuilder;
import org.absorb.block.type.properties.mass.MassType;
import org.absorb.utils.Identifiable;

public class Air {

    private static AbsorbBlockStateBuilder buildState() {
        return new AbsorbBlockStateBuilder().setNetworkId(0);
    }

    public static AbsorbBlockType getType() {
        return new AbsorbBlockTypeBuilder()
                .setBlockStates(buildState())
                .setDefaultState(buildState())
                .setName("Air")
                .setKey("air")
                .setMass(MassType.GAS)
                .setHost(Identifiable.MINECRAFT_HOST)
                .setNetworkId(0)
                .build();
    }
}
