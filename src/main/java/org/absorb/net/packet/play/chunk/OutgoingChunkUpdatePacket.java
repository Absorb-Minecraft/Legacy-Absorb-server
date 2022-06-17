package org.absorb.net.packet.play.chunk;

import me.nullicorn.nedit.NBTOutputStream;
import me.nullicorn.nedit.type.NBTCompound;
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
import org.absorb.world.area.AbsorbChunk;
import org.absorb.world.area.ChunkPart;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.configurate.ConfigurateException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.*;

public class OutgoingChunkUpdatePacket implements OutgoingPacket {

    private final @NotNull AbsorbChunk chunk;
    private final boolean trustLightOnEdge;
    private final @NotNull TreeSet<ChunkPart> blockData = new TreeSet<>(Comparator.comparing(ChunkPart::getLevel));

    public static final int ID = 0x22;

    public OutgoingChunkUpdatePacket(OutgoingChunkUpdatePacketBuilder builder) {
        this.chunk = builder.getChunk();
        this.trustLightOnEdge = builder.isTrustLightOnEdge();
        this.blockData.addAll(builder.getParts());
    }

    public @NotNull AbsorbChunk getChunk() {
        return this.chunk;
    }

    public boolean isTrustLightOnEdge() {
        return this.trustLightOnEdge;
    }

    public Set<ChunkPart> getParts() {
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
                .setChunk(this.chunk)
                .setTrustLightOnEdge(this.trustLightOnEdge)
                .addParts(this.getParts());
    }

    @Override
    public ByteBuffer toBytes(@NotNull Client stream) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        NBTOutputStream nbtOS;
        try {
            nbtOS = new NBTOutputStream(baos, false);


            ByteBuffer chunkX = Serializers.INTEGER.write(this.chunk.getPosition().x());
            nbtOS.write(chunkX.array());
            System.out.println("\tChunkX: " + this.chunk.getPosition().x() + Arrays.toString(chunkX.array()));


            ByteBuffer chunkY = Serializers.INTEGER.write(this.chunk.getPosition().y());
            nbtOS.write(chunkY.array());
            System.out.println("\tChunkY: " + this.chunk.getPosition().y() + Arrays.toString(chunkY.array()));


            NBTCompoundEntry<Long[], Long[]> worldSurface = NBTCompoundKeys.WORLD_SURFACE.withValue(new Long[0]);
            byte[] heightMap = this.chunk.getHeightMap();
            Long[] longHeightMap = new Long[heightMap.length];
            for (int index = 0; index < heightMap.length; index++) {
                longHeightMap[index] = (long) heightMap[index];
            }
            NBTCompoundEntry<Long[], Long[]> motionBlocking = NBTCompoundKeys.MOTION_BLOCKING.withValue(longHeightMap);
            NBTCompound heightMapCompound = new NBTCompoundBuilder().addAll(worldSurface, motionBlocking).build();
            NBTCompound rootHeightMapCompound = new NBTCompound();
            rootHeightMapCompound.put("", heightMapCompound);
            nbtOS.writeFully(rootHeightMapCompound);
            try {
                System.out.println("\tHeightMap: " + AsJson.asJson(rootHeightMapCompound));
            } catch (ConfigurateException e) {
                e.printStackTrace();
            }

            List<ByteBuffer> chunkSections = this.blockData.stream().map(part -> part.asSection().write()).toList();
            int chunkSectionsSize = chunkSections.parallelStream().mapToInt(sect -> sect.array().length).sum();
            ByteBuffer chunkSectionsSizeBuffer = Serializers.VAR_INTEGER.write(chunkSectionsSize);
            nbtOS.write(chunkSectionsSizeBuffer.array());
            System.out.println("\tChunkSectionSize: " + chunkSectionsSize + Arrays.toString(chunkSectionsSizeBuffer.array()));

            ByteBuffer chunkSectionsBuffer = SerializerUtils.collect(chunkSections);
            nbtOS.write(chunkSectionsBuffer.array());
            System.out.println("ChunkSectionBuffer: (" + chunkSectionsBuffer.array().length + ")" + Arrays.toString(chunkSectionsBuffer.array()));

            //TODO none container tile entities
            ByteBuffer tileEntityCount = Serializers.VAR_INTEGER.write(0);
            System.out.println("TileEntityCount: " + 0 + Arrays.toString(tileEntityCount.array()));
            nbtOS.write(tileEntityCount.array());


            ByteBuffer trustEdge = Serializers.BOOLEAN.write(this.trustLightOnEdge);
            nbtOS.write(trustEdge.array());

            BitSet hasSkylight = new BitSet();
            List<ChunkPart> parts = new ArrayList<>(this.blockData);
            for (int index = 0; index < this.blockData.size(); index++) {
                //1 for if any block in the section has skylight light
                hasSkylight.set(index, false); //false as skylight array must also have it
            }
            ByteBuffer skyLights = Serializers.BITSET.write(hasSkylight);
            nbtOS.write(skyLights.array());

            BitSet hasBlockLight = new BitSet();
            for (int index = 0; index < this.blockData.size(); index++) {
                //1 for if any block in the section has
                hasSkylight.set(index, false); //false as skylight array must also have it
            }
            ByteBuffer blockLight = Serializers.BITSET.write(hasBlockLight);
            nbtOS.write(blockLight.array());

            //long[] emptySkyLightArray = ; //TODO
            ByteBuffer emptySkylight = Serializers.BITSET.write(new BitSet());
            nbtOS.write(emptySkylight.array());

            //long[] emptyBlockLightArray = blockLightArray; //TODO
            ByteBuffer emptyBlockLight = Serializers.BITSET.write(new BitSet());
            nbtOS.write(emptyBlockLight.array());

            ByteBuffer skyLightArraysLength = Serializers.VAR_INTEGER.write(0); //TODO -> work this one out
            nbtOS.write(skyLightArraysLength.array());

            ByteBuffer blockLightArraysLength = Serializers.VAR_INTEGER.write(0); //TODO -> work this one out
            nbtOS.write(blockLightArraysLength.array());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        ByteBuffer ret = ByteBuffer.wrap(baos.toByteArray());
        return SerializerUtils.createPacket(ID, ret);

    }
}
