package org.absorb.net.packet.play.chunk;

import me.nullicorn.nedit.type.NBTCompound;
import org.absorb.block.state.FullBlockState;
import org.absorb.files.nbt.compound.NBTCompoundBuilder;
import org.absorb.files.nbt.compound.NBTCompoundEntry;
import org.absorb.files.nbt.compound.NBTCompoundKeys;
import org.absorb.net.Client;
import org.absorb.net.data.SerializerUtils;
import org.absorb.net.data.Serializers;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.absorb.utils.AsJson;
import org.absorb.world.area.ChunkPart;
import org.absorb.world.area.ChunkSection;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.configurate.ConfigurateException;

import java.nio.ByteBuffer;
import java.util.*;

public class OutgoingChunkUpdatePacket implements OutgoingPacket {

    private final @NotNull ChunkPart chunk;
    private final boolean trustLightOnEdge;
    private final @NotNull TreeSet<ChunkSection> blockData = new TreeSet<>(Comparator.comparing(ChunkSection::getLevel));

    public static final int ID = 0x22;

    public OutgoingChunkUpdatePacket(OutgoingChunkUpdatePacketBuilder builder) {
        this.chunk = builder.getChunkPart();
        this.trustLightOnEdge = builder.isTrustLightOnEdge();
        this.blockData.addAll(builder.getChunkSections());
    }

    public ChunkPart getChunkPart() {
        return this.chunk;
    }

    public boolean isTrustLightOnEdge() {
        return this.trustLightOnEdge;
    }

    public Set<ChunkSection> getBlockData() {
        return this.blockData;
    }

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public @NotNull PacketState getState() {
        return PacketState.PLAY;
    }

    @Override
    public @NotNull OutgoingPacketBuilder<? extends Packet> toBuilder() {
        return new OutgoingChunkUpdatePacketBuilder()
                .setChunkPart(this.chunk)
                .setTrustLightOnEdge(this.trustLightOnEdge)
                .addChunkSections(this.getBlockData());
    }

    @Override
    public ByteBuffer toBytes(@NotNull Client stream) {
        ByteBuffer chunkX = Serializers.INTEGER.write(this.chunk.getChunk().getPosition().x());
        System.out.println("\tChunkX: " + chunkX + Arrays.toString(chunkX.array()));
        ByteBuffer chunkY = Serializers.INTEGER.write(this.chunk.getChunk().getPosition().y());
        System.out.println("\tChunkY: " + chunkY + Arrays.toString(chunkY.array()));

        NBTCompoundEntry<Long[], Long[]> worldSurface = NBTCompoundKeys.WORLD_SURFACE.withValue(new Long[0]);


        Long[] heightMap = this.chunk.getHeightMap();
        NBTCompoundEntry<Long[], Long[]> motionBlocking = NBTCompoundKeys.MOTION_BLOCKING.withValue(heightMap);
        NBTCompound heightMapCompound = new NBTCompoundBuilder().addAll(worldSurface, motionBlocking).build();
        NBTCompound rootHeightMapCompound = new NBTCompound();
        rootHeightMapCompound.put("", heightMapCompound);
        ByteBuffer heightMapBuffer = Serializers.NBT_COMPOUND_ENTRIES.write(rootHeightMapCompound);
        try {
            System.out.println("\tHeightMap: " + AsJson.asJson(rootHeightMapCompound));
        } catch (ConfigurateException e) {
            e.printStackTrace();
        }

        List<ByteBuffer> chunkSections = this.blockData.stream().map(ChunkSection::write).toList();
        int chunkSectionsSize = chunkSections.parallelStream().mapToInt(sect -> sect.array().length).sum();
        ByteBuffer chunkSectionsSizeBuffer = Serializers.VAR_INTEGER.write(chunkSectionsSize);
        System.out.println("\tChunkSectionSize: " + chunkSectionsSize + Arrays.toString(chunkSectionsSizeBuffer.array()));
        ByteBuffer chunkSectionsBuffer = SerializerUtils.collect(chunkSections);
        System.out.println("ChunkSectionBuffer: " + Arrays.toString(chunkSectionsBuffer.array()));

        //TODO none container tile entities
        ByteBuffer tileEntityCount = Serializers.VAR_INTEGER.write(0);
        System.out.println("TileEntityCount: " + 0 + Arrays.toString(tileEntityCount.array()));
        ByteBuffer trustEdge = Serializers.BOOLEAN.write(this.trustLightOnEdge);
        long[] skyLightArray =
                this.blockData.stream().flatMap(chunk -> chunk.getBlockPallet().stream()).flatMap(pallet -> pallet.getBlocks().stream()).mapToLong(FullBlockState::getSkyLight).toArray();
        ByteBuffer skyLights = Serializers.BITSET.write(BitSet.valueOf(skyLightArray));
        long[] blockLightArray =
                this.blockData.stream().flatMap(chunk -> chunk.getBlockPallet().stream()).flatMap(pallet -> pallet.getBlocks().stream()).mapToLong(FullBlockState::getBlockLight).toArray();
        ByteBuffer blockLight = Serializers.BITSET.write(BitSet.valueOf(blockLightArray));
        long[] emptySkyLightArray = skyLightArray; //TODO
        ByteBuffer emptySkylight = Serializers.BITSET.write(BitSet.valueOf(emptySkyLightArray));
        long[] emptyBlockLightArray = blockLightArray; //TODO
        ByteBuffer emptyBlockLight = Serializers.BITSET.write(BitSet.valueOf(emptyBlockLightArray));
        ByteBuffer skyLightArraysLength = Serializers.VAR_INTEGER.write(0); //TODO -> work this one out
        ByteBuffer blockLightArraysLength = Serializers.VAR_INTEGER.write(0); //TODO -> work this one out

        ByteBuffer bytes = SerializerUtils.createPacket(ID,
                chunkX,
                chunkY,
                heightMapBuffer,
                chunkSectionsSizeBuffer,
                chunkSectionsBuffer,
                tileEntityCount,
                trustEdge,
                skyLights,
                blockLight,
                emptySkylight,
                emptyBlockLight,
                skyLightArraysLength,
                blockLightArraysLength);

        System.out.println("Bytes Size: " + bytes.limit());
        System.out.println("Bytes: " + Arrays.toString(bytes.array()));

        return bytes;
    }
}
