package org.absorb.net.packet.play.outgoing.client.join;

import me.nullicorn.nedit.NBTReader;
import me.nullicorn.nedit.type.NBTCompound;
import me.nullicorn.nedit.type.NBTList;
import org.absorb.Main;
import org.absorb.files.nbt.compound.NBTCompoundBuilder;
import org.absorb.files.nbt.compound.NBTCompoundEntry;
import org.absorb.files.nbt.compound.NBTCompoundKeys;
import org.absorb.net.packet.OnWiki;
import org.absorb.net.packet.PacketState;
import org.absorb.net.packet.WikiUtils;
import org.absorb.register.RegistryManager;
import org.absorb.test.utils.CollectionUtils;
import org.absorb.world.biome.Biome;
import org.absorb.world.type.PlayerWorldTypeView;
import org.absorb.world.type.WorldType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@OnWiki(state = PacketState.PLAY, urlTitle = "Login_.28play.29")
public class OngoingJoinPacketTest {

    public boolean canFindFile() {
        try {
            NBTReader.read(Main.class.getResourceAsStream("/codec.json"));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * This checks if the packet id is the latest on the wiki. If it isn't then this packet needs updating.
     * <p>
     * Packet Id's are normally the first to be changed and therefore typically a good lightweight point of call for
     * when the protocol has changed and where.
     * <p>
     * This will be skipped if there is a connection issue to the file page, however if the title url has changed, it
     * will not be skipped. This accounts for when the Wiki changes the title name
     */
    @Test
    public void testPacketId() {
        WikiUtils.WikiEntry wikiEntry;
        try {
            wikiEntry = WikiUtils.getEntry(this);
        } catch (RuntimeException e) {
            Assertions.fail(e);
            return;
        } catch (IOException e) {
            Assumptions.assumeFalse(true, "Cannot connect to Minecraft protocol Wiki");
            return;
        }
        Assertions.assertEquals(wikiEntry.getId(), OutgoingJoinPacket.ID);
    }

    @Test
    public void testBiomeCodec() {
        Assumptions.assumeTrue(this.canFindFile());

        NBTCompound expectedCompound;
        try {
            expectedCompound = NBTReader.read(Main.class.getResourceAsStream("/codec.json"));
        } catch (IOException e) {
            e.printStackTrace();
            Assertions.fail("Exception was thrown");
            return;
        }

        //build
        Collection<PlayerWorldTypeView> worldTypes = RegistryManager
                .getVanillaValues(WorldType.class)
                .stream()
                .map(PlayerWorldTypeView::new)
                .toList();

        Collection<Biome> biomesRaw = RegistryManager.getVanillaValues(Biome.class).stream().toList();

        NBTCompoundEntry<NBTList, Collection<PlayerWorldTypeView>> types = NBTCompoundKeys.DIMENSION.withValue(
                worldTypes);
        NBTCompound worldTypeCompoundGroup = new NBTCompoundBuilder()
                .addAll(types, NBTCompoundKeys.COMPOUND_TYPE.withValue("minecraft:dimension_type"))
                .build();
        NBTCompoundEntry<NBTList, Collection<Biome>> biomes = NBTCompoundKeys.BIOMES.withValue(biomesRaw);
        NBTCompound biomesCompoundGroup = new NBTCompoundBuilder()
                .addAll(biomes, NBTCompoundKeys.COMPOUND_TYPE.withValue("minecraft:worldgen/biome"))
                .build();
        NBTCompound biomeCodec = new NBTCompoundBuilder()
                .addAll(NBTCompoundKeys.DIMENSION_TYPE.withValue(worldTypeCompoundGroup),
                        NBTCompoundKeys.WORLD_GEN_BIOME.withValue(biomesCompoundGroup))
                .build();


        //TEST
        CollectionUtils.match(expectedCompound, biomeCodec);
    }

    @Test
    public void testBiomeCodecExtra() {
        Assumptions.assumeTrue(this.canFindFile());


        NBTCompound expectedCompound;
        try {
            expectedCompound = NBTReader.read(Main.class.getResourceAsStream("/1.18.2_dim_codec.nbt"));
        } catch (IOException e) {
            e.printStackTrace();
            Assertions.fail("Exception was thrown");
            return;
        }

        //build
        Collection<PlayerWorldTypeView> worldTypes = RegistryManager
                .getVanillaValues(WorldType.class)
                .stream()
                .map(PlayerWorldTypeView::new)
                .toList();

        List<Biome> biomesRaw = RegistryManager
                .getVanillaValues(Biome.class)
                .stream()
                .sorted(Comparator.comparing(Biome::getNetworkId))
                .collect(Collectors.toList());

        NBTCompoundEntry<NBTList, Collection<PlayerWorldTypeView>> types = NBTCompoundKeys.DIMENSION.withValue(
                worldTypes);
        NBTCompound worldTypeCompoundGroup = new NBTCompoundBuilder()
                .addAll(types, NBTCompoundKeys.COMPOUND_TYPE.withValue("minecraft:dimension_type"))
                .build();
        NBTCompoundEntry<NBTList, Collection<Biome>> biomes = NBTCompoundKeys.BIOMES.withValue(biomesRaw);
        NBTCompound biomesCompoundGroup = new NBTCompoundBuilder()
                .addAll(biomes, NBTCompoundKeys.COMPOUND_TYPE.withValue("minecraft:worldgen/biome"))
                .build();
        NBTCompound biomeCodec = new NBTCompoundBuilder()
                .addAll(NBTCompoundKeys.DIMENSION_TYPE.withValue(worldTypeCompoundGroup),
                        NBTCompoundKeys.WORLD_GEN_BIOME.withValue(biomesCompoundGroup))
                .build();

        //TEST
        CollectionUtils.match(biomeCodec, expectedCompound);
    }


}
