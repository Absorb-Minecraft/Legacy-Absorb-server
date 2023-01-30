package org.absorb.world.area;

import org.absorb.block.BlockTags;
import org.absorb.block.locatable.BlockData;
import org.absorb.block.palette.biome.BiomePalette;
import org.absorb.block.palette.biome.SingledBiomePalette;
import org.absorb.block.palette.block.BlockPalette;
import org.absorb.block.type.BlockTypes;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.world.biome.Biomes;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3i;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;
import java.util.stream.Collectors;

public class ChunkSection {

	private final Collection<BlockPalette> blockPallets = new LinkedTransferQueue<>();
	private final Collection<BiomePalette> biomePallets = new LinkedTransferQueue<>();
	private final int level;

	private static final int BLOCK_STATES_LIMIT = 4096;
	private static final int BIOME_STATES_LIMIT = 64;

	public ChunkSection(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}

	public void addBlockPallet(@NotNull BlockPalette pallet) {
		try {
			this.blockPallets.add(pallet);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void addBiomePallet(@NotNull BiomePalette pallet) {
		this.biomePallets.add(pallet);
	}

	public Collection<BlockPalette> getBlockPallet() {
		return Collections.unmodifiableCollection(this.blockPallets);
	}

	public Collection<BiomePalette> getBiomePallet() {
		return Collections.unmodifiableCollection(this.biomePallets);
	}

	public ByteBuffer write() {
		Collection<BlockData> blocks = this.blockPallets
				.stream()
				.flatMap(blockPallet -> blockPallet.getBlocks().values().parallelStream())
				.filter(entry -> !BlockTypes.AIR.isEqual(entry.getState().getType()))
				.filter(entry -> !BlockTypes.CAVE_AIR.isEqual(entry.getState().getType()))
				.filter(entry -> !BlockTypes.VOID_AIR.isEqual(entry.getState().getType()))
				.toList();

		short blockCount = (short) blocks.size();
		ByteBuffer blockCountBuffer = NetSerializers.SHORT.write(blockCount);
		List<BlockPalette> orderedBlocks = this.blockPallets
				.parallelStream()
				.sorted((o1, o2) -> o1.compareOnBlockLocation().compare(o1, o2))
				.toList();
		int shortenList = this.blockPallets.size();
		for (int i = shortenList; i >= 0; i--) {
			if (!orderedBlocks.get(i - 1)
					.getBlocks()
					.values()
					.parallelStream()
					.allMatch(blockData -> BlockTags.AIR.contains(blockData.getState()
							.getType()))) {
				break;
			}
			shortenList = i;
		}

		List<ByteBuffer> blockBuffers = orderedBlocks.subList(0, shortenList).stream()
				.map(BlockPalette::write)
				.collect(Collectors.toCollection(LinkedList::new));
		if (blockBuffers.size() != BLOCK_STATES_LIMIT) {
			int sizeBefore = blockBuffers.size();
			if (sizeBefore > BLOCK_STATES_LIMIT) {
				throw new RuntimeException(
						"Blocks exceeded maximum per chunk: Max: " + BLOCK_STATES_LIMIT + " " + "Currently: "
								+ sizeBefore);
			}
		}
		ByteBuffer blockBuffer = NetUtils.collect(blockBuffers);

		if (this.biomePallets.isEmpty()) {
			this.biomePallets.add(new SingledBiomePalette(Biomes.VOID, new Vector3i(0, 0, 0)));
		}
		List<ByteBuffer> biomeBuffers = this.biomePallets
				.stream()
				.map(BiomePalette::write)
				.collect(Collectors.toCollection(LinkedList::new));
		if (biomeBuffers.size() != BIOME_STATES_LIMIT) {
			int sizeBefore = biomeBuffers.size();
			if (sizeBefore > BIOME_STATES_LIMIT) {
				throw new RuntimeException(
						"Biome blocks exceeded maximum per chunk: Max: " + BIOME_STATES_LIMIT + " " + "Currently: "
								+ sizeBefore);
			}
		}

		ByteBuffer biomeBuffer = NetUtils.collect(biomeBuffers);
		return NetUtils.collect(blockCountBuffer, blockBuffer, biomeBuffer);

	}


}
