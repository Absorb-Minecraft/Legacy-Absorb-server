package org.absorb.world.type;

import org.absorb.block.locatable.LocatableBlock;
import org.absorb.block.type.BlockTypes;
import org.absorb.world.World;
import org.absorb.world.area.GeneratedChunk;
import org.absorb.world.biome.Biome;
import org.absorb.world.biome.Biomes;
import org.jetbrains.annotations.NotNull;

public class GeneratedAirChunk implements GeneratedChunk {
	@Override
	public @NotNull LocatableBlock getBlock(int x, int y, int z, @NotNull World world) {
		return new LocatableBlock(BlockTypes.AIR.get().getDefaultBlockState().asBlockData(),
				world.getLocation(x, y, z));
	}

	@Override
	public @NotNull Biome getBiome(int x, int y, int z, @NotNull World world) {
		return Biomes.VOID;
	}
}
