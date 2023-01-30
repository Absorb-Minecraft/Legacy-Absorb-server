package org.absorb.block.palette.block;

import org.absorb.block.locatable.BlockData;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.utils.compare.Vector3Compare;
import org.spongepowered.math.vector.Vector3i;

import java.nio.ByteBuffer;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class IndirectPalette implements BlockPalette {

	private final static class BlockMappings {
		private final Vector3i location;
		private final BlockData state;

		private BlockMappings(Vector3i location, BlockData state) {
			this.location = location;
			this.state = state;
		}

		public Vector3i getLocation() {
			return this.location;
		}

		public BlockData getState() {
			return this.state;
		}
	}

	private final List<BlockMappings> mappings = new LinkedList<>();
	private final byte bitsPerEntry;

	public IndirectPalette(byte bitsPerEntry) {
		if (bitsPerEntry < 4) {
			bitsPerEntry = 4;
		}
		this.bitsPerEntry = bitsPerEntry;
	}

	public void addBlock(Vector3i location, BlockData state) {
		this.mappings.add(new BlockMappings(location, state));

	}

	@Override
	public Map<Vector3i, BlockData> getBlocks() {
		return this.mappings.parallelStream().collect(Collectors.toMap(BlockMappings::getLocation,
				BlockMappings::getState));
	}

	@Override
	public ByteBuffer write() {
		ByteBuffer bitsPerEntryBuffer = NetSerializers.BYTE.write(this.bitsPerEntry < 4 ? 4 : this.bitsPerEntry);

		Collection<Integer> palette =
				this
						.mappings
						.parallelStream()
						.sorted((blockMappings, t1) -> Vector3Compare.XYZ_I.compare(blockMappings.getLocation(),
								t1.getLocation()))
						.map(mappings -> mappings
								.getState()
								.getState()
								.getNetworkId())
						.toList();
		List<Integer> uniquePalette = palette.parallelStream().distinct().toList();


		ByteBuffer uniquePaletteSizeBuffer = NetSerializers.VAR_INTEGER.write(uniquePalette.size());
		ByteBuffer uniquePaletteBuffer =
				NetUtils.collect(uniquePalette.parallelStream().map(NetSerializers.VAR_INTEGER::write).toList());

		String asBits = palette.stream().map(current -> {
			int indexOf = uniquePalette.indexOf(current);
			String indexOfString = Integer.toString(indexOf, 2);
			while (indexOfString.length() < 4) {
				indexOfString = '0' + indexOfString;
			}
			return indexOfString;
		}).collect(Collectors.joining(""));
		List<Long> longData = Pattern.compile("/.{1,64}/g")
				.matcher(asBits)
				.results()
				.map(MatchResult::group)
				.map(Long::parseLong)
				.toList();
		ByteBuffer dataArray = NetSerializers.array(NetSerializers.LONG).write(longData);


		return NetUtils.collect(
				Arrays.asList(bitsPerEntryBuffer, uniquePaletteSizeBuffer, uniquePaletteBuffer, dataArray));
	}
}
