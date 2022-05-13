package org.absorb.net.packet;

import me.nullicorn.nedit.NBTReader;
import me.nullicorn.nedit.type.NBTCompound;
import me.nullicorn.nedit.type.NBTList;
import org.absorb.Main;
import org.absorb.files.nbt.compound.NBTCompoundBuilder;
import org.absorb.files.nbt.compound.NBTCompoundEntry;
import org.absorb.files.nbt.compound.NBTCompoundKeys;
import org.absorb.net.packet.org.absorb.test.utils.CollectionUtils;
import org.absorb.register.RegistryManager;
import org.absorb.world.biome.Biome;
import org.absorb.world.type.PlayerWorldTypeView;
import org.absorb.world.type.WorldType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

public class OngoingJoinPacketTests {

    @Test
    public void biomeCodec() {
        NBTCompound expectedCompound;
        try {
            expectedCompound = NBTReader.read(Main.class.getResourceAsStream("/1.18.2_dim_codec.nbt"));
        } catch (IOException e) {
            e.printStackTrace();
            Assertions.fail("Exception was thrown");
            return;
        }

        //build
        Collection<PlayerWorldTypeView> worldTypes =
                RegistryManager.getVanillaValues(WorldType.class).stream().map(PlayerWorldTypeView::new).toList();

        Collection<Biome> biomesRaw = Set.of();

        NBTCompoundEntry<NBTList, Collection<PlayerWorldTypeView>> types =
                NBTCompoundKeys.DIMENSION.withValue(worldTypes);
        NBTCompound worldTypeCompoundGroup = new NBTCompoundBuilder()
                .addAll(types, NBTCompoundKeys.COMPOUND_TYPE.withValue("minecraft:dimension_type"))
                .build();
        NBTCompoundEntry<NBTList, Collection<Biome>> biomes = NBTCompoundKeys.BIOMES.withValue(biomesRaw);
        NBTCompound biomesCompoundGroup = new NBTCompoundBuilder()
                .addAll(biomes,
                        NBTCompoundKeys.COMPOUND_TYPE.withValue(
                                "minecraft:worldgen/biome"))
                .build();
        NBTCompound biomeCodec =
                new NBTCompoundBuilder()
                        .addAll(NBTCompoundKeys.DIMENSION_TYPE.withValue(worldTypeCompoundGroup),
                                NBTCompoundKeys.WORLD_GEN_BIOME.withValue(biomesCompoundGroup))
                        .build();


        //TEST
        CollectionUtils.match(expectedCompound, biomeCodec);


    }
}
