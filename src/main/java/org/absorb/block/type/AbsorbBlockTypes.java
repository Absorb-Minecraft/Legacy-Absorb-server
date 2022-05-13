package org.absorb.block.type;


import org.absorb.utils.Identifiable;

public class AbsorbBlockTypes {
    public static final BlockTypeRegistry AIR =
            new BlockTypeRegistry(Identifiable.MINECRAFT_HOST,
                    "air", "Air");
    public static final BlockTypeRegistry CAVE_AIR = new BlockTypeRegistry(Identifiable.MINECRAFT_HOST, "cave_air", "Cave Air");
    public static final BlockTypeRegistry VOID_AIR = new BlockTypeRegistry(Identifiable.MINECRAFT_HOST, "void_air", "Void Air");
    public static final BlockTypeRegistry BEDROCK = new BlockTypeRegistry(Identifiable.MINECRAFT_HOST, "bedrock",
            "Bedrock");
}
