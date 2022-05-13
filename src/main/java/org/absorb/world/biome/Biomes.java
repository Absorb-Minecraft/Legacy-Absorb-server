package org.absorb.world.biome;

import org.absorb.utils.Identifiable;
import org.absorb.world.biome.properties.BiomePropertiesBuilder;
import org.absorb.world.biome.properties.BiomeWeather;

public interface Biomes {

    Biome PLAIN = new BiomeBuilder()
            .setDefaultProperties(new BiomePropertiesBuilder()
                    .setWeather(BiomeWeather.RAIN)
                    .setWaterColour(0)
                    .setFogColour(12638463)
                    .setWaterFogColour(329011)
                    .setSkyColour(7907327)
                    .build())
            .setNetworkId(1)
            .setDepth(0.125f)
            .setTemperature(0.800000011920929f)
            .setScale(0.05000000074505806f)
            .setDownfall(0.4000000059604645f)
            .setCategory(BiomeCategory.PLAINS)
            .setName("plains")
            .setHost(Identifiable.MINECRAFT_HOST)
            .build();

    Biome CRIMSON_FOREST = new BiomeBuilder()
            .setDefaultProperties(new BiomePropertiesBuilder()
                    .setWaterColour(4159204)
                    .setFogColour(3343107)
                    .setWaterColour(4159204)
                    .setWeather(BiomeWeather.NONE)
                    .build())
            .setName("crimson_forest")
            .setHost(Identifiable.MINECRAFT_HOST)
            .setNetworkId(53)
            .setTemperature(2.0f)
            .setDownfall(0.0f)
            .setCategory(BiomeCategory.NETHER)
            .build();
}
