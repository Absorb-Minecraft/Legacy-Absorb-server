package org.absorb.block.type;


import org.absorb.block.type.properties.mass.MassType;
import org.absorb.inventory.item.ItemTypes;
import org.absorb.register.registry.BuilderRegister;
import org.absorb.utils.Identifiable;

import java.util.function.Function;

public class BlockTypes {

    public static final BuilderRegister<BlockType> AIR = gen("Air", "air",
            builder -> builder.setMass(MassType.GAS).setNetworkId(0).setItem(ItemTypes.AIR));

    public static final BuilderRegister<BlockType> CAVE_AIR = gen("Cave Air", "cave_air",
            builder -> builder.setMass(MassType.GAS).setNetworkId(0).setItem(ItemTypes.AIR));

    public static final BuilderRegister<BlockType> VOID_AIR = gen("Void Air", "void_air",
            builder -> builder.setMass(MassType.GAS).setNetworkId(0).setItem(ItemTypes.AIR));
    public static final BuilderRegister<BlockType> BEDROCK = gen("Bedrock", "bedrock",
            builder -> builder.setMass(MassType.SOLID).setNetworkId(25).setItem(ItemTypes.BEDROCK));

    private static BuilderRegister<BlockType> gen(String name, String key, Function<BlockTypeBuilder,
            BlockTypeBuilder> function) {
        return new BuilderRegister<>(name, Identifiable.MINECRAFT_HOST, key, () -> function.apply(new BlockTypeBuilder().setHost(Identifiable.MINECRAFT_HOST).setKey(key).setName(name)).build());

    }
}
