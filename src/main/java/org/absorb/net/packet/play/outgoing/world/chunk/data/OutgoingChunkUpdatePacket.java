package org.absorb.net.packet.play.outgoing.world.chunk.data;

import me.nullicorn.nedit.NBTOutputStream;
import me.nullicorn.nedit.type.NBTCompound;
import org.absorb.net.Client;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.data.NetUtils;
import org.absorb.net.packet.OutgoingPacket;
import org.absorb.net.packet.OutgoingPacketBuilder;
import org.absorb.net.packet.Packet;
import org.absorb.net.packet.PacketState;
import org.absorb.world.area.AbsorbChunk;
import org.absorb.world.area.ChunkPart;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.*;

public class OutgoingChunkUpdatePacket implements OutgoingPacket {

    private final @NotNull AbsorbChunk chunk;
    private final boolean trustLightOnEdge;
    private final @NotNull TreeSet<ChunkPart> blockData = new TreeSet<>(Comparator.comparing(ChunkPart::getLevel));

    public static final int ID = 0x1F;

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
            ByteBuffer chunkX = NetSerializers.INTEGER.write(this.chunk.getPosition().x());
            nbtOS.write(chunkX.array());

            ByteBuffer chunkY = NetSerializers.INTEGER.write(this.chunk.getPosition().y());
            nbtOS.write(chunkY.array());

            System.out.println("Spawning chunk: " + this.chunk.getPosition());


            NBTCompound heightMap = this.chunk.getHeightMap();
            nbtOS.writeFully(heightMap);

            List<ByteBuffer> chunkSections = this.blockData.stream().map(part -> part.asSection().write()).toList();
            int chunkSectionsSize = chunkSections.parallelStream().mapToInt(sect -> sect.array().length).sum();
            ByteBuffer chunkSectionsSizeBuffer = NetSerializers.VAR_INTEGER.write(chunkSectionsSize);
            nbtOS.write(chunkSectionsSizeBuffer.array());

            ByteBuffer chunkSectionsBuffer = NetUtils.collect(chunkSections);
            nbtOS.write(chunkSectionsBuffer.array());

            //TODO none container tile entities
            ByteBuffer tileEntityCount = NetSerializers.VAR_INTEGER.write(0);
            nbtOS.write(tileEntityCount.array());


            ByteBuffer trustEdge = NetSerializers.BOOLEAN.write(this.trustLightOnEdge);
            nbtOS.write(trustEdge.array());

            BitSet hasSkylight = new BitSet();
            List<ChunkPart> parts = new ArrayList<>(this.blockData);
            for (int index = 0; index < this.blockData.size(); index++) {
                //1 for if any block in the section has skylight light
                hasSkylight.set(index, false); //false as skylight array must also have it
            }
            ByteBuffer skyLights = NetSerializers.BITSET.write(hasSkylight);
            nbtOS.write(skyLights.array());

            BitSet hasBlockLight = new BitSet();
            for (int index = 0; index < this.blockData.size(); index++) {
                //1 for if any block in the section has
                hasSkylight.set(index, false); //false as skylight array must also have it
            }
            ByteBuffer blockLight = NetSerializers.BITSET.write(hasBlockLight);
            nbtOS.write(blockLight.array());

            //long[] emptySkyLightArray = ; //TODO
            ByteBuffer emptySkylight = NetSerializers.BITSET.write(new BitSet());
            nbtOS.write(emptySkylight.array());

            //long[] emptyBlockLightArray = blockLightArray; //TODO
            ByteBuffer emptyBlockLight = NetSerializers.BITSET.write(new BitSet());
            nbtOS.write(emptyBlockLight.array());

            ByteBuffer skyLightArraysLength = NetSerializers.VAR_INTEGER.write(0); //TODO -> work this one out
            nbtOS.write(skyLightArraysLength.array());

            ByteBuffer blockLightArraysLength = NetSerializers.VAR_INTEGER.write(0); //TODO -> work this one out
            nbtOS.write(blockLightArraysLength.array());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        ByteBuffer ret = ByteBuffer.wrap(baos.toByteArray());
        return NetUtils.createPacket(ID, ret);

    }
}
