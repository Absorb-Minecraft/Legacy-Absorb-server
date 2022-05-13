package org.absorb.world.type;

import org.absorb.world.type.end.EndWorldType;
import org.absorb.world.type.nether.NetherWorldType;
import org.absorb.world.type.overworld.OverworldCavesType;
import org.absorb.world.type.overworld.OverworldType;

public class WorldTypes {

    public static final OverworldType OVERWORLD = new OverworldType();
    public static final OverworldCavesType OVERWORLD_CAVES = new OverworldCavesType();
    public static final NetherWorldType THE_NETHER = new NetherWorldType();
    public static final EndWorldType THE_END = new EndWorldType();
}
